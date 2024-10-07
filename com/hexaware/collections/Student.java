package com.hexaware.collections;

public class Student implements Comparable<Student> {
	private Integer stid;
	private String stname;
	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	public String getStname() {
		return stname; 
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(Integer stid, String stname) {
		
		this.stid = stid;
		this.stname = stname;
	}
	@Override
	public String toString() {
		return stid+ " "+ stname ;
	}
	@Override
	public int compareTo(Student o) {
		/*Student o1 = (Student) o;
	
		if(stid > o1.getStid()) {
			return +1;
		}
		else if(stid < o1.getStid()) {
			return -1;
		}
		else { return 0;
		
	}*/
		return this.getStid().compareTo(o.getStid());
		// return o.getStname().compareTo(this.getStname());
	}
}
