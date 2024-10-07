package bean;

import java.util.*;

import exception1.EventNotFoundException;
import exception1.InvalidBookingIdException;
import service.IBookingSystemServiceProvider;


public class BookingSystemServiceProviderImpl extends EventServiceProviderImpl implements IBookingSystemServiceProvider{

	protected Map<Integer, Booking> bookings = new HashMap<>();
	 
	 
	@Override
	public double calculate_booking_cost(int num_tickets,Event event) {
		double total_cost = bean.Event.getTicket_price() * num_tickets;
	
		return total_cost;
	}

	@Override
	public void book_tickets(String event_name, int num_tickets, Customers customers) {
		 Event event = null;


	        for (Event e : events) {
	            if (e.getEvent_name().equalsIgnoreCase(event_name)) {
	                event = e;
	                break;
	            }
	        }

	        if (event != null && event.getAvailableSeats() >= num_tickets) {
	            event.setAvailable_seats(event.getAvailableSeats() - num_tickets);
	            Booking booking = new Booking(Booking.getBooking_id(),event, customers, num_tickets,calculate_booking_cost(num_tickets, event));
	            bookings.put(booking.getBooking_id(), booking);
	            System.out.println("Booking successful! " + "Total cost: " + booking.getTotal_cost());
	        } else {
	            System.out.println("Not enough seats available.");
	        }
	    }
	

	@Override
	public void cancel_booking(int Booking_id) throws InvalidBookingIdException {
		  Booking booking = bookings.get(Booking_id);

	        if (booking != null) {
	            Event event = booking.getEvent();
	            int numTicketsToCancel = booking.getNum_tickets();

	            System.out.println("Enter the number of tickets to cancel (out of " + numTicketsToCancel + "):");
	            Scanner scanner = new Scanner(System.in);
	            int ticketsToCancel = scanner.nextInt();

	            if (ticketsToCancel <= 0 || ticketsToCancel > numTicketsToCancel) {
	                System.out.println("Invalid number of tickets to cancel.");
	                return;
	            }
	            event.setAvailable_seats(event.getAvailableSeats() + ticketsToCancel);


	            double refundedAmount = ticketsToCancel * event.getTicketPrice();
	            System.out.println("Refunded amount for " + ticketsToCancel + " tickets is: $" + refundedAmount);

	            booking.setNum_tickets(numTicketsToCancel - ticketsToCancel);
	            double newTotalCost = booking.getNum_tickets() * event.getTicketPrice();
	            booking.setTotal_cost(newTotalCost);


	            if (booking.getNum_tickets() == 0) {
	                bookings.remove(Booking_id);
	                System.out.println("All tickets canceled. Booking and customer details removed.");
	            } else {

	                System.out.println("Booking updated. " + booking.getNum_tickets() + " tickets remain.");
	            }
	        } else {
	        	
	        	 throw new InvalidBookingIdException("Booking not found.");
	        }


	        }
	

	@Override
	public Booking get_booking_details(int Booking_id) {
		  return bookings.get(Booking_id);
    }


	
}
