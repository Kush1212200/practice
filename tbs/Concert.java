package tbs;

import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Events {
	private String artist;
	private String type;

	public Concert() {

	}

	public Concert(String event_name, LocalDate date, LocalTime time, String venue_name, int total_seats,
			int available_seats,double ticket_price,  String artist, String type) {
		super(event_name, date, time, venue_name, total_seats, available_seats,ticket_price, "Concert");
		this.artist = artist;
		this.type = type;
	}

	@Override
	public void display_event_details() {
		super.display_event_details();
		System.out.println("Artist: " + artist);
		System.out.println("Concert Type: " + type);
	}

}
