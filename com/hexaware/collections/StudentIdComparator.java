package com.hexaware.collections;
import java.util.*;

public class StudentIdComparator implements Comparator<Student>{

	

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getStid().compareTo(o2.getStid());
	}


	

}
