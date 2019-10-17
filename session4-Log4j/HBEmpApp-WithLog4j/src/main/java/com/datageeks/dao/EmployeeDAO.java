package com.datageeks.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

	Logger log = LoggerFactory.getLogger(EmployeeDAO.class);

	@Autowired
	private EntityManager entityManager = null;

	public void saveOrUpdate(EmployeeBean employeeBean) throws DataSourceException {
		log.debug(" EmployeeDAO => saveOrUpdate(...) method execution started");
		try {

			Session session = entityManager.unwrap(Session.class);
			session.saveOrUpdate(employeeBean);

		} catch (HibernateException exp) {
			log.error(" Exception raised in EmployeeDAO => saveOrUpdate(...) method" + exp);
			throw new DataSourceException(exp.getMessage());
		}
		log.debug(" EmployeeDAO => saveOrUpdate(...) method execution Complted");
	}

	public List<EmployeeBean> getAll() throws DataSourceException {
		log.debug(" EmployeeDAO => getAll(...) method execution started");
		List<EmployeeBean> empList = null;
		try {
			Session session = entityManager.unwrap(Session.class);
			empList = session.createQuery("Select emp From EmployeeBean as emp", EmployeeBean.class).getResultList();
		} catch (HibernateException exp) {
			log.error(" Exception raised in EmployeeDAO => getAll(...) method" + exp);
			throw new DataSourceException(exp.getMessage());
		}
		log.debug(" EmployeeDAO => getAll(...) method execution complted empList = " + empList);
		return empList;
	}

	public EmployeeBean getById(Integer empId) throws DataSourceException {
		log.debug(" EmployeeDAO => getById(...) method execution started");

		EmployeeBean emp = null;
		try {
			Session session = entityManager.unwrap(Session.class);
			TypedQuery<EmployeeBean> query = session
					.createQuery("Select emp From EmployeeBean as emp where emp.employeeId = :id", EmployeeBean.class);
			query.setParameter("id", empId);
			emp = query.getSingleResult();

		} catch (NoResultException exp) {
			return null;
		} catch (HibernateException exp) {
			log.error(" Exception raised in EmployeeDAO => getById(...) method" + exp);
			throw new DataSourceException(exp.getMessage());
		}
		log.debug(" EmployeeDAO => getById(...) method execution completed");
		return emp;
	}

	public void delete(Integer empId) throws DataSourceException {
		log.debug(" EmployeeDAO => delete(...) method execution completed");
		try {

			Session session = entityManager.unwrap(Session.class);
			EmployeeBean emp = session.get(EmployeeBean.class, empId);
			session.delete(emp);

		} catch (HibernateException exp) {
			log.error(" Exception raised in EmployeeDAO => delete(...) method" + exp);
			throw new DataSourceException(exp.getMessage());
		}
		log.debug(" EmployeeDAO => delete(...) method execution completed");
	}

}
