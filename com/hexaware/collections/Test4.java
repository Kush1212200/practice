package com.hexaware.collections;
import java.util.*;
public class Test4 {
	public static void main(String[] args) {
		//Set s = new LinkedHashSet();
		Set<Integer> s = new HashSet<>();
		for(int i = 1;i<=10 ; i++) {
			s.add(i);
		}
		/*s.add("abc");
		s.add(null);
		s.add(123);
		s.add(true);
		s.add(123);*/
	//	for(Object o : s) {
		//	Integer i = (Integer)o;
		//	if(i % 2 == 0)
		for(Integer o :s) {
			if(o % 2 == 0)
			System.out.println(o);
		}
		
		System.out.println(s);//no duplicates 
		//insertion order not able to maintain and to predict for hashset
		//linkedhashset set allows to preserve insertion order
	}

}
