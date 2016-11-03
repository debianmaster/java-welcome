package com.example.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

	private String id;
	private String name;
	private String age;

	public Customer() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
