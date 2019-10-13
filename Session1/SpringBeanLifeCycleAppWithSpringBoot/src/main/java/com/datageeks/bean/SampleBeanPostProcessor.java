package com.datageeks.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class SampleBeanPostProcessor implements BeanPostProcessor {
	
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof SampleBean)
		{
		System.out.println("\n Initatlization Phase ::");
		System.out.println(bean.getClass()+" => PRE PROCESSING LOGIC COMPLETED");
		}
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof SampleBean)
		{
		System.out.println(bean.getClass()+" => POST PROCESSING LOGIC COMPLETED");
		}
		return bean;
	}

}
