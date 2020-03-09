package com.tyut.mapper;

import com.tyut.po.Mainatt;
import com.tyut.po.MainattExample;
import com.tyut.po.vo.MainattVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MainattMapper {
    int countByExample(MainattExample example);

    int deleteByExample(MainattExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mainatt record);

    int insertSelective(Mainatt record);

    List<Mainatt> selectByExample(MainattExample example);
    List<Mainatt> selectByExampleMappingPage(MainattVo vo);

    Mainatt selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mainatt record, @Param("example") MainattExample example);

    int updateByExample(@Param("record") Mainatt record, @Param("example") MainattExample example);

    int updateByPrimaryKeySelective(Mainatt record);

    int updateByPrimaryKey(Mainatt record);
}