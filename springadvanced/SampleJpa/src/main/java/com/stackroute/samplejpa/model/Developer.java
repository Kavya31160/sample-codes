package com.stackroute.samplejpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Developer {

	
	@Override
	public String toString() {
		return "Developer [developerId=" + developerId + ", userName=" + userName + ", projectname=" + projectname
				+ "]";
	}


	public Developer() {}


	public Developer(int developerId, String userName, String projectname) {
		super();
		this.developerId = developerId;
		this.userName = userName;
		this.projectname = projectname;
	}

	@Id
	int developerId;
	
	String userName;
	
	String projectname;
	

	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public int getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
