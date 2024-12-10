package com.deepu.workouts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {

	public static void main(String[] args) {
		
		List<Student> studentList = new ArrayList<>();
		
		Student s1 = new Student(1,"Deepu",36);
		Student s2 = new Student(2,"Dhruvith", 8);
		Student s3 = new Student(3,"Prasanna",77);
		Student s4 = new Student(4,"Sujatha",62);
		Student s5 = new Student(5,"Adveesh",72);
		Student s6 = new Student(6,"Veda",42);
		Student s7 = new Student(7,"Chandu",40);
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);
		studentList.add(s6);
		studentList.add(s7);
		
		Collections.sort(studentList);
		
		for(Student stud : studentList) {
			System.out.println(stud);
		}
		
		
	}
}
