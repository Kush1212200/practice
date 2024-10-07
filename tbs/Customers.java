package tbs;

public class Customers {

	  private static String customer_name;
	    private String email;
	    private String phonenumber;

	    
	    public Customers() {}

	   
	    public Customers(String customer_name, String email, String phonenumber) {
	        this.customer_name = customer_name;
	        this.email = email;
	        this.phonenumber = phonenumber;
	    }

	    // Getters and setters
	    public static String getCusName() { return customer_name; }
	    public void setCusName(String customer_name) { this.customer_name = customer_name; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }
	    
	    public String getPhoneNumber() {return phonenumber;}
	    public void setPhoneNumber(String phonenumber) { this.phonenumber = phonenumber;}

	    // Method 
	    public void display_customer_details() {
	        System.out.println("Name: " + customer_name);
	        System.out.println("Email: " + email);
	        System.out.println("PhoneNumber:" + phonenumber);
	    }
}
