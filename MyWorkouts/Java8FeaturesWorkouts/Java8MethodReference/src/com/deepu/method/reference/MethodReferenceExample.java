package com.deepu.method.reference;

public class MethodReferenceExample {
	
	public static void main(String[] args) {
		
		SumFunctionalInterface sum = MethodReferenceExample::addition;
		int result = sum.sum(10, 20);
		System.out.println("The sum of 2 numbers is "+ result);
	}

	private static int addition(int value1, int value2) {
		return value1 + value2;
	}
}
