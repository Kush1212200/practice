package Beans;

public class Customer {
	 private int customerId;
	    private String customerName;
	    private String email;
	    private String phoneNumber;

	    public Customer(int customerId, String customerName, String email, String phoneNumber) {
	        this.customerId = customerId;
	        this.customerName = customerName;
	        this.email = email;
	        this.phoneNumber = phoneNumber;
	    }

	    public int getCustomerId() {
	        return customerId;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }
	    public void displayCustomerDetails() {
	        System.out.println("Customer Name: " + getCustomerName() +
	                ", Email: " + getEmail() +
	                ", Phone: " + getPhoneNumber());
	    }


}
