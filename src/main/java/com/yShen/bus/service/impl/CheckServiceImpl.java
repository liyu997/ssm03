package com.yShen.bus.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yShen.bus.dao.CarDao;
import com.yShen.bus.dao.CheckDao;
import com.yShen.bus.dao.CustomerDao;
import com.yShen.bus.dao.RentDao;
import com.yShen.bus.model.Car;
import com.yShen.bus.model.Check;
import com.yShen.bus.model.Customer;
import com.yShen.bus.model.Rent;
import com.yShen.bus.service.CheckService;
import com.yShen.bus.vo.CheckVo;
import com.yShen.sys.constast.SysConstast;
import com.yShen.sys.model.User;
import com.yShen.sys.util.DataGridView;
import com.yShen.sys.util.RandomUtils;
import com.yShen.sys.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class CheckServiceImpl implements CheckService {

	@Autowired
	private CheckDao checkMapper;
	@Autowired
	private CustomerDao customerMapper;

	@Autowired
	private RentDao rentMapper;
	@Autowired
	private CarDao carMapper;
	@Override
	public Map<String, Object> initCheckFormData(String rentid) {
		
		//查询出租单
		Rent rent=this.rentMapper.selectByPrimaryKey(rentid);
		//查询客户
		Customer customer=this.customerMapper.selectByPrimaryKey(rent.getIdentity());
		//查询车辆
		Car car=this.carMapper.selectByPrimaryKey(rent.getCarnumber());


		//组装Check
		Check check=new Check();
		check.setCheckid(RandomUtils.createRandomStringUseTime(SysConstast.CAR_ORDER_JC));
		check.setRentid(rentid);
		check.setCheckdate(new Date());
		User user=(User) WebUtils.getHttpSession().getAttribute("user");
		check.setOpername(user.getRealname());
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("rent", rent);
		map.put("customer", customer);
		map.put("car", car);
		map.put("check", check);
		
		return map;
	}
	@Override
	public void addCheck(CheckVo checkVo) {
		this.checkMapper.insertSelective(checkVo);
		//更改出租单的状态
		Rent rent=this.rentMapper.selectByPrimaryKey(checkVo.getRentid());
		rent.setRentflag(SysConstast.RENT_BACK_TRUE);
		this.rentMapper.updateByPrimaryKeySelective(rent);
		//更改汽车的状态
		Car car=new Car();
		car.setCarnumber(rent.getCarnumber());
		car.setIsrenting(SysConstast.RENT_CAR_FALSE);
		this.carMapper.updateByPrimaryKeySelective(car);
	}
	@Override
	public DataGridView queryAllCheck(CheckVo checkVo) {
		double size =  checkMapper.queryAllCheck(checkVo).size();
		int pagess = (int) Math.ceil(size/checkVo.getLimit());
		if (pagess < checkVo.getPage()) {
			checkVo.setPage(pagess);
		}
		List<Check> data = this.checkMapper.queryAllCheck_one(checkVo);
		System.out.println(data);
		DataGridView dataGridView = new DataGridView((long) size, data);
		return  dataGridView;
	}
	@Override
	public void updateCheck(CheckVo checkVo) {
		this.checkMapper.updateByPrimaryKeySelective(checkVo);
	}

}
