package com.deepu.java8.interview.questions;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private int id;
	private String name;
	private long mobileNumber;
	private int age;
	
	public Student(int id, String name, long mobileNumber, int age) {
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.age = age;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", age=" + age + "]";
	}
	
	

}
