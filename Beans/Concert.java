package Beans;

import java.time.LocalDate;
import java.time.LocalTime;

public class Concert  extends Event{
	  private String artistName;
	    private String type;

	    public Concert(int eventID,String eventName, LocalDate eventDate, LocalTime eventTime, Venue venue, int totalSeats, double ticketPrice, String eventType, String artistName, String type) {
	        super(eventID,eventName, eventDate, eventTime, venue, totalSeats, ticketPrice, eventType);
	        this.artistName = artistName;
	        this.type = type;
	    }

	    public String getArtistName() {
	        return artistName;
	    }

	    public void setArtistName(String artistName) {
	        this.artistName = artistName;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }



	    public void displayEventDetails() {
	        System.out.println("Concert Name: " + getEventName() +
	                ", Date: " + getEventDate() +
	                ", Time: " + getEventTime() +
	                ", Venue: " + getVenue().getVenueName() +
	                ", Artist Name: " + getArtistName() +
	                ", Type : " + getType() +
	                ", Ticket price: " + getTicketPrice() +
	                ", Available seats: " + getAvailableSeats());
	    }


}
