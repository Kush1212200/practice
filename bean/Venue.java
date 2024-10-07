package bean;

public class Venue {
	protected String venue_name;
	protected String address;
	public Venue() {
		// TODO Auto-generated constructor stub
	}
	public Venue(String venue_name, String address) {
		super();
		this.venue_name = venue_name;
		this.address = address;
	}
	public String getVenue_name() {
		return venue_name;
	}
	public void setVenue_name(String venue_name) {
		this.venue_name = venue_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//Methods
	public void display_venue_details() {
		   System.out.println("Venue: " + venue_name);
	        System.out.println("Address: " + address);
		
	}

}
