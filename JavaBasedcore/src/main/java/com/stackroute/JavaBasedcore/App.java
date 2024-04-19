package com.stackroute.JavaBasedcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.JavaBasedcore.config.MetaBeanConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    { 
    	
    	ApplicationContext appcontext=new AnnotationConfigApplicationContext(MetaBeanConfig.class);
    	
    	
    	Bill billobj=appcontext.getBean("billbean",Bill.class);
    	
    	Customer custobj=appcontext.getBean("customerbean",Customer.class);
    	
    	
    	
    	System.out.println(billobj);
    	
    	System.out.println(custobj);
    	
    	
    }
}
