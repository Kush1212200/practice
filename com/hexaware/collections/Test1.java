package com.hexaware.collections;
import java.util.*;
public class Test1 {
	public static void main(String[] args) {
		
		ArrayList<Integer> l = new ArrayList<>();
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
		
		ArrayList<Integer> l1 = new ArrayList<>();
		l1.add(6);
		l1.add(89);
		l1.add(45);
		
		l.addAll(l1);
		System.out.println(l);
		l.removeAll(l1);
		System.out.println(l);
		System.out.println(l.isEmpty());
		l.clear();
		System.out.println(l.isEmpty());
		
		
	}
 
}
