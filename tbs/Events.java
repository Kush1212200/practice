package tbs;

import java.time.*;
public class Events {

		private String event_name;
		private LocalDate date;
		private LocalTime time;
		private String  venue_name;
		private int total_seats;
		private int available_seats;
		private double ticket_price;
		private String event_type;
		
		public Events() {}
		
	    public Events(String event_name, LocalDate date, LocalTime time, 
	            String venue_name, int total_seats, int available_seats, double ticket_price, String event_type) {
	   this.event_name = event_name;
	   this.date = date;
	   this.time = time;
	   this.venue_name = venue_name;
	   this.total_seats = total_seats;
	   this.available_seats = available_seats; 
	   this.ticket_price = ticket_price;
	   this.event_type = event_type;
	}
	    //getters and setters
	    public String getEventname() {
	    	return event_name;
	    }
	    public void setEventname( String event_name) {
	    	this.event_name = event_name;
	    }
	    public LocalDate getDate() {return date;}
	    public void setDate(LocalDate date) { this.date = date;}
	    
	    public LocalTime getEventTime() { return time; }
	    public void setEventTime(LocalTime time) { this.time = time; }

	    public String getVenueName() { return venue_name; }
	    public void setVenueName(String venue_name) { this.venue_name = venue_name; }

	    public int getTotalSeats() { return total_seats; }
	    public void setTotalSeats(int total_seats) { this.total_seats = total_seats; }

	    public int getAvailableSeats() { return available_seats; }
	    public void setAvailableSeats(int available_seats) { this.available_seats = available_seats; }

	    public double getTicketPrice() { return ticket_price; }
	    public void setTicketPrice(double ticket_price) { this.ticket_price = ticket_price; }
	    
	    public String getEventType() { return event_type;}
	    public void setEventType(String event_type) { this.event_type = event_type;}
	    
	    //methods
	    
	    public double calculate_total_revenue() {
	    	int sold_tickets = total_seats - available_seats;
	    	double revenue = sold_tickets * ticket_price;
	    	return revenue;
	    }
	    
	    public int getBookedNoOfTickets() {
	    	return total_seats - available_seats;
	    }
	    
	    public void book_tickets(int num_tickets) {
	    	if (num_tickets <= available_seats) {
	    		available_seats -= num_tickets;
	    		System.out.println(num_tickets + " Tickets Booked successfully");
	    	}else {
	    		System.out.println("Tickets are not available");
	    	}
	    	
	    }
	    public void cancel_booking(int num_tickets) {
	    	if (num_tickets <= getBookedNoOfTickets()) {
	    		available_seats += num_tickets;
	    		System.out.println(num_tickets + " Tickets canceled successfully");
	    	}else {
	    		System.out.println("cannot cancel more tickets than booked");
	    	}
	    }
	    	
	    public void  display_event_details() 
	    {
	    	System.out.println("Event: " + event_name);
	        System.out.println("Date: " + date);
	        System.out.println("Time: " + time);
	        System.out.println("Venue: " + venue_name);
	        System.out.println("Available Seats: " + available_seats + "/" + total_seats);
	        System.out.println("Ticket Price: Rs." + ticket_price);
	        System.out.println("Event Type: " + event_type);
	   }
	    	
	    	
	    }
	    


