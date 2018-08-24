package com.mywork.demo.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mywork.demo.entity.Area;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

	@Autowired
	private AreaDao areaDao;
	
	@Test
//	@Ignore
	public void queryArea() {
		List<Area> areaList = areaDao.queryArea();
		System.out.println(areaList.toString());
//		assertEquals(3, areaList.size());
	}
	
	@Test
	@Ignore
	public void queryAreaById() {
		Integer areaId = 3;
		System.out.println(areaDao.queryAreaById(areaId).getAreaName());
	}
	
	@Test
	@Ignore
	public void insertArea() {
		Area area = new Area();
		area.setAreaName("西苑");
		area.setPriority(4);
//		area.setCreateTime(new Date());
//		area.setLastEditTime(new Date());
		System.out.println(areaDao.insertArea(area));
	}
	
	@Test
	@Ignore
	public void updateArea() {
		Area area = new Area();
		area.setAreaId(3);
		area.setAreaName("西");
//		area.setCreateTime(new Date());
//		area.setLastEditTime(new Date());
		System.out.println(areaDao.updateArea(area));
	}
	
	@Test
	@Ignore
	public void deleteArea() {
		Integer areaId = 1;
		System.out.println(areaDao.deleteArea(areaId));
	}
}
