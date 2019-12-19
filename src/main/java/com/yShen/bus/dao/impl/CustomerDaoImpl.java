package com.yShen.bus.dao.impl;

import com.yShen.bus.dao.CustomerDao;
import com.yShen.bus.model.Customer;
import com.yShen.bus.vo.CustomerVo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CustomerDaoImpl extends SqlSessionDaoSupport implements CustomerDao {

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int deleteByPrimaryKey(String identity) {
        return getSqlSession().delete("Customer.deleteByPrimaryKey",identity);
    }

    @Override
    public int insert(Customer record) {
        return getSqlSession().insert("Customer.insert",record);
    }

    @Override
    public int insertSelective(Customer record) {
        return getSqlSession().insert("Customer.insertSelective",record);
    }

    @Override
    public Customer selectByPrimaryKey(String identity) {
        return getSqlSession().selectOne("Customer.selectByPrimaryKey",identity);
    }

    @Override
    public int updateByPrimaryKeySelective(Customer record) {
        return getSqlSession().update("Customer.updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(Customer record) {
        return getSqlSession().update("Customer.updateByPrimaryKey",record);
    }

    @Override
    public List<Customer> queryAllCustomer(Customer customer) {
        return getSqlSession().selectList("Customer.queryAllCustomer",customer);
    }

    @Override
    public List<Customer> queryAllCustomer_one(CustomerVo customerVo) {
        customerVo.setPage(customerVo.getLimit()*(customerVo.getPage()-1));

        List<Customer> list = getSqlSession().selectList("Customer.queryAllCustomer_one", customerVo);
        System.out.println(list);
        System.out.println(list.size());
        return list;
    }
}