package com.hexaware.collections;

import java.util.*;
public class Test3 {
	
//Queue is also sub interface of Collections
	// If we want to represent a group of individual objects prior to processing the we should go for 
	//queue and queue follows fifo algorithm.
	//Implementation classes
	//ArrayDeque
	// Linked List
	// Priority Queue
	
	// boolean offer(Object obj)
	// object poll(), Object remove()
	//Object peek = will give you head element --> null
	//Object element() ---will give you head element  ---> exception
	// duplicates are allowed
	// homogenous data  in Priority Queue because it is sorted on priority-- ClassCastException
	//null not possible  NullPointerException
	// in case of linkedlist and Arraydeque both homo and hetero
	//insertion order is  preserved
	//duplicates allowed
	//null possible(only in LLinkedList)
	
	public static void main(String[] args) {
		Queue<String> q = new PriorityQueue<>();
	
		q.offer("e");
		q.offer("sam");
		q.offer("rama");
		q.offer("tom");
		System.out.println(q);
		System.out.println(q.element());
		System.out.println(q.peek());
		//q.clear();
		//System.out.println(q.element()); NoSuchElementException
		System.out.println(q.peek()); // null
		System.out.println(q.poll()); //null also removing head element
		System.out.println(q.peek());
	}
	
	}
