package com.datageeks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

	
	@RequestMapping(path = "/home",method = RequestMethod.GET)
	public String homePage()
	{
		return "welcome";
	}
	
	@RequestMapping(path = "/demo",method = RequestMethod.GET)
	public String getInfo(ModelMap map, @RequestParam("method") String value)	
	{
		map.put("result","Request Handled From => "+value);
		return "success";
	}
}
