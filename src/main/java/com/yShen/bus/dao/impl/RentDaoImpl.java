package com.yShen.bus.dao.impl;

import com.yShen.bus.dao.RentDao;
import com.yShen.bus.model.Rent;
import com.yShen.bus.vo.RentVo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class RentDaoImpl extends SqlSessionDaoSupport implements RentDao {

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }


    @Override
    public int deleteByPrimaryKey(String rentid) {
        return 0;
    }

    @Override
    public int insert(Rent record) {
        return 0;
    }

    @Override
    public int insertSelective(Rent record) {
        return 0;
    }

    @Override
    public Rent selectByPrimaryKey(String rentid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Rent record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Rent record) {
        return 0;
    }

    @Override
    public List<Rent> queryAllRent(Rent rent) {
        return null;
    }

    @Override
    public List<Rent> queryAllRent_one(RentVo rentVo) {
        rentVo.setPage(rentVo.getLimit()*(rentVo.getPage()-1));
        return null;
    }
}