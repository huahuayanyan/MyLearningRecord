package com.mywork.demo.dao;

import java.util.List;

import com.mywork.demo.entity.Area;

public interface AreaDao {
	/**
	 * 查询所有的地区
	 * @return
	 */
	List<Area> queryArea();
	
	/**
	 * 根据地区Id查询地区信息
	 * @param areaId
	 * @return
	 */
	Area queryAreaById(int areaId);
	/**
	 * 新增地区
	 * @param area
	 * @return
	 */
	int insertArea(Area area);
	/**
	 * 更新地区
	 * @param area
	 * @return
	 */
	int updateArea(Area area);
	/**
	 * 删除地区
	 * @param areaId
	 * @return
	 */
	int deleteArea(int areaId);
}
