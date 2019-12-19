package com.yShen.bus.service.impl;

import java.util.List;

import com.yShen.bus.dao.CustomerDao;
import com.yShen.bus.model.Customer;
import com.yShen.bus.service.CustomerService;
import com.yShen.bus.vo.CustomerVo;
import com.yShen.sys.model.LogInfo;
import com.yShen.sys.util.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerMapper;

	@Override
	public DataGridView queryAllCustomer(CustomerVo customerVo) {

		double size =  customerMapper.queryAllCustomer(customerVo).size();
		int pagess = (int) Math.ceil(size/customerVo.getLimit());
		if (pagess < customerVo.getPage()) {
			customerVo.setPage(pagess);
		}
		List<Customer> data = this.customerMapper.queryAllCustomer_one(customerVo);
		DataGridView dataGridView = new DataGridView((long) size, data);
		return dataGridView;
	}

	@Override
	public void addCustomer(CustomerVo customerVo) {
		this.customerMapper.insertSelective(customerVo);
	}

	@Override
	public void deleteCustomer(String identity) {
		this.customerMapper.deleteByPrimaryKey(identity);
	}

	@Override
	public void deleteBatchCustomer(String[] identitys) {
		for (String identity : identitys) {
			this.deleteCustomer(identity);
		}
	}

	@Override
	public void updateCustomer(CustomerVo customerVo) {
		this.customerMapper.updateByPrimaryKeySelective(customerVo);
	}

	@Override
	public Customer queryCustomerByIdentity(String identity) {
		// TODO Auto-generated method stub
		return this.customerMapper.selectByPrimaryKey(identity);
	}

	@Override
	public List<Customer> queryAllCustomerForList(CustomerVo customerVo) {
		return this.customerMapper.queryAllCustomer(customerVo);
	}


}
