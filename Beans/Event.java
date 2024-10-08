package Beans;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {
	  private int eventId;
	    private String eventName;
	    private LocalDate eventDate;
	    private LocalTime eventTime;
	    private Venue venue;
	    private int totalSeats;
	    private int availableSeats;
	    private double ticketPrice;
	    private String eventType;

	    public Event(int eventId, String eventName, LocalDate eventDate, LocalTime eventTime, Venue venue,
	                 int totalSeats, double ticketPrice, String eventType) {
	        this.eventId = eventId;
	        this.eventName = eventName;
	        this.eventDate = eventDate;
	        this.eventTime = eventTime;
	        this.venue = venue;
	        this.totalSeats = totalSeats;
	        this.availableSeats = totalSeats;
	        this.ticketPrice = ticketPrice;
	        this.eventType = eventType;
	    }

	    public int getEventId() {
	        return eventId;
	    }

	    public String getEventName() {
	        return eventName;
	    }

	    public LocalDate getEventDate() {
	        return eventDate;
	    }

	    public LocalTime getEventTime() {
	        return eventTime;
	    }

	    public Venue getVenue() {
	        return venue;
	    }

	    public int getTotalSeats() {
	        return totalSeats;
	    }

	    public int getAvailableSeats() {
	        return availableSeats;
	    }

	    public double getTicketPrice1() {
	        return ticketPrice;
	    }

	    public String getEventType1() {
	        return eventType;
	    }
	    public void setAvailableSeats(int availableSeats) {
	        this.availableSeats = availableSeats;
	    }

	    public double getTicketPrice() {
	        return this.ticketPrice;
	    }

	    public void setTicketPrice(double ticketPrice) {
	        this.ticketPrice = ticketPrice;
	    }

	    public String getEventType() {
	        return this.eventType;
	    }

	    public void setEventType(String eventType) {
	        this.eventType = eventType;
	    }

	    public double calTotalRevenue(){
	        return (totalSeats - availableSeats) * ticketPrice;
	    }

	    


	    public int getBookedNoOfTickets(){
	        return totalSeats - availableSeats;
	    }

	    public boolean bookTickets(int numOfTickets){
	        if(availableSeats >= numOfTickets){
	            availableSeats -= numOfTickets;
	            return true;
	        }else{
	            return false;
	        }
	    }

	    public void cancelBooking(int numOfTickets){
	        availableSeats += numOfTickets;
	        System.out.println("Tickets were cancelled!");
	    }

	    public void displayEventDetails() {
	        System.out.println("Event: " + this.eventName + ", Date: " + this.eventDate + ", Time: " + this.eventTime +
	                ", Venue: " + this.venue + ", Available Seats: " + this.availableSeats +
	                ", Ticket Price: " + this.ticketPrice + ", Type: " + this.eventType);
	    }


}
