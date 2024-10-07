package bean;

import java.time.LocalDate;
import java.time.LocalTime;

//import bean.Venue;

public class Sports extends Event {
	protected String sportName;
	protected String teamName;

	public Sports(String event_name, LocalDate date, LocalTime time, //String venue_name,
			Venue venue,int total_seats,
			 int available_seats,double ticket_price, String sportName, String teamName) {
		super(event_name, date, time, venue, total_seats, available_seats, ticket_price, "Concert");
		this.sportName = sportName;
		this.teamName = teamName;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public void get_event_details() {
		System.out.println("Sports Event: " + event_name);
		System.out.println("Date: " + date);
		System.out.println("Time: " + time);
		System.out.println("Venue: " + venue.getVenue_name());
		System.out.println("Available Seats: " + available_seats + "/" + total_seats);
		System.out.println("Ticket Price: Rs." + ticket_price);
		System.out.println("Sport: " + sportName);
		System.out.println("Teams: " + teamName);

	}

	@Override
	public void book_tickets(int num_tickets) {

		if (num_tickets <= available_seats) {
			available_seats -= num_tickets;
			System.out.println(num_tickets + " Tickets Booked successfully");
		} else {
			System.out.println("Tickets are not available");
		}

	}

	@Override
	public void cancel_tickets(int num_tickets) {
		if (num_tickets <= getBookedNoOfTickets()) {
			available_seats += num_tickets;
			System.out.println(num_tickets + " Tickets canceled successfully");
		} else {
			System.out.println("Cannot cancel more tickets than booked");
		}

	}

}
