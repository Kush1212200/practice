package Beans;

import java.time.LocalDate;
import java.time.LocalTime;

public class Movie extends Event {
	 private String movieGenre;
	    private String actorName;
	    private String actressName;

	    public Movie(int eventID,String eventName, LocalDate eventDate, LocalTime eventTime, Venue venue, int totalSeats, double ticketPrice, String eventType, String movieGenre, String actorName, String actressName) {
	        super(eventID,eventName, eventDate, eventTime, venue, totalSeats, ticketPrice, eventType);
	        this.movieGenre = movieGenre;
	        this.actorName = actorName;
	        this.actressName = actressName;
	    }

	    public String getMovieGenre() {
	        return movieGenre;
	    }

	    public void setMovieGenre(String movieGenre) {
	        this.movieGenre = movieGenre;
	    }

	    public String getActorName() {
	        return actorName;
	    }

	    public void setActorName(String actorName) {
	        this.actorName = actorName;
	    }

	    public String getActressName() {
	        return actressName;
	    }

	    public void setActressName(String actressName) {
	        this.actressName = actressName;
	    }

	    public void displayEventDetails() {
	        System.out.println("Movie Name: " + getEventName() +
	                ", Date: " + getEventDate() +
	                ", Time: " + getEventTime() +
	                ", Venue: " + getVenue().getVenueName() +
	                ", Genre: " + getMovieGenre() +
	                ", Actor Name: " + getActorName() +
	                ", Actress Name: " + getActressName() +
	                ", Ticket price: " + getTicketPrice() +
	                ", Available seats: " + getAvailableSeats());
	    }

}
