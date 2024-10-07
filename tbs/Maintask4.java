package tbs;
import java.time.*;
public class Maintask4 {
	
	
	    public static void main(String[] args) {
	        Events event = new Events("Concert",  LocalDate.of(2024, 10, 5), LocalTime.of(19, 0), "Madison Square Garden", 5000,5000, 150.0, "Concert");
	        Customers customer = new Customers("John Doe", "john@example.com", "123-456-7890");

	       

	        Booking booking = new Booking(event, customer, 3);


	   

	        // Book tickets
	        booking.book_tickets(5);

	        // Cancel booking
	        booking.cancel_booking(2);

	   
	        event.display_event_details();
	        Customers customer1 = new Customers("Arjun reddy", "arjun.reddy@example.com", "789-648-999");
	        Booking booking1 = new Booking(event, customer, 10);
	       

	        booking1.cancel_booking(5);

	        System.out.println("Available Tickets: "+booking1.getAvailableNoOfTickets());

	        event.display_event_details();
	        booking1.getEventDetails();
	    }
	}



