package bean;

import java.time.LocalDate;
import java.time.LocalTime;

//import bean.Venue;

public class Movie extends Event {
	protected String genre;
	protected String ActorName;
	protected String ActressName;

	public Movie(String event_name, LocalDate date, LocalTime time, // String venue_name,
			Venue venue, int total_seats, int available_seats, double ticket_price, String genre, String ActorName,
			String ActressName) {
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
		System.out.println("Venue: " + venue.getVenue_name());
		System.out.println("Available Seats: " + available_seats + "/" + total_seats);
		System.out.println("Ticket Price: Rs." + ticket_price);
		System.out.println("Genre: " + genre);
		System.out.println("Actor: " + ActorName);
		System.out.println("Actress: " + ActressName);

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
