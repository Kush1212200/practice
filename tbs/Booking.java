package tbs;

public class Booking {

	   private Events event;
	   private Customers customer;
	    private int num_tickets;
	    private double total_cost;

	   
	    public Booking(Events event, Customers customer , int num_tickets) {
	        this.event = event;
	        this.customer= customer;
	        this.num_tickets = num_tickets;
	    }

	  
	    public void calculateBookingCost(int num_tickets) {
	        total_cost = event.getTicketPrice() * num_tickets;
	    }

	
	    public void book_tickets(int num_tickets) {
	        event.book_tickets(num_tickets);
	        calculateBookingCost(num_tickets);
	        System.out.println("Total Cost: Rs" + total_cost);
	    }

	    public void cancel_booking(int num_tickets) {
	        event.cancel_booking(num_tickets);
	    }

	    public int getAvailableNoOfTickets() {
	        return event.getAvailableSeats();
	    }

	    public void getEventDetails() {
	        event.display_event_details();
	    }
	}


