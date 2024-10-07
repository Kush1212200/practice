package service;

import bean.Booking;
import bean.Customers;
import bean.Event;
import exception1.InvalidBookingIdException;

public interface IBookingSystemServiceProvider {
	double calculate_booking_cost(int num_tickets, Event event);

	void book_tickets(String event_name, int num_tickets, Customers customers);

	void cancel_booking(int Booking_id) throws InvalidBookingIdException;

	Booking get_booking_details(int Booking_id);

}
