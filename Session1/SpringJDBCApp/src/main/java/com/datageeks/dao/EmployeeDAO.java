package com.datageeks.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate = null;

	public void save(EmployeeBean employeeBean) throws DataSourceException {
		try {
			jdbcTemplate.update("Insert Into Employee(EMP_ID,EMP_NAME,EMP_SAL) Values(?,?,?)",
					employeeBean.getEmployeeId(), employeeBean.getEmployeeName(), employeeBean.getEmployeeSal());
		} catch (DataAccessException exp) {
			throw new DataSourceException(exp.getMessage());
		}
	}

	public List<EmployeeBean> getAll() throws DataSourceException {
		List<EmployeeBean> empList = null;
		try {
			RowMapper<EmployeeBean> mapper = new RowMapper<EmployeeBean>() {

				@Override
				public EmployeeBean mapRow(ResultSet rs, int rowNum) throws SQLException {
					EmployeeBean emp = new EmployeeBean();
					emp.setEmployeeId(rs.getInt("EMP_ID"));
					emp.setEmployeeName(rs.getString("EMP_NAME"));
					emp.setEmployeeSal(rs.getFloat("EMP_SAL"));
					return emp;
				}
			};

			empList = jdbcTemplate.query("Select EMP_ID,EMP_NAME,EMP_SAL From Employee", mapper);
		} catch (DataAccessException exp) {
			throw new DataSourceException(exp.getMessage());
		}
		return empList;
	}

	public EmployeeBean getById(Integer empId) throws DataSourceException {
		EmployeeBean emp = null;
		try {
			RowMapper<EmployeeBean> mapper = new RowMapper<EmployeeBean>() {

				@Override
				public EmployeeBean mapRow(ResultSet rs, int rowNum) throws SQLException {
					EmployeeBean emp = new EmployeeBean();
					emp.setEmployeeId(rs.getInt("EMP_ID"));
					emp.setEmployeeName(rs.getString("EMP_NAME"));
					emp.setEmployeeSal(rs.getFloat("EMP_SAL"));
					return emp;
				}
			};

			emp = jdbcTemplate.queryForObject("Select EMP_ID,EMP_NAME,EMP_SAL From Employee Where EMP_ID = ?", mapper,
					empId);
		} catch (DataAccessException exp) {
			throw new DataSourceException(exp.getMessage());
		}
		return emp;
	}

}
