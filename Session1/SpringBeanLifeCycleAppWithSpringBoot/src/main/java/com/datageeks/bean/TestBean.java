package com.datageeks.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestBean {
	
	@Autowired
	private SampleBean sampleBean;
	
	
	public void getService()
	{
		sampleBean.getService();
	}

}
