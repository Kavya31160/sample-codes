package com.stackroute.JavaBasedcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.stackroute.JavaBasedcore.Bill;
import com.stackroute.JavaBasedcore.CallbackBean;
import com.stackroute.JavaBasedcore.Customer;
import com.stackroute.JavaBasedcore.Product;

@Configuration

public class MetaBeanConfig {
	
	
	@Bean(name="customerbean",initMethod="myInitialMethod")
	
	public Customer getcustomer()
	{
		Customer custnew=new Customer();
		custnew.setCustomerName("Charles");
		return custnew;
		
	}
	
	
	@Bean
	@Order(1)
	public Product getProduct1()
	{
		
		Product product=new Product();
		product.setPrice(400);
		product.setProdcutName("Mouse");
		return product;
		
	}
	@Bean
	public Product getProduct2()
	{
		
		Product product=new Product();
		product.setPrice(1400);
		product.setProdcutName("Laptopbag");
		return product;
		
	}
	
	@Bean
	public Product getProduct3()
	{
		
		Product product=new Product();
		product.setPrice(8000);
		product.setProdcutName("Speaker");
		return product;
		
	}
	

	@Bean(name="billbean")
	public Bill getBill()
	{
		Bill billobj=new Bill();
		billobj.setBillno("B1033");
		billobj.setCustomerName("Danny");
		return billobj;
	}
	
	@Bean
	public CallbackBean getcall()
	{
		return new CallbackBean();
	}
	
}
