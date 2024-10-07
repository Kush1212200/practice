package tbs;

import java.time.LocalDate;
import java.time.LocalTime;

public class Concerts extends Event {
	private String artist;
	private String type;

	public Concerts(String event_name, LocalDate date, LocalTime time,// String venue_name,
			Venue venue, int total_seats,
			int available_seats,double ticket_price, String artist, String type) {
		super(event_name, date, time, venue, total_seats, available_seats, ticket_price, "Concert");
		this.artist = artist;
		this.type = type;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void get_event_details() {
		// TODO Auto-generated method stub
		System.out.println("Concert: " + event_name);
		System.out.println("Date: " + date);
		System.out.println("Time: " + time);
		System.out.println("Venue: " + venue.getVenueName());
		System.out.println("Available Seats: " + available_seats + "/" + total_seats);
		System.out.println("Ticket Price: Rs." + ticket_price);
		System.out.println("Artist: " + artist);
		System.out.println("Concert Type: " + type);

	}

	@Override
	public void book_tickets(int num_tickets) {
		// TODO Auto-generated method stub
		if (num_tickets <= available_seats) {
			available_seats -= num_tickets;
			System.out.println(num_tickets + " Tickets Booked successfully");
		} else {
			System.out.println("Tickets are not available");
		}
	}

	@Override
	public void cancel_tickets(int num_tickets) {
		// TODO Auto-generated method stub
		if (num_tickets <= getBookedNoOfTickets()) {
			available_seats += num_tickets;
			System.out.println(num_tickets + " Tickets canceled successfully");
		} else {
			System.out.println("Cannot cancel more tickets than booked");
		}
	}

}
