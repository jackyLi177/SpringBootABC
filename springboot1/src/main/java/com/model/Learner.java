package com.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Learner {
	private String name;
	private String age;
	private String sex;
	
	public Learner(String name,String age,String sex){
		log.info("@slf4j constructor with three arguments===============");
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	
	public Learner() {
	}


	@Override
	public String toString() {
		return "Learner [name=" + name + ", age=" + age + ", sex=" + sex + ", toString()=" + super.toString() + "]";
	}
	
	
}
