package com.hexaware.collections;
import java.util.*;
public class Test6 {
	public static void main(String[] args) {
		//HashSet<Student> s = new HashSet<>();
		//SortedSet<Student> s = new TreeSet<>();
		/*s.add(123);
		s.add(567);
		s.add(345);
		s.add(89);
		s.add(90);
		System.out.println(s);
		System.out.println(s.first());
		System.out.println(s.last());
		System.out.println(s.headSet(567));
		System.out.println(s.tailSet(123));
		System.out.println(s.subSet(89, 567));*/
SortedSet<Student> s = new TreeSet<>((x,y)-> y.getStname().compareTo(x.getStname()));
		
		Student priyanshu = new Student(100,"priyanshu");
		Student krishna = new Student(898,"krishna");
		Student sakshi = new Student(78,"sakshi");
		s.add(priyanshu);
		s.add(krishna);
		s.add(sakshi);
		

		System.out.println(s);
	}

}
