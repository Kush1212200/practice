package tbs;

import java.util.Scanner;
public class bs2 {
	


	    public static void main(String[] args) {
	       
	        Scanner scanner = new Scanner(System.in);

	        final int SILVER_PRICE = 100;
	        final int GOLD_PRICE = 200;
	        final int DIAMOND_PRICE = 300;

	        // Task 3: Looping
	        while (true) {
	        
	            System.out.println("Ticket Categories: ");
	            System.out.println("1. Silver");
	            System.out.println("2. Gold");
	            System.out.println("3. Diamond");

	            
	            System.out.print("Enter the ticket category (Silver/Gold/Diamond) or type 'Exit' to stop: ");
	            String ticketType = scanner.nextLine();

	          
	            if (ticketType.equalsIgnoreCase("Exit")) {
	                System.out.println("Exiting the booking system.");
	                break;
	            }

	           
	            int basePrice = 0;
	            if (ticketType.equalsIgnoreCase("Silver")) {
	                basePrice = SILVER_PRICE;
	            } else if (ticketType.equalsIgnoreCase("Gold")) {
	                basePrice = GOLD_PRICE;
	            } else if (ticketType.equalsIgnoreCase("Diamond")) {
	                basePrice = DIAMOND_PRICE;
	            } else {
	                System.out.println("Invalid ticket category entered. Please try again.");
	                continue; 
	            }

	            int numberOfTickets = 0;

	            while (true) {
	                System.out.print("Enter the number of tickets to book: ");
	           
	                    numberOfTickets = scanner.nextInt();
	                    scanner.nextLine(); 
	                    if (numberOfTickets <= 0) {
	                        System.out.println("Number of tickets should be greater than 0. Try again.");
	                        continue;
	                    }
	                    break; 
	                }  
	                
	            

	            
	            int totalCost = basePrice * numberOfTickets;
	            System.out.println("Booking successful!");
	            System.out.println("Total tickets booked: " + numberOfTickets + " in category: " + ticketType);
	            System.out.println("Total cost: Rs." + totalCost);
	        }

	        scanner.close();
	    }
	}


