package com.stackroute.shopping.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {

	@Value("${spring.rabbitmq.host}")
	String myhost;
	
	@Value("${spring.rabbitmq.username}")
	String username;
	
	@Value("${spring.rabbitmq.password}")
	String password;

	@Bean
	public ConnectionFactory getconnection()
	{
		CachingConnectionFactory cachfactory=new CachingConnectionFactory(myhost);
		cachfactory.setUsername(username);
		cachfactory.setPassword(password);
		return cachfactory;
		
	}
	
	@Bean
	public MessageConverter jsonConverter()
	{
		return new Jackson2JsonMessageConverter();
	}
	
	
	@Bean
	public RabbitTemplate getTemplate(ConnectionFactory conobj)
	{
		RabbitTemplate rtemp=new RabbitTemplate(conobj);
		rtemp.setMessageConverter(jsonConverter());
		return rtemp;
		
		
	}
	
	
	
	
}
