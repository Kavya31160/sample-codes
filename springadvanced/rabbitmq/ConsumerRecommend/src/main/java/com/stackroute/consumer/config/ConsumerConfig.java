package com.stackroute.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 



@Configuration
public class ConsumerConfig {
	@Value("${spring.rabbitmq.host}")
	String host;
	
	@Value("${spring.rabbitmq.username}")
	String username;
	
	@Value("${spring.rabbitmq.password}")
	String password;
	
	
	@Value("${spring.rabbitmq.exchange}")
	String exchange;
	
	@Value("${spring.rabbitmq.queue}")
	String queue;
	
	@Value("${spring.rabbitmq.routingkey}")
	String routekey;
	
	@Bean
	Queue getQueue()
	{
		return new Queue(queue,true);
	}
	
	
	@Bean
	Exchange getExchange()
	{
		return ExchangeBuilder.directExchange(exchange).durable(true).build();
	}
	
	@Bean
	Binding getBinding()
	{
		return BindingBuilder.bind(getQueue()).to(getExchange()).with(routekey).noargs();
	}
	

	@Bean
	public ConnectionFactory getconnection()
	{
		CachingConnectionFactory cachfactory=new CachingConnectionFactory(host);
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
	public RabbitTemplate getTemplate(ConnectionFactory connection)
	{
		RabbitTemplate rabitobj=new RabbitTemplate(connection);
		
		rabitobj.setMessageConverter(jsonConverter());

			return rabitobj;
	}
	
	
	
	
	
	

}
