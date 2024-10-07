package com.hexaware.exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		try {

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a first number");
			int s = sc.nextInt();
			System.out.println("Enter a second number");
			int b = sc.nextInt();

			double division = s / b;
			System.out.println("Division is :" + division);
		}

		catch (Exception e) {
			if (e instanceof ArithmeticException) {
				System.out.println("Please do not enter zero in denominator");
			} else if (e instanceof InputMismatchException) {
				System.out.println("Enter only numeric values");

			}
		}
	}
	/*
	 * catch(ArithmeticException e) {
	 * System.out.println("Please do not enter zero in denominator"); }
	 * catch(InputMismatchException ae) {
	 * System.out.println("Enter only numeric values");} }
	 */
}
