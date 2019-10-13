
package com.datageeks.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.datageeks.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService = null;
	
	public void getInfo()
	{
		accountService.getInfo();
		System.out.println(" Hi From AccountDAO ::");
		
	}

}
