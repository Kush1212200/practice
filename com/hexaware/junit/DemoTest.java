package com.hexaware.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DemoTest {
	
	private Demo demo;
	 @BeforeEach
	    public void setUp() {
	        demo = new Demo();
	    }

	@Test
	 public void test1() {
		int result = demo.Sum(4,5);
		assertEquals(9,result,"The sum should be 9");
       
	}
	
	@Test
	public void test2(){
		int result = demo.Sub(10,5);
		assertEquals(5,result,"the result should be 5");
		
	}
   
}
