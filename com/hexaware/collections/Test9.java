package com.hexaware.collections;

import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class Test9 {
public static void main(String[] args) {
		
		SortedMap<Integer, String> m = new TreeMap<Integer,String>(new Desc());
		
		m.put(100, "rk");
		m.put(2000, "hexaware");
		m.put(1300, "amit");
		m.put(40, "hemanth");
		m.put(250, "kavitha");
		m.put(6000, "rese");
		
		for(Entry<Integer, String> me: m.entrySet())
		{
			System.out.println(me.getKey());
		}

	}

}