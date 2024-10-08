package Beans;

import java.time.LocalDate;

public class Booking {
	   private static int bookingCounter = 1;
	    private int bookingId;
	    private Event event;
	    private Customer customer;
	    private int numTickets;
	    private double totalCost;

	    public Booking(int bookingId, Event event, Customer customer, int numTickets, double totalCost) {
	        this.bookingId = bookingCounter++;
	        this.event = event;
	        this.customer = customer;
	        this.numTickets = numTickets;
	        this.totalCost = totalCost;
	    }

	    public static int getBookingCounter() {
	        return bookingCounter;
	    }

	    public static void setBookingCounter(int bookingCounter) {
	        Booking.bookingCounter = bookingCounter;
	    }

	    public int getBookingId() {
	        return bookingId;
	    }

	    public void setBookingId(int bookingId) {
	        this.bookingId = bookingId;
	    }

	    public Event getEvent() {
	        return event;
	    }

	    public void setEvent(Event event) {
	        this.event = event;
	    }

	    public Customer getCustomer() {
	        return customer;
	    }

	    public void setCustomer(Customer customer) {
	        this.customer = customer;
	    }

	    public int getNumTickets() {
	        return numTickets;
	    }

	    public void setNumTickets(int numTickets) {
	        this.numTickets = numTickets;
	    }

	    public double getTotalCost() {
	        return totalCost;
	    }

	    public void setTotalCost(double totalCost) {
	        this.totalCost = totalCost;
	    }

	    public void displayBookingDetails() {
	        System.out.println("Booking ID: " + bookingId);
	        customer.displayCustomerDetails();
	        event.displayEventDetails();
	        System.out.println("Tickets Booked: " + numTickets);
	        System.out.println("Total Cost: $" + totalCost);
	    }



}
