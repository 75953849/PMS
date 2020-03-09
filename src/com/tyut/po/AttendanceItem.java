package com.tyut.po;

import java.util.Date;
/*
 * 
 * 废除不用，用数据库实体subatt来实现
 */
public class AttendanceItem {
	private Integer empId;
	private Integer depId;
	private Date attDate;
	private Integer state;	//0正常，1迟到，2早退，3迟到+早退
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Integer getDepId() {
		return depId;
	}
	public void setDepId(Integer depId) {
		this.depId = depId;
	}
	public Date getAttDate() {
		return attDate;
	}
	public void setAttDate(Date attDate) {
		this.attDate = attDate;
	}
	@Override
	public String toString() {
		return "AttendanceItem [empId=" + empId + ", depId=" + depId + ", attDate=" + attDate + "]";
	}
	
	
}
