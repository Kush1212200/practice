package tbs;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class BookingSystem3 {

	private ArrayList<Event> events = new ArrayList<>();
	private ArrayList<Bookings> bookings = new ArrayList<>(); 

	public Event createEvent(String event_name, String date, String time, Venue venue, int total_seats, 
              int available_seats,double ticket_price, String event_type) {
LocalDate eventDate = LocalDate.parse(date);
LocalTime eventTime = LocalTime.parse(time);
Event event = null;
	
switch (event_type.toLowerCase()) {
case "movie":
	event = new Movies(event_name, eventDate, eventTime, venue, total_seats, available_seats, ticket_price,
			"Action", "Tom Cruise", "Scarlett Johansson");
	break;
case "concert":
	event = new Concerts(event_name, eventDate, eventTime,venue, total_seats, available_seats,
			ticket_price, "Coldplay", "Rock");
	break;
case "sports":
	event = new Sport(event_name, eventDate, eventTime, venue,total_seats, available_seats, ticket_price,
			"Football", "India vs Pakistan");
	break;
}

if (event != null) {
	events.add(event);
}
return event;
	}
	 public Bookings book_tickets(String event_name,  ArrayList<Customers> customers,int num_tickets) {
	        for (Event event : events) {
	            if (event.getEvent_name().equalsIgnoreCase(event_name)) {
	                Bookings booking = new Bookings(customers, event, num_tickets);
	                bookings.add(booking);  
	                System.out.println("Booking successful! Booking ID: " + booking.getBooking_id());
	                return booking;
	            }
	        }
	        System.out.println("Event not found.");
	        return null;
	    }

	    // Cancel booking
	 public void cancelBooking(int Booking_id) {
	        Bookings bookingToCancel = null;
	        for (Bookings booking : bookings) {
	            if (booking.getBooking_id() == Booking_id) {
	                bookingToCancel = booking;
	                break;
	          
	        }
	        if (bookingToCancel != null) {
	            bookingToCancel.getEvent().cancel_tickets(bookingToCancel.getNum_tickets());  // Update available seats in the event
	            bookings.remove(bookingToCancel);  // Remove the booking from the list
	            System.out.println("Booking with ID " + Booking_id + " canceled successfully.");
	        } else {
	            System.out.println("Booking with ID " + Booking_id + " not found.");
	        }}
	    }
	    // Display available tickets
	    public void getAvailableNoOfTickets() {
	        for (Event event : events) {
	            System.out.println("Event: " + event.getEvent_name() + " | Available Tickets: " + event.getAvailableSeats());
	        }
	    }

	    // Display event details
	    public void getEventDetails() {
	        for (Event event : events) {
	            event.get_event_details();
	            System.out.println();
	        }
	    }

	    public static void main(String[] args) {
	        BookingSystem3 system = new BookingSystem3();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("1. Create Event");
	            System.out.println("2. Book Tickets");
	            System.out.println("3. Cancel Booking");
	            System.out.println("4. Get Available Seats");
	            System.out.println("5. Get Event Details");
	            System.out.println("6. Exit");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    System.out.println("Enter event name:");
	                    String event_name = scanner.nextLine();
	                    System.out.println("Enter date (yyyy-mm-dd):");
	                    String date = scanner.nextLine();
	                    System.out.println("Enter time (HH:mm):");
	                    String time = scanner.nextLine();
	                    System.out.println("Enter total seats:");
	                    int seats = scanner.nextInt();
	                    System.out.println("Enter available seats:");
	                    int seats1 = scanner.nextInt();
	                    System.out.println("Enter ticket price:");
	                    double price = scanner.nextDouble();
	                    scanner.nextLine(); // Consume newline
	                    System.out.println("Enter event type (movie/concert/sports):");
	                    String type = scanner.nextLine();
	                    System.out.println("Enter venue name:");
	                    String venue_name = scanner.nextLine();
	                    System.out.println("Enter venue address:");
	                    String address = scanner.nextLine();

	                    Venue venue = new Venue(venue_name, address);
	                    system.createEvent(event_name, date, time,venue, seats,seats1, price, type);
	                    break;

	                case 2:
	                    // Booking tickets
	                    System.out.println("Enter event name:");
	                    event_name = scanner.nextLine();
	                    System.out.println("Enter number of tickets:");
	                    int num_tickets = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline
	                    ArrayList<Customers> customers = new ArrayList<>();
	                    for (int i = 0; i < num_tickets; i++) {
	                        System.out.println("Enter customer " + (i + 1) + " name:");
	                        String customer_name = scanner.nextLine();
	                        System.out.println("Enter customer " + (i + 1) + " email:");
	                        String email = scanner.nextLine();
	                        System.out.println("Enter customer " + (i + 1) + " phone number:");
	                        String phonenumber = scanner.nextLine();
	                        customers.add(new Customers(customer_name, email, phonenumber));
	                    }
	                    system.book_tickets(event_name, customers, num_tickets);
	                    break;

	                case 3:
	                    // Cancel booking
	                	System.out.println("Enter booking ID:");
	                    int Booking_id = scanner.nextInt();
	                    system.cancelBooking(Booking_id);
	                    break;

	                case 4:
	                  
	                    system.getAvailableNoOfTickets();
	                    break;

	                case 5:
	                    // Display event details
	                    system.getEventDetails();
	                    break;

	                case 6:
	                    // Exit
	                    System.out.println("Exiting...");
	                    scanner.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice.");
	            }
	        }
	    }
	}
