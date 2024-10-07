package tbs;
import java.util.Scanner;
public class bookingsystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//Task 1
		 System.out.print("Enter the number of available tickets: ");
	        int availableTickets = sc.nextInt();
	        System.out.print("Enter the number of tickets to book: ");
	        int noOfBookingTickets = sc.nextInt();
	        
	        //Task 2
	        if (availableTickets >= noOfBookingTickets) {
	        	availableTickets -= noOfBookingTickets; 
	        	//Task 3
	            System.out.println("Booking successful! Remaining tickets: " + availableTickets);
	        } else {
	            System.out.println("Booking failed. Tickets unavailable.");
	        }

	        
	        sc.close();
	   
	}

}

