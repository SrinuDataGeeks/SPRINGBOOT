package com.datageeks.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SampleBean {
	
	private String demoMessage = null;
	
	 public SampleBean() {
		 System.out.println(" \n Instatiation Phase :: ");
		 System.out.println(" SampleBean Object is created !!!");
	}
	
	
	@Value("${message}")
	public void setDemoMessage(String demoMessage) {
		System.out.println(" Dependecy Injection Completed !!!");
		this.demoMessage = demoMessage;
	}
	
	
	@PostConstruct
	public void init()
	{
		System.out.println(" SampleBean   init() method execution completed");
		
	}
	
	public void getService()
	{
		System.out.println("\n Servicing Phase ::");
		System.out.println(" Ready to give Services message =>"+demoMessage);
		
	}
	
	
	@PreDestroy
	public void destroy()
	{
		System.out.println("\n Destruction Phase :");
		System.out.println(" SampleBean   destroy() method execution completed");
		
	}
	
	@Override
	protected void finalize() throws Throwable {
		
		System.out.println(" From finalize() :: Spring Container Removed SampleBean Object");
	}
	

}
