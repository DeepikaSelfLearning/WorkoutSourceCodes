package com.deepu.java8.interview.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAssignment {

	public static void main(String[] args) {
		
		new StreamAssignment().getStudents().stream()
									.filter(stud -> stud.getAge() > 25)
									.map(stud -> stud.getName()).limit(2)
									.forEach(student -> System.out.println(student));
		
		
	}
	
	public List<Student> getStudents(){
		
		List<Student> studentList = new ArrayList<>();
		
		Student deepu = new Student(1, "Deepu", 23456789056L, 36);
		Student dhruvith = new Student(2, "Dhruvith", 2345678901L, 8);
		Student sujatha = new Student(3, "Sujatha", 2365859056L, 62);
		Student adveesh = new Student(4, "Adveesh", 23453258901L, 72);
		Student veda = new Student(5, "Veda", 23436989056L, 42);
		Student chandu = new Student(6, "Chandu", 2345965901L, 40);
		
		studentList.add(deepu);
		studentList.add(dhruvith);
		studentList.add(sujatha);
		studentList.add(adveesh);
		studentList.add(veda);
		studentList.add(chandu);
		
		return studentList;
	}
}
