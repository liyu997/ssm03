package com.yShen.stat.service.impl;

import java.util.List;

import com.yShen.stat.dao.StatDao;
import com.yShen.stat.domain.BaseEntity;
import com.yShen.stat.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StatServiceImpl implements StatService {
	
	
	@Autowired
	private StatDao statMapper;

	@Override
	public List<BaseEntity> loadCustomerAreaStatList() {
		return statMapper.queryCustomerAreaStat();
	}

	@Override
	public List<BaseEntity> loadOpernameYearGradeStatList(String year) {
		return this.statMapper.queryOpernameYearGradeStat(year);
	}

	@Override
	public List<Double> loadCompanyYearGradeStatList(String year) {
		return this.statMapper.queryCompanyYearGradeStat(year);
	}

}
