package tbs;

public class Venue {
	  private String venue_name;
	    private String address;

	    
	    public Venue() {}

	   
	    public Venue(String venue_name, String address) {
	        this.venue_name = venue_name;
	        this.address = address;
	    }

	    // Getters and setters
	    public String getVenueName() { return venue_name; }
	    public void setVenueName( String venue_name) { this.venue_name = venue_name; }

	    public String getAddress() { return address; }
	    public void setAddress(String address) { this.address = address; }

	    // Method 
	    public void display_venue_details() {
	        System.out.println("Venue: " + venue_name);
	        System.out.println("Address: " + address);
	    }
	}


