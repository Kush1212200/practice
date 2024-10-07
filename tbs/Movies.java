package tbs;

import java.time.LocalDate;
import java.time.LocalTime;

public class Movies extends Event {
	private String genre;
	private String ActorName;
	private String ActressName;

	public Movies(String event_name, LocalDate date, LocalTime time, //String venue_name,
			Venue venue, int total_seats,
			int available_seats, double ticket_price, String genre, String ActorName, String ActressName) {
		super(event_name, date, time, venue, total_seats, available_seats, ticket_price, "Movie");
		this.genre = genre;
		this.ActorName = ActorName;
		this.ActressName = ActressName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getActorName() {
		return ActorName;
	}

	public void setActorName(String actorName) {
		ActorName = actorName;
	}

	public String getActressName() {
		return ActressName;
	}

	public void setActressName(String actressName) {
		ActressName = actressName;
	}

	@Override
	public void get_event_details() {
		// TODO Auto-generated method stub
		System.out.println("Movie: " + event_name);
		System.out.println("Date: " + date);
		System.out.println("Time: " + time);
		System.out.println("Venue: " + venue.getVenueName());
		System.out.println("Available Seats: " + available_seats + "/" + total_seats);
		System.out.println("Ticket Price: Rs." + ticket_price);
		System.out.println("Genre: " + genre);
		System.out.println("Actor: " + ActorName);
		System.out.println("Actress: " + ActressName);

	}

	@Override
	public void book_tickets(int num_tickets) {
		
	     if (getAvailableSeats() >= num_tickets) {
	            setAvailable_seats(getAvailable_seats() - num_tickets);
	            System.out.println(Customers.getCusName() + " successfully booked " + num_tickets + " tickets for " + getEvent_name());
	           
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
