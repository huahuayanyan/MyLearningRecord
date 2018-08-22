package com.mywork.demo.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mywork.demo.entity.Area;
import com.mywork.demo.service.AreaService;

@RestController
@RequestMapping("/superadmin")
public class AreaControl {

	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value = "/listArea", method = RequestMethod.GET)
	private Map<String,Object> listArea() {
		Map<String,Object> modelMap = new HashMap<String,Object>();
		List<Area> list = areaService.queryArea();
		modelMap.put("areaList", list);
		return modelMap;
	}
	
	@RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
	private Map<String,Object> getAreaById(Integer areaId) {
		Map<String,Object> modelMap = new HashMap<String,Object>();
		Area area = areaService.queryAreaById(areaId);
		modelMap.put("area", area);
		return modelMap;
	}
	
	@RequestMapping(value = "/addarea", method = RequestMethod.POST)
	private Map<String,Object> addArea(@RequestBody Area area){
		Map<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("success", areaService.insertArea(area));
		return modelMap;
	}
	
	@RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
	private Map<String,Object> modifyArea(@RequestBody Area area){
		Map<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("success", areaService.updateArea(area));
		return modelMap;
	}
	
	@RequestMapping(value = "/deletearea", method = RequestMethod.GET)
	private Map<String,Object> modifyArea(Integer areaId){
		Map<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("success", areaService.deleteArea(areaId));
		return modelMap;
	}
}
