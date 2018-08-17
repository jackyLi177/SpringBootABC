package com;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "com.springboot.learner")
public class Learner1 {
	private String name;
	private String age;
	private String sex;
	
	@Override
	public String toString() {
		return "Learner [name=" + name + ", age=" + age + ", sex=" + sex + ", toString()=" + super.toString() + "]";
	}
	
	
}
