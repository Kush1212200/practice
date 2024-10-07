package com.hexaware.inheritance;

public class Test4 {

public static void main(String[] args) {
		
		int x= 100;
		//int->double (smaller -> higher)
		double y = x;
		System.out.println(y);
		//byte < short < int < long < float < double 
		
		double z = 4.5;//higher -> smaller
		int i = (int)z;
		System.out.println(i);
	}

	

}
