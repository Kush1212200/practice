package com.hexaware.collections;
import java.util.*;
public class Test5 {
	public static void main(String[] args) {
		ArrayList<Student> o = new ArrayList<>();
		
		o.add(new Student(100,"Kush"));
		o.add(new Student(140,"Ankush"));
		o.add(new Student(670,"Ram"));
		
		System.out.println(o);
		for(Student s : o) {
			System.out.println(s);
		}
		for(Student s : o) {
			if(s.getStname().startsWith("A"))
			System.out.println(s);
		}
	}

}
