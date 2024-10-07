package bean;

import java.time.LocalDateTime;
import java.util.ArrayList;

//import bean.Customers;

public class Booking {
 protected static int next_id = 1;
 protected static int Booking_id;
 protected Customers customers;
 protected Event event;
 protected int num_tickets;
 protected double total_cost;
 protected LocalDateTime booking_date;
 
 

public Booking( int Booking_id,Event event,Customers customers, int num_tickets,double total_cost) {
	Booking_id = next_id++;
	this.customers = customers;
	this.event = event;
	this.num_tickets = num_tickets;
	this.total_cost = event.getTicketPrice() * num_tickets;
	this.booking_date = LocalDateTime.now();
}

public static int getBooking_id() {
	return Booking_id;
}

public void setBooking_id(int booking_id) {
	Booking_id = booking_id;
}

public Customers getCustomers() {
	return customers;
}

public void setCustomers(Customers customers) {
	this.customers = customers;
}

public Event getEvent() {
	return event;
}

public void setEvent(Event event) {
	this.event = event;
}

public int getNum_tickets() {
	return num_tickets;
}

public void setNum_tickets(int num_tickets) {
	this.num_tickets = num_tickets;
}

public double getTotal_cost() {
	return total_cost;
}

public void setTotal_cost(double total_cost) {
	this.total_cost = total_cost;
}

public LocalDateTime getBooking_date() {
	return booking_date;
}

public void setBooking_date(LocalDateTime booking_date) {
	this.booking_date = booking_date;
}
public void display_booking_details() {
    System.out.println("Booking ID: " + Booking_id);
    customers.display_customer_details();
    System.out.println("Event: " + event.getEvent_name());
    System.out.println("Number of Tickets: " + num_tickets);
    System.out.println("Total Cost: Rs." + total_cost);
    System.out.println("Booking Date: " + booking_date);
  
    
 
}}
