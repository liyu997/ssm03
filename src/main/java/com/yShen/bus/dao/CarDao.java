package com.yShen.bus.dao;

import com.yShen.bus.model.Car;
import com.yShen.bus.vo.CarVo;

import java.util.List;


public interface CarDao {


    int deleteByPrimaryKey(String carnumber);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(String carnumber);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);
    
    List<Car> queryAllCar(Car car);
    List<Car> queryAllCar_one(CarVo carVo);
}