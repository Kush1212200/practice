package Beans;

public class Venue {
	private int venueId;
    private String venueName;
    private String address;

    public Venue(int venueId, String venueName, String address) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.address = address;
    }

    public int getVenueId() {
        return venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public String getAddress() {
        return address;
    }
    public void displayVenueDetails(){
        System.out.println("Venue: " + this.venueName + ", Address: " + this.address);
    }
}



