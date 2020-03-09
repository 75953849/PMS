package com.tyut.service.impl;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyut.common.utils.AttUtils;
import com.tyut.common.utils.Page;
import com.tyut.mapper.MainattMapper;
import com.tyut.mapper.SubattMapper;
import com.tyut.po.Mainatt;
import com.tyut.po.MainattExample;
import com.tyut.po.Subatt;
import com.tyut.po.SubattExample;
import com.tyut.po.SubattExample.Criteria;
import com.tyut.po.SubattSearchItem;
import com.tyut.po.vo.MainattVo;
import com.tyut.po.vo.SubattVo;
import com.tyut.service.AttendanceService;
import com.tyut.test.PropertiesTest;




@Service
public class AttendanceServiceImpl implements AttendanceService {
	
	@Autowired
	private SubattMapper subattMapper;
	@Autowired
	private MainattMapper mainattMapper;
	
	//private String a = PropertiesTest.getValue("");
	
	@Override
	public int addAttendanceItemWithWorkInTheMorning(Subatt subatt) {
		// TODO Auto-generated method stub
		//上午上班打卡
		//1.插入subatt
		/*
		 * 8点以后为迟到，8点整以及8点前为正常。
		 * 8点前后30分钟为打卡时间，过了这个范围不可为上午上班签到-----不在此处实现，默认此处在此范围内
		 */
		
		Date attDate = subatt.getAttDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(attDate);
		
		Date time1 = AttUtils.getSameDayDateByHms(calendar, 7, 30, 0);
		Date time2 = AttUtils.getSameDayDateByHms(calendar, 8, 30, 0);
		
		SubattExample exa = new SubattExample();
		Criteria cri = exa.createCriteria();
		cri.andEmpIdEqualTo(subatt.getEmpId());
		cri.andAttDateBetween(time1, time2);
		int count = subattMapper.countByExample(exa );
		
		if(attDate.before(time1)||attDate.after(time2)) {
			return 10;	//未在上午打卡时间内
		}
		if(count!=0) {
			return 100;
		}
		
		Date time = AttUtils.getSameDayDateByHms(calendar, 8, 0, 0);	//获取8点整时刻
		
		if(attDate.after(time)) {
			//8点以后签到，为迟到
			subatt.setAttState(1);
		}else {
			//上午未迟到
			subatt.setAttState(10);
		}
		subattMapper.insert(subatt);
		Integer subattId = subattMapper.selectLastInsertId();
		
		//2.插入mainatt
		Mainatt mainatt = new Mainatt();
		mainatt.setEmpId(subatt.getEmpId());
		mainatt.setDepId(subatt.getDepId());
		mainatt.setAmDate1Id(subattId);
		mainatt.setAmState(2);
		mainatt.setPmState(1);
		mainattMapper.insertSelective(mainatt);
		
		return 0;
	}
	@Override
	public int addAttendanceItemWithWorkInTheAfternoon(Subatt subatt) {
		// TODO Auto-generated method stub
		//下午签到
		//1.插入subatt
		Date attDate = subatt.getAttDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(attDate);
		
		Date time1 = AttUtils.getSameDayDateByHms(calendar, 13, 30, 0);
		Date time2 = AttUtils.getSameDayDateByHms(calendar, 14, 30, 0);
		
		SubattExample exa = new SubattExample();
		Criteria cri = exa.createCriteria();
		cri.andEmpIdEqualTo(subatt.getEmpId());
		cri.andAttDateBetween(time1, time2);
		int count = subattMapper.countByExample(exa );
		
		if(attDate.before(time1)||attDate.after(time2)) {
			return 30;	//未在下午签到时间内
		}
		if(count!=0) {
			return 300;
		}
		
		Date time = AttUtils.getSameDayDateByHms(calendar, 14, 0, 0);
		if(attDate.after(time)) {
			//迟到
			subatt.setAttState(3);
		}else {
			subatt.setAttState(30);
		}
		subattMapper.insert(subatt);
		Integer subattId = subattMapper.selectLastInsertId();
		
		
		//2.插入mainatt
		/*
		 * 1.首先看上午是否有记录
		 * 2.上午若有记录，则必有上午签到记录， 签退可有可无
		 */
		//上午签到时间如下
				int bhour = 7;
				int bmin = 30;
				int bsec = 0;
				
				int ehour = 8;
				int emin = 30;
				int esec = 0;
		
		Date btime = AttUtils.getSameDayDateByHms(calendar, bhour, bmin, bsec);
		Date etime = AttUtils.getSameDayDateByHms(calendar, ehour, emin, esec);
				
		SubattExample example = new SubattExample();
		Criteria where = example.createCriteria();
		where.andEmpIdEqualTo(subatt.getEmpId());
		where.andAttDateBetween(btime, etime);
		List<Subatt> subatts = subattMapper.selectByExample(example);
		
		Mainatt mainatt = new Mainatt();
		mainatt.setPmDate1Id(subattId);
		mainatt.setPmState(2);
		if(subatts.isEmpty()) {
			//上午无记录，进行插入操作
			mainatt.setEmpId(subatt.getEmpId());
			mainatt.setDepId(subatt.getDepId());
			mainatt.setAmState(1);
			
			mainattMapper.insertSelective(mainatt);
		}else {		
			//上午有记录，进行update
			MainattExample example2 = new MainattExample();
			com.tyut.po.MainattExample.Criteria where2 = example2.createCriteria();
			where2.andAmDate1IdEqualTo(subatts.get(0).getId());
			mainattMapper.updateByExampleSelective(mainatt, example2);
		}
		return 0;
	}
	@Override
	public int addAttendanceItemWithoutWorkInTheMorning(Subatt subatt) {
		// TODO Auto-generated method stub
		//上午下班
		//1.插入subatt		----此处要先判断能否插入，规则：上午未签到不可签退
		/*
		 * 12点以前为早退，12点整以及12点后为正常。
		 * 12点前后30分钟为打卡时间，过了这个范围不可为上午签退-----不在此处实现，默认此处在此范围内
		 */
		Date attDate = subatt.getAttDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(attDate);
		
		Date time1 = AttUtils.getSameDayDateByHms(calendar, 11, 30, 0);
		Date time2 = AttUtils.getSameDayDateByHms(calendar, 12, 30, 0);
		
		SubattExample exa = new SubattExample();
		Criteria cri = exa.createCriteria();
		cri.andEmpIdEqualTo(subatt.getEmpId());
		cri.andAttDateBetween(time1, time2);
		int count = subattMapper.countByExample(exa );
		
		if(attDate.before(time1)||attDate.after(time2)) {
			return 20;	//未在上午签退时间内
		}
		if(count!=0) {
			return 200;
		}
		//2.插入mainatt
		/*
		 * 上午未签到，此处不可为上午签退
		 */
		//2.1查询当日上午是否签到     上午签到时间为7:30到8：30
		
		//上午签到时间如下
		int bhour = 7;
		int bmin = 30;
		int bsec = 0;
		
		int ehour = 8;
		int emin = 30;
		int esec = 0;
		
		Date btime = AttUtils.getSameDayDateByHms(calendar, bhour, bmin, bsec);
		
		Date etime = AttUtils.getSameDayDateByHms(calendar, ehour, emin, esec);
		
		System.out.println(btime);
		System.out.println(etime);
		
		SubattExample example = new SubattExample();
		Criteria where = example.createCriteria();
		where.andEmpIdEqualTo(subatt.getEmpId());
		where.andAttDateBetween(btime, etime);
		List<Subatt> subatts = subattMapper.selectByExample(example );
		
		if(subatts.isEmpty()) {
			//无记录，说明上午未签到，此处不可签退
			return 1;		//1表示上午未签到，不可签退
		}else {
			//上午有记录，可直接更新
			
			
			Date time = AttUtils.getSameDayDateByHms(calendar, 12, 0, 0);
			if(attDate.before(time)) {
				//12点前签退，为上午下班早退
				subatt.setAttState(2);
			}else {
				//正常
				subatt.setAttState(20);
			}
			subattMapper.insert(subatt);
			Integer subattId = subattMapper.selectLastInsertId();
			
			
			
			
			Mainatt mainatt = new Mainatt();
			mainatt.setAmDate2Id(subattId);
			mainatt.setAmState(0);
			
			//开始update  mainatt
			
			MainattExample example2 = new MainattExample();
			com.tyut.po.MainattExample.Criteria where2 = example2.createCriteria();
			where2.andEmpIdEqualTo(subatt.getEmpId());
			where2.andAmDate1IdEqualTo(subatts.get(0).getId());
			mainattMapper.updateByExampleSelective(mainatt, example2 );
			return 0;
		}
		
		
	}
	@Override
	public int addAttendanceItemWithoutWorkInTheAfternoon(Subatt subatt) {
		// TODO Auto-generated method stub
		//下午下班签退
		//1.判断下午是否签到
		//下午签到时间如下
		int bhour = 13;
		int bmin = 30;
		int bsec = 0;
		
		int ehour = 14;
		int emin = 30;
		int esec = 0;
		
		Date attDate = subatt.getAttDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(attDate);
		
		
		Date time1 = AttUtils.getSameDayDateByHms(calendar, 17, 30, 0);
		Date time2 = AttUtils.getSameDayDateByHms(calendar, 18, 30, 0);
		
		SubattExample exa = new SubattExample();
		Criteria cri = exa.createCriteria();
		cri.andEmpIdEqualTo(subatt.getEmpId());
		cri.andAttDateBetween(time1, time2);
		int count = subattMapper.countByExample(exa );
		
		if(attDate.before(time1)||attDate.after(time2)) {
			return 40;	//未在下午签退时间内
		}
		if(count!=0) {
			return 400;
		}
		
		Date btime = AttUtils.getSameDayDateByHms(calendar, bhour, bmin, bsec);
		Date etime = AttUtils.getSameDayDateByHms(calendar, ehour, emin, esec);
		
		SubattExample example = new SubattExample();
		Criteria where = example.createCriteria();
		where.andEmpIdEqualTo(subatt.getEmpId());
		where.andAttDateBetween(btime, etime);
		List<Subatt> subatts = subattMapper.selectByExample(example );
		
		if(subatts.isEmpty()) {
			//下午未签到，不可签退
			return 2;	//表示下午签退失败
		}else {
			//下午已签到。可以签退，进行更新操作
			
			//2.1先插入subatt
			Date time = AttUtils.getSameDayDateByHms(calendar, 18, 0, 0);
			if(attDate.before(time)) {
				//下午早退
				subatt.setAttState(4);
			}else {
				subatt.setAttState(40);
			}
			subattMapper.insert(subatt);
			Integer subattId = subattMapper.selectLastInsertId();
			
			//2.2更新mainatt
			Mainatt mainatt = new Mainatt();
			mainatt.setPmDate2Id(subattId);
			mainatt.setPmState(0);
			
			
			MainattExample example2 = new MainattExample();
			com.tyut.po.MainattExample.Criteria where2 = example2.createCriteria();
			where2.andPmDate1IdEqualTo(subatts.get(0).getId());
			mainattMapper.updateByExampleSelective(mainatt, example2);
			return 0;	//succeed
			
		}
	}
	@Override
	public Page<Subatt> findAllSubattWithMappingPage(int page, int rows, SubattSearchItem ssi) {
		// TODO Auto-generated method stub
		SubattVo vo = new SubattVo();
		vo.setJump((page-1)*rows);
		vo.setRows(rows);
		Criteria where = vo.createCriteria();
		if(ssi.getDepId()!=null) {
			if(ssi.getDepId()!=0) {
				where.andDepIdEqualTo(ssi.getDepId());
			}
		}
		if(ssi.getEmpId()!=null) {
			where.andEmpIdEqualTo(ssi.getEmpId());
		}
		
		Date beginTime = ssi.getBeginTime();
		Date endTime = ssi.getEndTime();
		
		
		
		if(beginTime!=null&&endTime!=null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(beginTime);
			Date bTime = AttUtils.getSameDayDateByHms(calendar, 0, 0, 0);
			calendar.setTime(endTime);
			Date eTime = AttUtils.getSameDayDateByHms(calendar, 24, 0, 0);
			where.andAttDateBetween(bTime, eTime);
		}
		
		List<Subatt> list = subattMapper.selectByExampleMappingPage(vo);
		
		Page<Subatt> subatts = new Page<>();
		subatts.setPage(page);
		subatts.setSize(rows);
		subatts.setTotal(subattMapper.countByExample(vo));
		subatts.setRows(list);
		
		return subatts;
	}
	@Override
	public Page<Mainatt> findAllMainattWithMappingPage(int page, int rows) {
		// TODO Auto-generated method stub
		MainattVo vo = new MainattVo();
		vo.setJump((page-1)*rows);
		vo.setRows(rows);
		
		List<Mainatt> list = mainattMapper.selectByExampleMappingPage(vo);
		Page<Mainatt> mainatts = new Page<>();
		mainatts.setPage(page);
		mainatts.setSize(rows);
		mainatts.setTotal(mainattMapper.countByExample(vo));
		mainatts.setRows(list);
		
		return mainatts;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	@Override
	public int insertOrUpdateAttendanceItemWithWorkInTheMorning(Subatt subatt) throws ParseException {
		// TODO Auto-generated method stub
		
		 * 1.插入subatt信息
		 * 注：关键在于subatt的attState
		 * 超过8点算迟到
		 * 2.插入到mainatt中
		 * 3.找整合关系
		 
		
		Date date1 = subatt.getAttDate();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str1 = sdf2.format(date1);	
		String str2 = str1+" 8:00:00";
		Date date2 = sdf.parse(str2);	//当天8点
		
		if(date1.compareTo(date2)==1) {
			//date1大于date2   即大于8点   为上午迟到
			subatt.setAttState(1);
		}else {
			subatt.setAttState(5);
		}
		
		//插入subatt
		subattMapper.insertSelective(subatt);
		//获取插入subatt的id
		Integer subattId = subattMapper.selectLastInsertId();
		System.out.println("subattId="+subattId);
		//2.插入到mainatt
		Mainatt mainatt = new Mainatt();
		mainatt.setEmpId(subatt.getEmpId());
		mainatt.setDepId(subatt.getDepId());
		mainatt.setAmDate1Id(subattId);
		mainatt.setAmState(2);
		mainatt.setPmState(3);
		mainattMapper.insertSelective(mainatt);
		
		return 0;
	}

	@Override
	public int insertOrUpdateAttendanceItemWithWorkInTheAfternoon(Subatt subatt) {
		// TODO Auto-generated method stub
		//
		//下午上班签到
				
				 * 1.插入subatt信息
				 * 注：关键在于subatt的attState	
				 * 早于12点算早退
				 * 2.插入到mainatt中
				 * 3.找整合关系
				 
				
				//.插入subatt

						Date date1 = subatt.getAttDate();
						SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String str1 = sdf2.format(date1);	
						String str2 = str1+" 14:00:00";
						String str3 = str1+" 6:00:00";
						String str4 = str1+" 13:00:00";
						String str5 = str1+" 10:00:00";
						
						
						try {
							Date date2 = sdf.parse(str2);
							if(date1.compareTo(date2)==1) {
								//date1>date2  即下午上班迟到
								subatt.setAttState(3);
							}else {
								subatt.setAttState(5);
							}
							subattMapper.insertSelective(subatt);
							Integer subattId = subattMapper.selectLastInsertId();
							
							//2.插入mainatt
							
							 * 1.首先判断上午是否有记录
							 * 2.若没有，则直接插入，置其他为空
							 * 3.若有，则更新即可
							 
							
							Date date3 = sdf.parse(str3);	//6点
							Date date4 = sdf.parse(str4);	//13点
							Date date5 = sdf.parse(str5);	//10点
							
							
							//查找上午是否有记录
							SubattExample example = new SubattExample();
							Criteria where = example.createCriteria();
							where.andEmpIdEqualTo(subatt.getEmpId());
							where.andAttDateBetween(date3, date4);
							List<Subatt> subatts = subattMapper.selectByExample(example);
							int subattCount = subattMapper.countByExample(example);
							
							Mainatt mainatt = new Mainatt();
							mainatt.setPmDate1Id(subattId);
							mainatt.setPmState(2);
							if(subatts.isEmpty()) {
								//上午无记录----insert
								//置上午为空
							
								mainatt.setEmpId(subatt.getEmpId());
								mainatt.setDepId(subatt.getDepId());
								mainatt.setAmState(3);
								
								mainattMapper.insertSelective(mainatt);
							}else {
								//上午有记录----update
								Integer subId1 = subatts.get(0).getId();	//List中第一个subatt的id
								
								MainattExample example2 = new MainattExample();
								com.tyut.po.MainattExample.Criteria where2 = example2.createCriteria();
								
								
								if(subattCount==2) {
									//上午两个记录都有
									where2.andAmDate1IdEqualTo(subId1);
								}else {
									//有一个
									if(subatts.get(0).getAttDate().compareTo(date5) == -1) {
										//时间小于10点，则为上午上班有记录，上午下班无记录
										where2.andAmDate1IdEqualTo(subId1);
									}else {
										where2.andAmDate2IdEqualTo(subId1);
									}
								}
								mainattMapper.updateByExampleSelective(mainatt, example2 );
								
								
							}
							
							
							
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				
				
				
				return 0;
	}

	@Override
	public int insertOrUpdateAttendanceItemWithoutWorkInTheMorning(Subatt subatt) {
		// TODO Auto-generated method stub
		//上午下班打卡签到
		
		 * 1.插入subatt信息
		 * 注：关键在于subatt的attState	
		 * 早于12点算早退
		 * 2.插入到mainatt中
		 * 3.找整合关系
		 
		
		//.插入subatt

		Date date1 = subatt.getAttDate();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str1 = sdf2.format(date1);	
		String str2 = str1+" 12:00:00";
		String str3 = str1+" 6:00:00";
		String str4 = str1+" 10:00:00";
		try {
			Date date2 = sdf.parse(str2);
			
			if(date1.compareTo(date2)==-1) {
				//date1<date2   为上午早退
				subatt.setAttState(2);
			}else {
				subatt.setAttState(5);
			}
			subattMapper.insertSelective(subatt);
			//找出该插入操作的id
			Integer subattId = subattMapper.selectLastInsertId();
			//2.插入mainatt
			
			 * 1.首先判断上午上班是否有记录
			 * 2.若没有，则直接插入，置其他为空
			 * 3.若有，则更新即可
			 
			
			//判断上午上班是否有记录
			Date date3 = sdf.parse(str3);	//6点
			Date date4 = sdf.parse(str4);	//10点
			//查找该记录
			
			
			SubattExample example = new SubattExample();
			Criteria where = example.createCriteria();
			where.andEmpIdEqualTo(subatt.getEmpId());
			where.andAttDateBetween(date3, date4);
			List<Subatt> subatts = subattMapper.selectByExample(example );
			
			Mainatt mainatt = new Mainatt();
			mainatt.setAmDate2Id(subattId);
			
			if(subatts.isEmpty()) {
				
				//没查到,即无记录
				//直接insert
				
				mainatt.setEmpId(subatt.getEmpId());
				mainatt.setDepId(subatt.getDepId());
				mainatt.setAmState(1);
				mainatt.setPmState(3);
				mainattMapper.insertSelective(mainatt);
			}else {
				//有记录，update
				//获取该上午上班subatt的id
				Integer subId = subatts.get(0).getId();
				//update
				mainatt.setAmState(0);
				MainattExample subattExample = new MainattExample();
				com.tyut.po.MainattExample.Criteria where2 = subattExample.createCriteria();
				where2.andAmDate1IdEqualTo(subId);
				mainattMapper.updateByExampleSelective(mainatt , subattExample );
				
			}
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//当天12点
		
		
		
		return 0;
	}

	@Override
	public int insertOrUpdateAttendanceItemWithoutWorkInTheAfternoon(Subatt subatt){
		// TODO Auto-generated method stub
		
		//下午下班打卡签到
				
				 * 1.插入subatt信息
				 * 注：关键在于subatt的attState	
				 * 早于12点算早退
				 * 2.插入到mainatt中
				 * 3.找整合关系
				 
		//1.插入subatt
		Date date1 = subatt.getAttDate();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str1 = sdf2.format(date1);	
		String str2 = str1+" 18:00:00";
		String str3 = str1+" 6:00:00";
		String str4 = str1+" 16:00:00";
		
		try {
			Date date2 = sdf.parse(str2);	//18点
			Date date3 = sdf.parse(str3);	//6点
			Date date4 = sdf.parse(str4);	//16点
			
			
			
			if(date1.compareTo(date2)==-1) {
				//date1<18点,下午下班早退
				subatt.setAttState(4);
			}else {
				subatt.setAttState(5);
			}
			subattMapper.insertSelective(subatt);
			Integer subId = subattMapper.selectLastInsertId();	//插入项的id
			
			
			//2.插入mainatt
			//判断是否有该人该天的mainatt记录，可通过查subatt来代替
			
			SubattExample example = new SubattExample();
			Criteria where = example.createCriteria();
			where.andEmpIdEqualTo(subatt.getEmpId());
			where.andAttDateBetween(date3, date4);
			List<Subatt> subatts = subattMapper.selectByExample(example );
			
			
			
			int subattCount = subattMapper.countByExample(example);
			
			Mainatt mainatt = new Mainatt();
			mainatt.setPmDate2Id(subId);
			mainatt.setPmState(0);
			
			if(subatts.isEmpty()) {	//如果加了条件，subatts不可能为空
				//没有相应记录
				//insert mainatt
				mainatt.setEmpId(subatt.getEmpId());
				mainatt.setDepId(subatt.getDepId());
				mainatt.setAmState(3);
				mainatt.setPmState(1);
				
				mainattMapper.insertSelective(mainatt);
			}else {
				//有记录，update
				//需要找出那一项			
				//太难了    加条件
				
				 * 条件（暂只是约定，尚未实现，其他业务均未依靠此条件）
				 * 1.未签到不可签退
				 
				Integer subattId = subatts.get(0).getId();
				MainattExample example2 = new MainattExample();
				com.tyut.po.MainattExample.Criteria where2 = example2.createCriteria();
				if(subattCount==1) {
					//上午无记录，只有下午上班有记录
					where2.andPmDate1IdEqualTo(subattId);
					mainattMapper.updateByExampleSelective(mainatt, example2 );
				}else {
					//上午有记录，且下午上班有记录
					where2.andAmDate1IdEqualTo(subattId);
					mainattMapper.updateByExampleSelective(mainatt, example2);
				}
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
		return 0;
	}


*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public Page<Attendance> findAllAttendanceByMappingPage(int page, int rows, Attendance att) {
//		// TODO Auto-generated method stub
//		AttendanceVo vo = new AttendanceVo();
//		vo.setJump((page-1)*rows);
//		vo.setRows(rows);
//		List<Attendance> list = attendanceMapper.selectByExampleMappingPage(vo);
//		int total = attendanceMapper.countByExample(null);
//		
//		Page<Attendance> atts = new Page<>();
//		atts.setPage(page);
//		atts.setSize(rows);
//		atts.setTotal(total);
//		atts.setRows(list);
//		return atts;
//	}
//
//	@Override
//	public int insertOrUpdateAttendanceItemWithWorkInTheMorning(AttendanceItem attItem) {
//		// TODO Auto-generated method stub
//		//直接插入
//		Attendance att = new Attendance();
//		att.setEmpId(attItem.getEmpId());
//		att.setDepId(attItem.getDepId());
//		att.setAmRecord(attItem.getAttDate());
//		att.setAmState("1");
//		att.setPmState("0");
//		attendanceMapper.insertSelective(att);
//		return 0;
//	}
//
//	@Override
//	public int insertOrUpdateAttendanceItemWithWorkInTheAfternoon(AttendanceItem attItem) throws ParseException {
//		// TODO Auto-generated method stub
//		//查看当前emp是否有今天的记录
//		Attendance att = new Attendance();
//		att.setPmRecord(attItem.getAttDate());
//		
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String date1 = sdf.format(attItem.getAttDate());
//		
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date d1 = sdf2.parse(date1+" 00:00:00");
//		Date d2 = sdf2.parse(date1+" 23:59:59");
//		
//		
//		AttendanceExample example = new AttendanceExample();
//		Criteria where = example.createCriteria();
//		where.andEmpIdEqualTo(attItem.getEmpId());
//		where.andAmRecordBetween(d1, d2);
//		int flag = attendanceMapper.updateByExampleSelective(att, example);
//		
//		if(flag==0) {
//			//更新失败，没有此条目，改为插入
//			att.setEmpId(attItem.getEmpId());
//			att.setDepId(attItem.getDepId());
//			att.setAmState("0");
//			att.setPmState("0");
//			attendanceMapper.insert(att);
//		}
//		
//		return 1;
//	}
//
//	@Override
//	public int insertOrUpdateAttendanceItemWithoutWorkInTheMorning(AttendanceItem attItem) throws ParseException {
//		// TODO Auto-generated method stub
//		//直接更新，不能更新说明上午上班未打卡，返回0
//		Attendance att = new Attendance();
//		att.setAmRecord2(attItem.getAttDate());
//		
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String date1 = sdf.format(attItem.getAttDate());
//		
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date d1 = sdf2.parse(date1+" 00:00:00");
//		Date d2 = sdf2.parse(date1+" 23:59:59");
//		
//		
//		
//		return 0;
//	}
//
//	@Override
//	public int insertOrUpdateAttendanceItemWithoutWorkInTheAfternoon(AttendanceItem attItem) throws ParseException{
//		// TODO Auto-generated method stub
//		return 0;
//	}



}
