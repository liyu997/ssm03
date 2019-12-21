package com.yShen.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 业务管理的路由控制器
 *
 */
@Controller
@RequestMapping("bus")
public class BusController {

	/**
	 * 跳转到客户管理的页面
	 */
	@RequestMapping("toCustomerManager")
	public String toCustomerManager() {
		return "business/customer/customerManager";
	}
	
	/**
	 * 跳转到车辆管理的页面
	 */
	@RequestMapping("toCarManager")
	public String toCarManager() {
		return "business/car/carManager";
	}
	

	/**
	 * 跳转到车辆出租的页面
	 */
	@RequestMapping("toRentCarManager")
	public String toRentCarManager() {
		return "business/rent/rentCarManager";
	}
	
	/**
	 * 跳转到出租单管理的页面
	 */
	@RequestMapping("toRentManager")
	public String toRentManager() {
		return "business/rent/rentManager";
	}
	
	/**
	 * 跳转到汽车入库管理的页面
	 */
	@RequestMapping("toCheckCarManager")
	public String toCheckCarManager() {
		return "business/check/checkCarManager";
	}
	
	/**
	 * 跳转到检查单管理的页面
	 */
	@RequestMapping("toCheckManager")
	public String toCheckManager() {
		return "business/check/checkManager";
	}
}
