package repository;

import Beans.Booking;
import Beans.Event;
import Beans.Customer;
import Beans.Venue;

import java.util.List;

public interface IBookingSystemRepository {
    Event createEvent(String eventName, String date, String time, int totalSeats, double ticketPrice, String eventType, Venue venue);
    List<Event> getEventDetails();
    int getAvailableNoOfTickets(String eventName);
    double calculateBookingCost(int numTickets, double ticketPrice);
    Booking bookTickets(String eventName, int numTickets, Customer customer);
    boolean cancelBooking(int bookingId);
    Booking getBookingDetails(int bookingId);
}

