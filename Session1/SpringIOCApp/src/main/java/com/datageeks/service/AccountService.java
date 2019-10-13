package com.datageeks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.datageeks.dao.AccountDAO;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO accountDAO ; 
	
	public void getInfo()
	{
		accountDAO.getInfo();
		System.out.println(" Hi From AccountDAO ::");
		
	}

}
