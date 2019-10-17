package com.datageeks.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService = null;

	@RequestMapping(path = "/emp", method = RequestMethod.GET)
	public String homePage(ModelMap map) {
		log.info(" EmployeeController => homePage(...) method execution started");
		map.put("empModelBean", new EmpModelBean());
		log.info(" EmployeeController => homePage(...) method execution completed");
		return "emp";
	}

	@RequestMapping(path = "/loadById", method = RequestMethod.POST)
	public String loadEmpById(ModelMap map, @ModelAttribute EmpModelBean empModelBean) {
		try {
			log.info(" EmployeeController => loadEmpById(...) method execution started");
			EmployeeBean employee = employeeService.getById(empModelBean.getEmpId());
			map.put("employee", employee);
		} catch (ServicesException e) {
			log.error(" EmployeeController => loadEmpById(...) exception raised " + e);
			map.put("exception", e + " :: " + e.getMessage());
			return "error";
		}
		log.info(" EmployeeController => loadEmpById(...) method execution completed");

		return "success";
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public String getAll(ModelMap map) {
		log.info(" EmployeeController => getAll(...) method execution started");
		try {
			List<EmployeeBean> employeeList = employeeService.getAll();
			map.put("employeeList", employeeList);
		} catch (ServicesException e) {
			log.error(" EmployeeController => getAll(...) exception raised :: " + e);
			map.put("exception", e + " :: " + e.getMessage());
			return "error";
		}
		log.info(" EmployeeController => getAll(...) method execution completed");

		return "success";
	}

	@RequestMapping(path = "/editPage", method = RequestMethod.GET)
	public String editPage(ModelMap map, @RequestParam("empId") Integer empId) {
		log.info(" EmployeeController => editPage(...) method execution started");

		try {
			EmployeeBean employee = employeeService.getById(empId);
			map.put("employeeBean", employee);
		} catch (ServicesException e) {
			log.error(" EmployeeController => editPage(...) exception raised " + e);
			map.put("exception", e + " :: " + e.getMessage());
			return "error";
		}
		log.info(" EmployeeController => editPage(...) method execution completed");
		return "edit";
	}

	@RequestMapping(path = "/saveOrUpdate", method = RequestMethod.POST)
	public String saveOrUpdate(ModelMap map, @ModelAttribute EmployeeBean employeeBean) {
		log.info(" EmployeeController => saveOrUpdate(...) method execution started");

		try {
			employeeService.saveOrUpdate(employeeBean);
			List<EmployeeBean> employeeList = employeeService.getAll();
			map.put("employeeList", employeeList);
		} catch (ServicesException e) {
			log.error(" EmployeeController => saveOrUpdate(...) exception raised " + e);

			map.put("exception", e + " :: " + e.getMessage());
			return "error";
		}
		log.info(" EmployeeController => saveOrUpdate(...) method execution completed");
		return "success";
	}

	@RequestMapping(path = "/delete", method = RequestMethod.GET)
	public String delete(ModelMap map, @RequestParam("empId") Integer empId) {
		log.info(" EmployeeController => delete(...) method execution started");
		try {
			employeeService.delete(empId);
			List<EmployeeBean> employeeList = employeeService.getAll();
			map.put("employeeList", employeeList);
		} catch (ServicesException e) {
			log.error(" EmployeeController => delete(...) exception raised " + e);
			map.put("exception", e + " :: " + e.getMessage());
			return "error";
		}
		log.info(" EmployeeController => delete(...) method execution completed");
		return "success";
	}
}
