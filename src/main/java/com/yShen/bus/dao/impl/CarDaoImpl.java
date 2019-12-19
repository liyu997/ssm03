package com.yShen.bus.dao.impl;

import com.yShen.bus.dao.CarDao;
import com.yShen.bus.model.Car;
import com.yShen.bus.vo.CarVo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CarDaoImpl extends SqlSessionDaoSupport implements CarDao {
    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
    @Override
    public int deleteByPrimaryKey(String carnumber) {
        return getSqlSession().delete("Car.deleteByPrimaryKey",carnumber);
    }
    @Override
    public int insert(Car record) {
        return getSqlSession().insert("Car.insert",record);
    }

    @Override
    public int insertSelective(Car record) {
        return getSqlSession().insert("Car.insertSelective",record);
    }

    @Override
    public Car selectByPrimaryKey(String carnumber) {
        return getSqlSession().selectOne("Car.selectByPrimaryKey", carnumber);
    }

    @Override
    public int updateByPrimaryKeySelective(Car record) {
        return getSqlSession().update("Car.updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(Car record) {
        return getSqlSession().update("Car.updateByPrimaryKey",record);
    }

    @Override
    public List<Car> queryAllCar(Car car) {
        return getSqlSession().selectList("Car.queryAllCar",car);
    }

    @Override
    public List<Car> queryAllCar_one(CarVo carVo) {
        carVo.setPage(carVo.getLimit()*(carVo.getPage()-1));
        return getSqlSession().selectList("Car.queryAllCar_one",carVo);
    }
}