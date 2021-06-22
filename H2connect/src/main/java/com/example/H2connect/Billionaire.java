package com.example.H2connect;

import javax.persistence.Entity;   
import javax.persistence.Id;  
@Entity    
public class Billionaire   
{   
@Id    
private long id;    
private String first_name;    
private String last_name;
private String career;

//default constructor    
public Billionaire()  
{  
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getFirst_name() {
	return first_name;
}

public void setFirst_name(String first_name) {
	this.first_name = first_name;
}

public String getLast_name() {
	return last_name;
}

public void setLast_name(String last_name) {
	this.last_name = last_name;
}

public String getCareer() {
	return career;
}

public void setCareer(String career) {
	this.career = career;
}    
}