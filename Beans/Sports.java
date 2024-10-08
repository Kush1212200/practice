package Beans;

import java.time.LocalDate;
import java.time.LocalTime;

public class Sports extends Event {
	   private String sportsName;
	    private String teamsName;

	    public Sports(int eventID,String eventName, LocalDate eventDate, LocalTime eventTime, Venue venue, int totalSeats, double ticketPrice, String eventType, String sportsName, String teamsName) {
	        super(eventID,eventName, eventDate, eventTime, venue, totalSeats, ticketPrice, eventType);
	        this.sportsName = sportsName;
	        this.teamsName = teamsName;
	    }

	    public String getSportsName() {
	        return sportsName;
	    }

	    public void setSportsName(String sportsName) {
	        this.sportsName = sportsName;
	    }

	    public String getTeamsName() {
	        return teamsName;
	    }

	    public void setTeamsName(String teamsName) {
	        this.teamsName = teamsName;
	    }


	    public void displayEventDetails() {
	        System.out.println("Sports Name: " + getEventName() +
	                ", Date: " + getEventDate() +
	                ", Time: " + getEventTime() +
	                ", Venue: " + getVenue().getVenueName() +
	                ", Teams Name " + getTeamsName() +
	                ", Ticket price: " + getTicketPrice() +
	                ", Available seats: " + getAvailableSeats());
	    }


}
