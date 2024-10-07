package com.hexaware;

public class Test2 {
	
	int stid ;
	String stname;
	static String cllgname = "PSIT";
	
	  public Test2(int stid, String stname)
      {
		 this.stid = stid;
		  this.stname = stname;
    	  
      }
	  
	  public void getstudentinfo() {
		  System.out.println("Name:" + this.stname);
		  System.out.println("Id:"+ this.stid);
		  System.out.println("cllg name:" + cllgname);
		  
	  }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2 obj = new Test2(100, "Kush");
		
		obj.getstudentinfo();
    
	}

}
