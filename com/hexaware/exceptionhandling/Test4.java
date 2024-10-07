package com.hexaware.exceptionhandling;

public class Test4 {

public static void main(String[] args) {
		
		String s = "kush";
		if(s.startsWith("k"))
		{
			try {
			throw new ArithmeticException();
			}
			catch(ArithmeticException ae)
			{
				System.out.println("name should not starts with k");
			}
		}
	}
}
