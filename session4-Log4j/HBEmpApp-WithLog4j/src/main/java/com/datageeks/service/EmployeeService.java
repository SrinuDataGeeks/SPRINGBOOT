package com.datageeks.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.datageeks.dao.DataSourceException;
import com.datageeks.dao.EmployeeBean;
import com.datageeks.dao.EmployeeDAO;

@Service
public class EmployeeService {
	Logger log = LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	private EmployeeDAO employeeDAO = null;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ServicesException.class)
	public void saveOrUpdate(EmployeeBean employeeBean) throws ServicesException {
		log.info(" EmployeeService => saveOrUpdate(...) method execution started");
		try {
			employeeDAO.saveOrUpdate(employeeBean);
		} catch (DataSourceException exp) {
			log.error(" EmployeeService => saveOrUpdate(...) method exception raised" + exp);
			throw new ServicesException(exp.getMessage());
		}
		log.info(" EmployeeService => saveOrUpdate(...) method execution completed");
	}

	public List<EmployeeBean> getAll() throws ServicesException {
		log.info(" EmployeeService => getAll(...) method execution started");
		List<EmployeeBean> empList = null;
		try {
			empList = employeeDAO.getAll();
		} catch (DataSourceException exp) {
			log.error(" EmployeeService => getAll(...) method exception raised" + exp);
			throw new ServicesException(exp.getMessage());
		}
		log.info(" EmployeeService => getAll(...) method execution completed");
		return empList;
	}

	public EmployeeBean getById(Integer empId) throws ServicesException {
		log.info(" EmployeeService => getById(...) method execution started");
		EmployeeBean emp = null;
		try {
			emp = employeeDAO.getById(empId);
		} catch (DataSourceException exp) {
			log.error(" EmployeeService => getById(...) method execution completed");
			throw new ServicesException(exp.getMessage());
		}
		log.info(" EmployeeService => getById(...) method execution completed");
		return emp;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ServicesException.class)
	public void delete(Integer empId) throws ServicesException {
		log.info(" EmployeeService => delete(...) method execution started");

		try {
			employeeDAO.delete(empId);
		} catch (DataSourceException exp) {
			log.error(" EmployeeService => delete(...) method execution completed");
			throw new ServicesException(exp.getMessage());
		}
		log.info(" EmployeeService => delete(...) method execution complted");
	}

}
