package com.yShen.bus.dao;

import com.yShen.bus.model.Rent;
import com.yShen.bus.vo.RentVo;

import java.util.List;


public interface RentDao {

    int deleteByPrimaryKey(String rentid);

    int insert(Rent record);

    int insertSelective(Rent record);

    Rent selectByPrimaryKey(String rentid);

    int updateByPrimaryKeySelective(Rent record);

    int updateByPrimaryKey(Rent record);
    
    //查询
    public List<Rent> queryAllRent(Rent rent);
    public List<Rent> queryAllRent_one(RentVo rentVo);

}