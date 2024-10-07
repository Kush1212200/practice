package com.hexaware.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test10 {
	public static void main(String[] args) {
		
	/*List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
	int sum = numbers.stream()
	                 .reduce(0, Integer::sum);
	   System.out.println(sum);    */
		
	/*ArrayList<String> s1 = new ArrayList<>();
	s1.add("k");
	s1.add("an");
	s1.add("av");
	s1.add("w");
	*/
	//s1.stream().map(x->x.toUpperCase()).forEach(x->System.out.println(x));
	//s1.stream().sorted().collect(Collectors.toList()).forEach(x->System.out.println(x));;
	//s1.stream().limit(2).forEach(x->System.out.println());
 // System.out.println(s1);
	List<List<String>> names = Arrays.asList(Arrays.asList("Alice", "Bob"), Arrays.asList("Charlie", "David"));
	List<String> flatList = names.stream()
	                             .flatMap(Collection::stream)
	                             .collect(Collectors.toList());
System.out.println(flatList);
	}
}
