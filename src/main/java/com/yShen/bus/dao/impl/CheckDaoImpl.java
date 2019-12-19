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
        return 0;
    }

    @Override
    public int insert(Check record) {
        return 0;
    }

    @Override
    public int insertSelective(Check record) {
        return 0;
    }

    @Override
    public Check selectByPrimaryKey(String checkid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Check record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Check record) {
        return 0;
    }

    @Override
    public List<Check> queryAllCheck(Check check) {
        return null;
    }

    @Override
    public List<Check> queryAllCheck_one(CheckVo checkVo) {
        checkVo.setPage(checkVo.getLimit()*(checkVo.getPage()-1));
        return null;
    }
}