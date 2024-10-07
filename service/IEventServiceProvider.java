package service;

import bean.Event;
import bean.Venue;

public interface IEventServiceProvider {
	Event create_event(String event_name, String date, String time, Venue venue, int total_seats, int available_seats,
			double ticket_price, String event_type);

	Event[] get_event_details();

	int getAvailableNoOfTickets(String event_name);

}
