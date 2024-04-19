package com.stackroute.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import com.google.gson.Gson;

@Configuration
public class TeamConfig {

@Autowired
	
	Gson gson;

@Autowired
TeamService teamservice;
	
	@KafkaListener(topics = "mytopic",groupId = "group_id")
	public void consume(String team)
	{

	///teamobj=gson.fromJson(team,Team.class);
//	 System.out.println("received message = " + teamobj.getTeamname() );
		
		System.out.println("received message = " + team);
	Team	teamobj=gson.fromJson(team,Team.class);
	
	
	//Team result= teamservice.saveTeam(teamobj);
		System.out.println("stored data in teamcopy" + teamobj.toString());
	}
}
