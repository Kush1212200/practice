package tbs;

import java.time.*;

public class Movie extends Events {
	private String genre;
	private String ActorName;
	private String ActressName;
	public Movie() {
	}

	public Movie(String event_name, LocalDate date, LocalTime time, String venue_name, int total_seats,
			 int available_seats,double ticket_price, String genre, String ActorName, String ActressName) {
		super(event_name, date, time, venue_name, total_seats, available_seats, ticket_price, "Movie");
	    this.genre = genre;
        this.ActorName = ActorName;
        this.ActressName = ActressName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getActorName() {
		return ActorName;
	}
	public void setActorName(String actorName) {
		ActorName = actorName;
	}
	public String getActressName() {
		return ActressName;
	}
	public void setActressName(String actressName) {
		ActressName = actressName;
	}
	
   @Override
   public void display_event_details() {
	   super.display_event_details();
       System.out.println("Genre: " + genre);
       System.out.println("Actor: " + ActorName);
       System.out.println("Actress: " + ActressName);
   }
}
