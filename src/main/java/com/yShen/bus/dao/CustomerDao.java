package com.yShen.bus.dao;

import com.yShen.bus.model.Customer;
import com.yShen.bus.vo.CustomerVo;

import java.util.List;


public interface CustomerDao {
    int deleteByPrimaryKey(String identity);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(String identity);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    List<Customer> queryAllCustomer(Customer customer);
    List<Customer> queryAllCustomer_one(CustomerVo customerVo);
}