package tbs;

import java.time.*;
import java.util.Scanner;

public class TicketBookingSystem {

	public Events createEvent(String event_name, String date, String time, int total_seats, int available_seats, double ticket_price,
			String event_type, String venue_name) {
		LocalDate eventDate = LocalDate.parse(date);
		LocalTime eventTime = LocalTime.parse(time);

		if (event_type.equalsIgnoreCase("Movie")) {
			return new Movie(event_name, eventDate, eventTime, venue_name, total_seats,available_seats,ticket_price, "Action",
					"Tom Cruise", "Scarlett Johansson");
		} else if (event_type.equalsIgnoreCase("Concert")) {
			return new Concert(event_name, eventDate, eventTime, venue_name, total_seats, available_seats,ticket_price, "Coldplay",
					"Rock");
		} else if (event_type.equalsIgnoreCase("Sports")) {
			return new Sports(event_name, eventDate, eventTime, venue_name, total_seats,available_seats, ticket_price, "Football",
					"India vs Pakistan");
		}
		return null;
	}

	public void display_event_details(Events event) {
		event.display_event_details();
	}

	public double book_tickets(Events event, int num_tickets) {
		double total_cost = 0.0;
		if (num_tickets <= event.getAvailableSeats()) {
			event.book_tickets(num_tickets);
			total_cost = event.getTicketPrice() * num_tickets;
			System.out.println("Total cost: Rs" + total_cost);
		} else {
			System.out.println("Sold Out!!!");
		}

		return total_cost;
	}

	public void cancel_tickets(Events event, int num_tickets) {
		event.cancel_booking(num_tickets);
	}

	public static void main(String[] args) {
		TicketBookingSystem system = new TicketBookingSystem();
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to the Ticket Booking System!");
		System.out.println("Choose an event type by typing the associated digit: 1. Movie 2. Concert 3. Sports");
		int choice = sc.nextInt();
		sc.nextLine();

		Events event = null;
		switch (choice) {
		case 1:
			event = system.createEvent("Mission Impossible", "2024-10-10", "18:00", 100,100, 15.00, "Movie",
					"IMAX Theater");
			break;
		case 2:
			event = system.createEvent("Coldplay Concert", "2024-11-05", "20:00", 200,200, 75.00, "Concert", "Stadium");
			break;
		case 3:
			event = system.createEvent("Football Match", "2024-12-01", "19:00", 500,500,50.00, "Sports",
					"National Stadium");
			break;
		default:
			System.out.println("Invalid choice!");
			return;
		}

		system.display_event_details(event);

		System.out.println("Enter number of tickets to book:");
		int num_tickets = sc.nextInt();
		system.book_tickets(event, num_tickets);

		System.out.println("Enter number of tickets to cancel:");
		int cancel_tickets = sc.nextInt();
		system.cancel_tickets(event, cancel_tickets);

		system.display_event_details(event);
	}
}
