package com.stackroute.JavaBasedcore;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class CallbackBean implements BeanPostProcessor{
	

public Object postProcessBeforeInitialization(Object bean, String beanName)
{
	System.out.println(" New Instance of bean is created " + beanName);
	return bean;
}

	
public Object	postProcessAfterInitialization(Object bean, String beanName)
	{
		System.out.println( " Bean created and some properties are set " + beanName);
		
		if (bean instanceof Customer)
		{
			Customer cust=(Customer) bean;
			cust.setCustomerName("Steffy Graph");
			return cust;
		}
		
		return bean;
	
	}
	

}
