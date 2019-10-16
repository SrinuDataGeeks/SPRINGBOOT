package com.datageeks.controller;

import java.util.List;

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
	
	
	@RequestMapping(path = "/all",method = RequestMethod.GET)
	public String getAll(ModelMap map)
	{
		try {
			List<EmployeeBean> employeeList = employeeService.getAll();
			map.put("employeeList", employeeList);
		} catch (ServicesException e) {
			map.put("exception", e+" :: "+e.getMessage());
			return "error";
		}
		
		return "success";
	}
	
	
	@RequestMapping(path = "/editPage",method = RequestMethod.GET)
	public String editPage(ModelMap map, @RequestParam("empId") Integer empId)	
	{
		try {
			EmployeeBean employee = employeeService.getById(empId);
			map.put("employeeBean", employee);
		} catch (ServicesException e) {
			map.put("exception", e+" :: "+e.getMessage());
			return "error";
		}
		
		return "edit";
	}
	
	@RequestMapping(path = "/saveOrUpdate",method = RequestMethod.POST)
	public String saveOrUpdate(ModelMap map, @ModelAttribute EmployeeBean employeeBean)	
	{
		try {
			employeeService.saveOrUpdate(employeeBean);
			List<EmployeeBean> employeeList = employeeService.getAll();
			map.put("employeeList", employeeList);
		} catch (ServicesException e) {
			map.put("exception", e+" :: "+e.getMessage());
			return "error";
		}
		
		return "success";
	}
	
	@RequestMapping(path = "/delete",method = RequestMethod.GET)
	public String delete(ModelMap map, @RequestParam("empId") Integer empId)	
	{
		try {
			employeeService.delete(empId);
			List<EmployeeBean> employeeList = employeeService.getAll();
			map.put("employeeList", employeeList);
		} catch (ServicesException e) {
			map.put("exception", e+" :: "+e.getMessage());
			return "error";
		}
		
		return "success";
	}
}
