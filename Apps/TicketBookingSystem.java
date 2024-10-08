package Apps;

import Beans.*;
import Services.BookingSystemServiceProviderImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TicketBookingSystem {
    public static void main(String[] args) {
        BookingSystemServiceProviderImpl service = new BookingSystemServiceProviderImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command (create event, book tickets, cancel tickets, get event details, get available seats, exit):");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "create event":
                    
                    System.out.println("Enter Event Name: ");
                    String eventName = scanner.nextLine();
                    System.out.println("Enter the date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.println("Enter the time (HH:MM): ");
                    String time = scanner.nextLine();
                    System.out.println("Total Seats: ");
                    int totalSeats = Integer.parseInt(scanner.nextLine());
                    System.out.println("Ticket price: ");
                    double ticketPrice = Double.parseDouble(scanner.nextLine());
                    System.out.println("Event type (Movie/Concert/Sports): ");
                    String eventType = scanner.nextLine();
                    System.out.println("Venue Name: ");
                    String venueName = scanner.nextLine();
                    System.out.println("Venue address: ");
                    String venueAddress = scanner.nextLine();

                    Venue venue = new Venue(0, venueName, venueAddress);  // Venue ID can be generated later
                    Event event = service.createEvent(0, eventName, date, time, totalSeats, ticketPrice, eventType, venue);
                    if (event != null) {
                        System.out.println("Event created successfully!");
                    } else {
                        System.out.println("Failed to create event.");
                    }
                    break;

                case "book tickets":

                    System.out.println("Enter Customer ID: ");
                    int customerId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter Event Name: ");
                    String bookEventName = scanner.nextLine();
                    System.out.println("Enter Number of Tickets: ");
                    int numTickets = Integer.parseInt(scanner.nextLine());
                    Customer customer = new Customer(customerId, "Customer Name", "customer@example.com", "1234567890"); // Example customer

                    Booking booking = service.bookTickets(bookEventName, numTickets, customer);
                    if (booking != null) {
                        System.out.println("Booking successful! Booking ID: " + booking.getBookingId());
                    } else {
                        System.out.println("Booking failed.");
                    }
                    break;

                case "cancel tickets":

                    System.out.println("Enter Booking ID to cancel: ");
                    int bookingId = Integer.parseInt(scanner.nextLine());
                    boolean cancelled = service.cancelBooking(bookingId);
                    if (cancelled) {
                        System.out.println("Booking cancelled successfully.");
                    } else {
                        System.out.println("Failed to cancel booking.");
                    }
                    break;

                case "get event details":

                    Event[] events = service.getEventDetails();
                    for (Event evt : events) {
                        System.out.println("Event: " + evt.getEventName() + ", Date: " + evt.getEventDate() + ", Available Seats: " + evt.getAvailableSeats());
                    }
                    break;

                case "get available seats":

                    System.out.println("Enter Event Name: ");
                    String availableEventName = scanner.nextLine();
                    int availableSeats = service.getAvailableNoOfTickets(availableEventName);
                    System.out.println("Available Seats: " + availableSeats);
                    break;

                case "exit":
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }
}