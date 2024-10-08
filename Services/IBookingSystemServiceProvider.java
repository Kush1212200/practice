package Services;

import Beans.Booking;
import Beans.Customer;
import Beans.Event;
import exception1.EventNotFoundException;
import exception1.InvalidBookingIdException;
import java.util.*;
public interface IBookingSystemServiceProvider {
    double calculateBookingCost(int numTickets, Event event);
    Booking bookTickets(String eventName, int numTickets, Customer customer) throws EventNotFoundException;
    boolean cancelBooking(int bookingId) throws InvalidBookingIdException;
    Booking getBookingDetails(int bookingId);
}
