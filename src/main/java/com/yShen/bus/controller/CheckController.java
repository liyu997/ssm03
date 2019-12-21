package com.yShen.bus.controller;

import java.util.Date;
import java.util.Map;

import com.yShen.bus.model.Rent;
import com.yShen.bus.service.CheckService;
import com.yShen.bus.service.RentService;
import com.yShen.bus.vo.CheckVo;
import com.yShen.sys.util.DataGridView;
import com.yShen.sys.util.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 检查单管理的控制器
 *
 */
@RestController
@RequestMapping("check")
public class CheckController {
	
	@Autowired
	private RentService rentService;
	
	@Autowired
	private CheckService checkService;
	
	/***
	 * 根据出租单号查询出租单信息
	 */
	@RequestMapping("checkRentExist")
	public Rent checkRentExist(String rentid) {
		Rent rent=rentService.queryRentByRentId(rentid);
		//null   返回对象
		return rent;
	}
	
	
	/**
	 * 根据出租单号加载检查单的表单数据
	 */
	@RequestMapping("initCheckFormData")
	public Map<String,Object> initCheckFormData(String rentid){
		return this.checkService.initCheckFormData(rentid);
	}
	
	/**
	 * 保存检查单数据
	 */
	@RequestMapping("saveCheck")
	public ResultObj saveCheck(CheckVo checkVo) {
		try {
			checkVo.setCreatetime(new Date());
			this.checkService.addCheck(checkVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}
	
	/**
	 * 查询
	 * @param checkVo
	 * @return
	 */
	@RequestMapping("loadAllCheck")
	public DataGridView loadAllCheck(CheckVo checkVo) {
		return this.checkService.queryAllCheck(checkVo);
	}
	
	/**
	 * 修改检查单数据
	 */
	@RequestMapping("updateCheck")
	public ResultObj updateCheck(CheckVo checkVo) {
		try {
			this.checkService.updateCheck(checkVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}

}
