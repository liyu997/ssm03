package com.yShen.bus.service;

import com.yShen.bus.vo.CheckVo;
import com.yShen.sys.util.DataGridView;

import java.util.Map;


/**
 * 检查单管理的服务器接口
 * @author LJH
 *
 */
public interface CheckService {
	/**
	 * 根据出租单号加载检查单的表单数据
	 * @param rentid
	 * @return
	 */
	Map<String, Object> initCheckFormData(String rentid);

	/**
	 * 保存检查单数据
	 * @param checkVo
	 */
	void addCheck(CheckVo checkVo);
	
	/**
	 * 查询
	 */
	DataGridView queryAllCheck(CheckVo checkVo);

	/**
	 * 修改检查单
	 * @param checkVo
	 */
	void updateCheck(CheckVo checkVo);

}
