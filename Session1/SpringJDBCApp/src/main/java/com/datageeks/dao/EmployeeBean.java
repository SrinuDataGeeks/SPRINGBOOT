package com.datageeks.dao;

import java.io.Serializable;

public class EmployeeBean implements Serializable {

	private Integer employeeId = null;
	private String employeeName = null;
	private Float employeeSal = null;

	
	public EmployeeBean() {
	}

	

	public EmployeeBean(Integer employeeId, String employeeName, Float employeeSal) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSal = employeeSal;
	}



	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Float getEmployeeSal() {
		return employeeSal;
	}

	public void setEmployeeSal(Float employeeSal) {
		this.employeeSal = employeeSal;
	}

	@Override
	public String toString() {
		return "EmployeeBean [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeSal="
				+ employeeSal + "]";
	}

}
