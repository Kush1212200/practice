package app;

import java.util.Scanner;


import bean.BookingSystemServiceProviderImpl;
import bean.Customers;
import bean.Event;
import bean.Venue;
import exception1.EventNotFoundException;
import exception1.InvalidBookingIdException;

public class TicketBookingSystem {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookingSystemServiceProviderImpl bookingSystem = new BookingSystemServiceProviderImpl();

        while (true) {
            System.out.println("Enter command (create event, book tickets, cancel tickets, get event details, get available seats, exit):");
            String command = scanner.nextLine();
try {

            if (command.equalsIgnoreCase("create event")) {
                System.out.print("Enter Event Name: ");
                String eventName = scanner.nextLine();
                System.out.print("Enter the date (YYY-MM-DD): ");
                String date = scanner.nextLine();
                System.out.print("Enter the time (HH:MM): ");
                String time = scanner.nextLine();
                System.out.print("Total Seats: ");
                int totalSeats = Integer.parseInt(scanner.nextLine());
                System.out.print("Available Seats: ");
                int availableSeats = Integer.parseInt(scanner.nextLine());
                
                System.out.print("Ticket price: ");
                double ticketPrice = Double.parseDouble(scanner.nextLine());
                System.out.print("Event type (Movie/Concert/Sports): ");
                String eventType = scanner.nextLine();
                System.out.print("Venue Name: ");
                String venueName = scanner.nextLine();
                System.out.print("Venue address: ");
                String venueAddress = scanner.nextLine();
                Venue venue = new Venue(venueName, venueAddress);

                bookingSystem.create_event(eventName, date, time,venue, totalSeats,availableSeats, ticketPrice, eventType);
                System.out.println("Event created successfully.");
            } else if (command.equalsIgnoreCase("book tickets")) {
                System.out.print("Enter Event Name: ");
                String eventName = scanner.nextLine();

                
                Event event = null;
                for (Event e : bookingSystem.get_event_details()) {
                    if (e.getEvent_name().equalsIgnoreCase(eventName)) {
                        event = e;
                        break;
                    }
                }

                
                if (event == null) {
                	 throw new EventNotFoundException("No event found with the name: " + eventName);
                }

                

                
                System.out.print("Number of tickets: ");
                int numTickets = Integer.parseInt(scanner.nextLine());

                // Check if enough tickets are available
                if (numTickets > event.getAvailableSeats()) {
                    System.out.println("Not enough seats available.");
                    continue;
                }

                // Collect customer details
                System.out.print("Enter your name: ");
                String customerName = scanner.nextLine();
                System.out.print("Enter your email: ");
                String customerEmail = scanner.nextLine();
                System.out.print("Enter your phone number: ");
                String customerPhone = scanner.nextLine();
                Customers customer = new Customers(customerName, customerEmail, customerPhone);

                
                bookingSystem.book_tickets(eventName, numTickets, customer);
            } else if (command.equalsIgnoreCase("cancel tickets")) {
                System.out.println("Enter Booking ID:");
                int bookingId = Integer.parseInt(scanner.nextLine());
                bookingSystem.cancel_booking(bookingId);
          
            } else if (command.equalsIgnoreCase("get event details")) {
                Event[] events = bookingSystem.get_event_details();

                
                if (events.length == 0) {
                    System.out.println("No events available.");
                } else {
                    for (Event event : events) {
                        event.get_event_details();
                    }
                }
            } else if (command.equalsIgnoreCase("get available seats")) {
                System.out.print("Enter Event Name: ");
                String eventName = scanner.nextLine();

                
                Event event = null;
                for (Event e : bookingSystem.get_event_details()) {
                    if (e.getEvent_name().equalsIgnoreCase(eventName)) {
                        event = e;
                        break;
                    }
                }

               
                if (event == null) {
                    throw new EventNotFoundException("No event found with the name: " + eventName);
                } else {
                    System.out.println("Available seats for " + eventName + ": " + event.getAvailableSeats());
                }
            } else if (command.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Invalid command, please try again.");
            }
        
        }
        
catch (EventNotFoundException | InvalidBookingIdException e) {
    System.out.println("Error: " + ((Throwable) e).getMessage());

} catch (NumberFormatException e) {
    System.out.println("Error: Invalid input. Please enter a valid number.");

} catch (NullPointerException e) {
    System.out.println("Error: A null value was encountered unexpectedly.");

} catch (Exception e) {
    System.out.println("An unexpected error occurred: " + e.getMessage());
}
}


 

        scanner.close();
    }
}