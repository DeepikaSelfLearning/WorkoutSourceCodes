// To get the output as a-b-c-d from the given array

package com.deepu.java8.interview.questions;

import java.util.Arrays;
import java.util.List;

public class JoinMethodExample {
	
	public static void main(String[] args) {
		
		String[] strArray = {"a", "b", "c", "d"};
		
		String result = String.join("-", strArray);
		
		System.out.println(result);
	}

}
