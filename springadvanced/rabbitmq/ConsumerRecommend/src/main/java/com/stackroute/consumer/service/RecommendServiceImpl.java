package com.stackroute.consumer.service;

import java.util.Date;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stackroute.consumer.dao.RecommendDao;
import com.stackroute.consumer.model.Book;
import com.stackroute.consumer.model.Recommend;
@Service
public class RecommendServiceImpl implements RabbitListenerConfigurer{

	@Autowired
	RecommendDao redao;
	
	
	 Book bookobj;
	
	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
	 
	}
	
//	@Value("${spring.rabbitmq.queue}")
//	String queue;
	
	@RabbitListener(queues="${spring.rabbitmq.queue}")
	public void receivedInfo(Book book)
	{
		bookobj=book;
		System.out.println("Object received from producer is  " + bookobj);
		
		Recommend recommend=new Recommend();
		recommend.setBookid(bookobj.getBookid());
		recommend.setBookname(bookobj.getBookname());
		recommend.setAuthor(bookobj.getAuthor());
		recommend.setDofpurchase(new Date());
		
		redao.save(recommend);
		
		
	}
	
	
	public int findBookCount(String bookname)
	{
	List<Recommend> list=redao.findByBookname(bookname);
	if (list.isEmpty())
		return 0;
	else
	return list.size();
	
	
	
	}
	
	

}
