package com.datageeks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.datageeks.dao.EmployeeBean;
import com.datageeks.service.EmployeeService;
import com.datageeks.service.ServicesException;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService = null;
	
	@RequestMapping(path = "/emp",method = RequestMethod.GET)
	public String homePage(ModelMap map)
	{
		map.put("empModelBean", new  EmpModelBean());
		return "emp";
	}
	
	@RequestMapping(path = "/loadById",method = RequestMethod.POST)
	public String getInfo(ModelMap map, @ModelAttribute EmpModelBean empModelBean)	
	{
		try {
			EmployeeBean employee = employeeService.getById(empModelBean.getEmpId());
			map.put("employee", employee);
		} catch (ServicesException e) {
			map.put("exception", e+" :: "+e.getMessage());
			return "error";
		}
		
		return "success";
	}
}
