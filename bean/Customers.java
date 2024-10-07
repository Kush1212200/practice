package bean;

public class Customers {

	protected String customer_name;
	protected String email;
	protected String phonenumber; 
	
    public Customers() {
		// TODO Auto-generated constructor stub
	}

	public Customers(String customer_name, String email, String phonenumber) {
		super();
		this.customer_name = customer_name;
		this.email = email;
		this.phonenumber = phonenumber;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	   // Method 
    public void display_customer_details() {
        System.out.println("Name: " + customer_name);
        System.out.println("Email: " + email);
        System.out.println("PhoneNumber:" + phonenumber);
    }

	
}
