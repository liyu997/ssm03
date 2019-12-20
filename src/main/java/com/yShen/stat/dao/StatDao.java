package com.yShen.stat.dao;

import com.yShen.stat.domain.BaseEntity;

import java.util.List;


public interface StatDao {

	/**
	 * 查询客户地区的数据
	 * @return
	 */
	List<BaseEntity> queryCustomerAreaStat();

	/**
	 * 查询业务员年度业绩
	 * @param year
	 * @return
	 */
	List<BaseEntity> queryOpernameYearGradeStat(String year);

	/**
	 * 加载公司年度统计数据
	 * @param year
	 * @return
	 */
	List<Double> queryCompanyYearGradeStat(String year);

}
