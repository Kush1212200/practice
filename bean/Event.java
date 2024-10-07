package bean;

import java.time.LocalDate;
import java.time.LocalTime;

//import bean.Venue;

public abstract class Event {
	protected String event_name;
	protected LocalDate date;
	protected Venue venue;
	protected LocalTime time;
	protected int total_seats;
	protected int available_seats;
	protected static double ticket_price;
	protected String event_type;
	
   public Event() {
	// TODO Auto-generated constructor stub
}

public Event(String event_name, LocalDate date, LocalTime time, Venue venue, int total_seats, int available_seats,
		double ticket_price, String event_type) {
	this.event_name = event_name;
	this.date = date;
	this.time = time;
	this.venue = venue;
	this.total_seats = total_seats;
	this.available_seats = available_seats;
	this.ticket_price = ticket_price;
	this.event_type = event_type;
}

public String getEvent_name() {
	return event_name;
}

public void setEvent_name(String event_name) {
	this.event_name = event_name;
}

public LocalDate getDate() {
	return date;
}

public void setDate(LocalDate date) {
	this.date = date;
}

public Venue getVenue() {
	return venue;
}

public void setVenue(Venue venue) {
	this.venue = venue;
}

public LocalTime getTime() {
	return time;
}

public void setTime(LocalTime time) {
	this.time = time;
}

public int getTotal_seats() {
	return total_seats;
}

public void setTotal_seats(int total_seats) {
	this.total_seats = total_seats;
}

public int getAvailable_seats() {
	return available_seats;
}

public void setAvailable_seats(int available_seats) {
	this.available_seats = available_seats;
}

public static double getTicket_price() {
	return ticket_price;
}

public void setTicket_price(double ticket_price) {
	this.ticket_price = ticket_price;
}

public String getEvent_type() {
	return event_type;
}

public void setEvent_type(String event_type) {
	this.event_type = event_type;
}
public abstract void get_event_details();

public abstract void book_tickets(int num_tickets);

public abstract void cancel_tickets(int num_tickets);

public int getAvailableSeats() {
	return this.available_seats;
}

public double getTicketPrice() {
	return ticket_price;
}

public int getBookedNoOfTickets() {
	return total_seats - available_seats;
}

public double calculate_total_revenue() {
	int sold = total_seats - available_seats;
	return sold * ticket_price;
}
public void updateAvailableSeats(int num_tickets) {
    this.available_seats -= num_tickets;
}

public void restoreSeats(int num_tickets) {
    this.available_seats += num_tickets;
}

	

}