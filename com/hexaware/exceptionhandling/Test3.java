package com.hexaware.exceptionhandling;

public class Test3 {

public static void main(String[] args) {
		
		Test2 test2 = new Test2();
		try {
		test2.division();
		}
		catch(ArithmeticException ae)
		{
			System.out.println("something is wrong in division method, check once");
		}
	}
}
