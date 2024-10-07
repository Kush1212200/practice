package tbs;

public abstract class Bookingsystems {

	public abstract  Event createEvent(String event_name, String date, String time, int total_seats, int available_seats, double ticket_price,
			String event_type, String venue_name);
	public abstract void get_event_details(Event event);
	public abstract double book_tickets(Event event , int num_tickets);
	public abstract void cancel_tickets(Event event , int num_tickets);
}
