package com.stackroute.consumer;

import org.springframework.stereotype.Service;

@Service

public class TeamService {
	
	public Team saveTeam(Team teamobj)
	{
		
		//teamcopy.setTeamname(teamobj.getTeamname());
	//	repo.save(teamcopy)
		
		
		return teamobj;
	}

}
