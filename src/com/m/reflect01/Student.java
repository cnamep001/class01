package com.m.reflect01;

public class Student {
	
	static {
		
		System.out.println("Student1");
	}
	
	{
		
		System.out.println("Student2");
	}
	public Student() {
		System.out.println("Student3");
	}

	private Integer id;
	
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		System.out.println("setId");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
