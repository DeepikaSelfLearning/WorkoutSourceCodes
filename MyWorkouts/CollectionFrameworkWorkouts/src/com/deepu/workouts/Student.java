package com.deepu.workouts;

public class Student implements Comparable<Student>{
	
	int rollNo;
	String name;
	int age;
	
	
	public Student(int rollNo, String name, int age) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
	}


	@Override
	public int compareTo(Student stud) {
		if(age == stud.age)
		return 0;
		else if(age > stud.age)
			return 1;
		else 
			return -1;
	}


	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", age=" + age + "]";
	}
	
	

}
