package com.tyut.mapper;

import com.tyut.po.Subatt;
import com.tyut.po.SubattExample;
import com.tyut.po.vo.SubattVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubattMapper {
    int countByExample(SubattExample example);

    int deleteByExample(SubattExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Subatt record);

    int insertSelective(Subatt record);

    List<Subatt> selectByExample(SubattExample example);
    List<Subatt> selectByExampleMappingPage(SubattVo example);
    

    Subatt selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Subatt record, @Param("example") SubattExample example);

    int updateByExample(@Param("record") Subatt record, @Param("example") SubattExample example);

    int updateByPrimaryKeySelective(Subatt record);

    int updateByPrimaryKey(Subatt record);
    
    Integer selectLastInsertId();	//查询最后一次插入操作的id
}