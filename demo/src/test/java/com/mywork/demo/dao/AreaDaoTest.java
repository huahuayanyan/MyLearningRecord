package com.mywork.demo.dao;

import java.util.Date;

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
	
	/*@Test
	public void queryArea() {
		List<Area> areaList = areaDao.queryArea();
		assertEquals(2, areaList.size());
	}*/
	
	/*@Test
	public void queryAreaById() {
		Integer areaId = 1;
		System.out.println(areaDao.queryAreaById(areaId).getAreaName());
	}*/
	
	@Test
	public void insertArea() {
		Area area = new Area();
		area.setAreaName("西苑");
		area.setPriority(4);
//		area.setCreateTime(new Date());
//		area.setLastEditTime(new Date());
		System.out.println(areaDao.insertArea(area));
	}
	
	/*@Test
	public void updateArea() {
		Area area = new Area();
		area.setAreaId(3);
		area.setAreaName("西");
//		area.setCreateTime(new Date());
//		area.setLastEditTime(new Date());
		System.out.println(areaDao.updateArea(area));
	}*/
	
	/*@Test
	public void deleteArea() {
		Integer areaId = 1;
		System.out.println(areaDao.deleteArea(areaId));
	}*/
}
