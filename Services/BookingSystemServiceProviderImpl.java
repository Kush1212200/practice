package Services;
import Beans.*;
import java.util.*;

public class BookingSystemServiceProviderImpl extends EventServiceProviderImpl implements IBookingSystemServiceProvider{
    protected Map<Integer, Booking> bookingMap = new HashMap<>();

    @Override
    public double calculateBookingCost(int numTickets, Event event) {
        return numTickets * event.getTicketPrice();
    }

    @Override
    public Booking bookTickets(String eventName, int numTickets, Customer customer) {
        Event event = null;


        for (Event e : eventList) {
            if (e.getEventName().equalsIgnoreCase(eventName)) {
                event = e;
                break;
            }
        }

        if (event != null && event.getAvailableSeats() >= numTickets) {
            event.setAvailableSeats(event.getAvailableSeats() - numTickets);
            Booking booking = new Booking(Booking.getBookingCounter(),event, customer, numTickets,calculateBookingCost(numTickets, event));
            bookingMap.put(booking.getBookingId(), booking);
            System.out.println("Booking successful! " + "Total cost: " + booking.getTotalCost());
        } else {
            System.out.println("Not enough seats available.");
        }
		return null;
    }

    @Override
    public boolean cancelBooking(int bookingId) {
        Booking booking = bookingMap.get(bookingId);

        if (booking != null) {
            Event event = booking.getEvent();
            int numTicketsToCancel = booking.getNumTickets();

            System.out.println("Enter the number of tickets to cancel (out of " + numTicketsToCancel + "):");
            Scanner scanner = new Scanner(System.in);
            int ticketsToCancel = scanner.nextInt();

            if (ticketsToCancel <= 0 || ticketsToCancel > numTicketsToCancel) {
                System.out.println("Invalid number of tickets to cancel.");
                return false;
            }


            event.setAvailableSeats(event.getAvailableSeats() + ticketsToCancel);


            double refundedAmount = ticketsToCancel * event.getTicketPrice();
            System.out.println("Refunded amount for " + ticketsToCancel + " tickets is: $" + refundedAmount);

            booking.setNumTickets(numTicketsToCancel - ticketsToCancel);
            double newTotalCost = booking.getNumTickets() * event.getTicketPrice();
            booking.setTotalCost(newTotalCost);


            if (booking.getNumTickets() == 0) {
                bookingMap.remove(bookingId);
                System.out.println("All tickets canceled. Booking and customer details removed.");
            } else {

                System.out.println("Booking updated. " + booking.getNumTickets() + " tickets remain.");
            }
        } else {
            System.out.println("Booking not found.");
        }
		return false;
    }

    @Override
    public Booking getBookingDetails(int bookingId) {
        return bookingMap.get(bookingId);
    }
}
