package com.stackroute.thirdparty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.thirdparty.model.Article;
import com.stackroute.thirdparty.service.NewsService;

@RestController
public class NewsController {
	
	//@Autowired
	NewsService newsservice;
	
	public NewsController(NewsService nserve)
	{
		newsservice=nserve;
	}
	
	
	
	@RequestMapping(value="/viewnews",method=RequestMethod.GET,consumes=MediaType.ALL_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<?> getnews()
	{
	List<Article> articles=newsservice.getArticles();
	return new ResponseEntity(articles,HttpStatus.OK);
	}

}
