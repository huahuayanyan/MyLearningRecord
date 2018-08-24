package com.mywork.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mywork.demo.dao.AreaDao;
import com.mywork.demo.entity.Area;
import com.mywork.demo.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaDao areaDao;
	
	@Override
	public List<Area> queryArea() {
		return areaDao.queryArea();
	}

	@Override
	public Area queryAreaById(int areaId) {
		return areaDao.queryAreaById(areaId);
	}

	@Transactional
	@Override
	public boolean insertArea(Area area) {
		if(area.getAreaName() != null && !"".equals(area.getAreaName())) {
			area.setCreateTime(new Date());
			area.setLastEditTime(new Date());
			try {
				int effectedNum = areaDao.insertArea(area);
				if(effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("插入区域信息失败!");
				}
				
			} catch (Exception e) {
				throw new RuntimeException("插入区域信息失败:" + e.getMessage());
			}
			
		} else {
			throw new RuntimeException("区域信息不能为空!");
		}
	}

	@Override
	public boolean updateArea(Area area) {
		if(area.getAreaId() != null && !"".equals(area.getAreaId())) {
			area.setLastEditTime(new Date());
			try {
				int effectedNum = areaDao.updateArea(area);
				if(effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("插入区域信息失败!");
				}
				
			} catch (Exception e) {
				throw new RuntimeException("插入区域信息失败:" + e.getMessage());
			}
			
		} else {
			throw new RuntimeException("区域信息不能为空!");
		}
	}

	@Override
	public boolean deleteArea(int areaId) {
		if(areaId > 0) {
			try {
				int effectedNum = areaDao.deleteArea(areaId);
				if(effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("插入区域信息失败!");
				}
				
			} catch (Exception e) {
				throw new RuntimeException("插入区域信息失败:" + e.getMessage());
			}
			
		} else {
			throw new RuntimeException("区域信息不能为空!");
		}
	}

}
