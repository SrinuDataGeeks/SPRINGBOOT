package com.datageeks.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AccountServiceAdvice {

	@Before(value = "execution(* com.datageeks.service.AccountService.getInfo())")
	public void before()
	{
		System.out.println(" From Cross Cuttring CONCERN => AccountServiceAdvice => before()");
		
	}
}
