package com.yShen.bus.dao;

import com.yShen.bus.model.Check;
import com.yShen.bus.vo.CheckVo;

import java.util.List;


public interface CheckDao {
    int deleteByPrimaryKey(String checkid);

    int insert(Check record);

    int insertSelective(Check record);

    Check selectByPrimaryKey(String checkid);

    int updateByPrimaryKeySelective(Check record);

    int updateByPrimaryKey(Check record);
    
    
    //查询
    List<Check> queryAllCheck(Check check);
    List<Check> queryAllCheck_one(CheckVo checkVo);
}