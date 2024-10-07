package tbs;

import java.time.*;

public abstract class Event {
	protected String event_name;
	protected LocalDate date;
	protected LocalTime time;
	//protected String venue_name;
	protected int total_seats;
	protected int available_seats;
	protected double ticket_price;
	protected String event_type;
	protected Venue venue;

	public Event() {

	}

	public Event(String event_name, LocalDate date, LocalTime time, //String venue_name//
			Venue venue, int total_seats,
			int available_seats, double ticket_price, String event_type) {
		this.event_name = event_name;
		this.date = date;
		this.time = time;
		this.setVenue(venue);
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

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	/*public String getVenue_name() {
		return venue_name;
	}

	public void setVenue_name(String venue_name) {
		this.venue_name = venue_name;
	}
*/
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

	public double getTicket_price() {
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
	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}


	public abstract void get_event_details();

	public abstract void book_tickets(int num_tickets);

	public abstract void cancel_tickets(int num_tickets);

	public int getAvailableSeats() {
		return available_seats;
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

	
}
