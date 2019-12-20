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
        return getSqlSession().delete("Rent.deleteByPrimaryKey",rentid);
    }

    @Override
    public int insert(Rent record) {
        return getSqlSession().insert("Rent.insert",record);
    }

    @Override
    public int insertSelective(Rent record) {
        return getSqlSession().insert("Rent.insertSelective",record);
    }

    @Override
    public Rent selectByPrimaryKey(String rentid) {
        return getSqlSession().selectOne("Rent.selectByPrimaryKey",rentid);
    }

    @Override
    public int updateByPrimaryKeySelective(Rent record) {
        return getSqlSession().update("Rent.updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(Rent record) {
        return getSqlSession().update("Rent.updateByPrimaryKey",record);
    }

    @Override
    public List<Rent> queryAllRent(Rent rent) {
        return getSqlSession().selectList("Rent.queryAllRent",rent);
    }

    @Override
    public List<Rent> queryAllRent_one(RentVo rentVo) {
        rentVo.setPage(rentVo.getLimit()*(rentVo.getPage()-1));
        return getSqlSession().selectList("Rent.queryAllRent_one",rentVo);
    }
}