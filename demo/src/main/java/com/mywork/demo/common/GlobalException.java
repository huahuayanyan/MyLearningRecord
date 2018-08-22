package com.mywork.demo.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 * @author 15451
 *
 */
@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	private Map<String,Object> exceptionHandler(HttpServletRequest req,Exception e) {
		Map<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("success", false);
		modelMap.put("errorMsg", e.getMessage());
		return modelMap;
	}
}
