package com.stackroute.thirdparty.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stackroute.thirdparty.model.Article;
import com.stackroute.thirdparty.model.NewsHead;

@Service
public class NewsService {

 
	
	 RestTemplate restTemplate=new RestTemplate();
	
	public List<Article> getArticles()
	{
	String url="https://newsapi.org/v2/top-headlines?country=us&apiKey=7f118af83e1b48f6939fc5096e89fd22";
	
	//ResponseEntity<String> details=restTemplate.exchange(url, HttpMethod.GET, getEntity(),String.class);
	
	NewsHead newsobj = restTemplate.getForObject(
			"https://newsapi.org/v2/top-headlines?country=us&apiKey=7f118af83e1b48f6939fc5096e89fd22", NewsHead.class);
	
	
//	ResponseEntity responseEntity = 
//		    restTemplate.getForEntity(url); 
	
	List<Article> articles=Arrays.asList( newsobj.getArticles()); 
	
return articles;
	
	
	
	
	
	
}

private HttpEntity getEntity()
{
	HttpHeaders headers=new HttpHeaders();
	//headers.setContentType(MediaType.APPLICATION_JSON);
	headers.set("Accept", "application/json");
	
	//headers.set("Authorization", );
	return new HttpEntity<>(headers);
}
	}
	
	

