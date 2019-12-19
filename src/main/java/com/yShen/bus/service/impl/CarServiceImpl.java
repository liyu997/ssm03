package com.yShen.bus.service.impl;

import java.util.List;

import com.yShen.bus.dao.CarDao;
import com.yShen.bus.model.Car;
import com.yShen.bus.model.Customer;
import com.yShen.bus.service.CarService;
import com.yShen.bus.vo.CarVo;
import com.yShen.sys.constast.SysConstast;
import com.yShen.sys.util.AppFileUtils;
import com.yShen.sys.util.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarDao carDao;

	@Override
	public DataGridView queryAllCar(CarVo carVo) {

		double size =  carDao.queryAllCar(carVo).size();
		int pagess = (int) Math.ceil(size/carVo.getLimit());
		if (pagess < carVo.getPage()) {
			carVo.setPage(pagess);
		}
		List<Car> data = this.carDao.queryAllCar_one(carVo);
		DataGridView dataGridView = new DataGridView((long) size, data);

		return dataGridView;
	}

	@Override
	public void addCar(CarVo carVo) {
		this.carDao.insertSelective(carVo);
	}

	@Override
	public void deleteCar(String carnumber) {
		//先删除图片
		Car car=this.carDao.selectByPrimaryKey(carnumber);
		//如果不是默认图片就删除
		if(!car.getCarimg().equals(SysConstast.DEFAULT_CAR_IMG)) {
			AppFileUtils.deleteFileUsePath(car.getCarimg());
		}
		//删除数据库的数据
		this.carDao.deleteByPrimaryKey(carnumber);
	}

	@Override
	public void deleteBatchCar(String[] carnumbers) {
		for (String carnumber : carnumbers) {
			this.deleteCar(carnumber);
		}
	}

	@Override
	public void updateCar(CarVo carVo) {
		this.carDao.updateByPrimaryKeySelective(carVo);
	}

	@Override
	public Car queryCarByCarNumber(String carnumber) {
		return this.carDao.selectByPrimaryKey(carnumber);
	}


}
