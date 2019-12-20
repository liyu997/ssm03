package com.yShen.bus.dao.impl;

import com.yShen.bus.dao.CheckDao;
import com.yShen.bus.model.Check;
import com.yShen.bus.vo.CheckVo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CheckDaoImpl extends SqlSessionDaoSupport implements CheckDao {

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int deleteByPrimaryKey(String checkid) {
        return getSqlSession().delete("Check.deleteByPrimaryKey",checkid);
    }

    @Override
    public int insert(Check record) {
        return getSqlSession().insert("Check.insert",record);
    }

    @Override
    public int insertSelective(Check record) {
        return getSqlSession().insert("Check.insertSelective",record);
    }

    @Override
    public Check selectByPrimaryKey(String checkid) {
        return getSqlSession().selectOne("Check.selectByPrimaryKey",checkid);
    }

    @Override
    public int updateByPrimaryKeySelective(Check record) {
        return getSqlSession().update("Check.updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(Check record) {
        return getSqlSession().update("Check.updateByPrimaryKey",record);
    }

    @Override
    public List<Check> queryAllCheck(Check check) {
        return getSqlSession().selectList("Check.queryAllCheck",check);
    }

    @Override
    public List<Check> queryAllCheck_one(CheckVo checkVo) {
        checkVo.setPage(checkVo.getLimit()*(checkVo.getPage()-1));
        List<Check> list = getSqlSession().selectList("Check.queryAllCheck_one", checkVo);
        return list;
    }
}