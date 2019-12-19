package com.yShen.bus.service.impl;

import java.util.List;

import com.yShen.bus.dao.CarDao;
import com.yShen.bus.dao.RentDao;
import com.yShen.bus.model.Car;
import com.yShen.bus.model.Rent;
import com.yShen.bus.service.RentService;
import com.yShen.bus.vo.RentVo;
import com.yShen.sys.constast.SysConstast;
import com.yShen.sys.util.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


@Service
public class RentServiceImpl implements RentService {
	
	@Autowired
	private RentDao rentMapper;
	
	@Autowired
	private CarDao carMapper;

	@Override
	public void addRent(RentVo rentVo) {
		this.rentMapper.insertSelective(rentVo);
		//更改车辆的出租状态
		Car car=new Car();
		car.setCarnumber(rentVo.getCarnumber());
		car.setIsrenting(SysConstast.RENT_CAR_TRUE);
		carMapper.updateByPrimaryKeySelective(car);
	}

	@Override
	public DataGridView queryAllRent(RentVo rentVo) {
//		Page<Object> page=PageHelper.startPage(rentVo.getPage(), rentVo.getLimit());
//		List<Rent> data = this.rentMapper.queryAllRent(rentVo);
//		return new DataGridView(page.getTotal(), data);
		return null;
	}

	@Override
	public void updateRent(RentVo rentVo) {
		this.rentMapper.updateByPrimaryKeySelective(rentVo);
	}

	@Override
	public void deleteRent(String rentid) {
		//更改汽车的状态
		Rent rent=this.rentMapper.selectByPrimaryKey(rentid);
		Car car=new Car();
		car.setCarnumber(rent.getCarnumber());
		car.setIsrenting(SysConstast.RENT_CAR_FALSE);
		carMapper.updateByPrimaryKeySelective(car);
		//删除出租单
		this.rentMapper.deleteByPrimaryKey(rentid);
	}

	@Override
	public Rent queryRentByRentId(String rentid) {
		return this.rentMapper.selectByPrimaryKey(rentid);
	}

}
