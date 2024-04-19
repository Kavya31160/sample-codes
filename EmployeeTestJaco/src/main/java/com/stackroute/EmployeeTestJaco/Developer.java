package com.stackroute.EmployeeTestJaco;

public class Developer {
 public Developer(String name, int experience) {
		super();
		this.name = name;
		this.experience = experience;
	}

String name;
 int experience;
// public Developer()
// {
//	 name="";
//	 experience=0;
// }
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getExperience() {
	return experience;
}
public void setExperience(int experience) {
	this.experience = experience;
}
 
public boolean checkExperience()
{
	boolean flag=false;
	if (experience<0)
	 flag=false;
	else
		flag=true;
	return flag;
}

public String validateExperience() throws InvalidExperienceException
{
	if (experience<1)
		throw new InvalidExperienceException("Invalid Years");
	else
		return "valid";
	//	System.out.println("invalid");
}


public String changeName()
{
	return name.toUpperCase();
}



}
