package com.hexaware.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test8 {
	public static void main(String[] args) {
		Map<Integer,String> m = new LinkedHashMap<>();
		m.put(100,"rk");
		m.put(300, "hexaware");
		m.put(200, "amit");
		m.put(500, "rk");
		m.put(600, "rk");
		
		for (Map.Entry<Integer, String> me: m.entrySet()) {
		
			System.out.println(me.getKey() + "  " + me.getValue());

		}
		
	

	}

}
