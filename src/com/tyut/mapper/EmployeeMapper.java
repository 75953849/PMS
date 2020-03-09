package com.tyut.mapper;

import com.tyut.po.Employee;
import com.tyut.po.EmployeeExample;
import com.tyut.po.vo.EmployeeVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    int countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);
    List<Employee> selectByExamplePage(EmployeeVo vo);
    List<Employee> selectByExampleMappingPage(EmployeeVo vo);

    Employee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    
    Employee findEmpByID(Integer id);
    
}