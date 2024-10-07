package tbs;

import java.util.Scanner;

public class bs3 {

public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	final int Silver_price = 100;
	final int Gold_price = 200;
	final int Diamond_price = 300;
	int cost = 0 ;
	while(true) {
	 System.out.println("Ticket Categories: ");
        System.out.println("1. Silver");
        System.out.println("2. Gold");
        System.out.println("3. Diamond");
        
     System.out.print("Enter the ticket category (Silver/Gold/Diamond) or Type Exit to stop:");
	 String ticketType = sc.nextLine();
	 
	 if(ticketType.equalsIgnoreCase("Exit")) {
		 System.out.println("Exiting the booking system.");
		 break;
	 }
		 
	 
	
	 System.out.print("Enter the no. of tickets needed: ");
	 int noOfTickets = sc.nextInt();
	  if (noOfTickets <= 0) {
          System.out.println("Number of tickets should be greater than 0. Try again.");
      }  
	 
	 int bp = 0;
	 
	 if(ticketType.equalsIgnoreCase("Silver")) {
		 bp = Silver_price;
	 }else if(ticketType.equalsIgnoreCase("Gold")) {
		 bp = Gold_price;
	 }else  if(ticketType.equalsIgnoreCase("Diamond")) {
		 bp = Diamond_price;}
	 else {
            System.out.println("Invalid ticket category entered.");
            continue; }
	
	 cost = cost + (bp * noOfTickets);
	
	 
	 System.out.println("Booking successful!");
        System.out.println( "Total Tickets booked are "+ noOfTickets + "And the category is " + ticketType);
}
	System.out.println("Total cost is =" + cost);
        sc.close();
}
}
