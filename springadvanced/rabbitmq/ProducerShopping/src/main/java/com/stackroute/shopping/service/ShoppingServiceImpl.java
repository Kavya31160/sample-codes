package com.stackroute.shopping.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stackroute.shopping.dao.ShoppingDao;
import com.stackroute.shopping.model.Book;


@Service
public class ShoppingServiceImpl implements ShoppingService {

	RabbitTemplate rabbitobj;
	
	@Value("${spring.rabbitmq.exchange}")
	String exchange;
	
	
	@Value("${spring.rabbitmq.routingkey}")
	String routekey;
	
	@Autowired
	public ShoppingServiceImpl(RabbitTemplate rtemp)
	{
		this.rabbitobj=rtemp;
	}
	
	@Autowired
	ShoppingDao dao;
	
	@Override
	public Book addbook(Book book) {
	return	 dao.save(book);
	}

	@Override
	public void sendBook(Book bookobj) {
		 
		rabbitobj.convertAndSend(exchange,routekey,bookobj);
		
	}

}
