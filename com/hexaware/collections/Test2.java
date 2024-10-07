package com.hexaware.collections;
import java.util.*;
public class Test2 {
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
		l.add(5);
		l.add(4);
		l.add(60);
		l.add(5);
		l.add(1,40);
		
System.out.println(l);
		
		System.out.println(l.size());
		System.out.println(l.get(2));
		System.out.println(l.indexOf(5));
		System.out.println(l.lastIndexOf(5));
		System.out.println(l.remove(1));
		l.remove(Integer.valueOf(40));
		System.out.println(l);
		System.out.println(l.contains(500));
	}

}
