package tbs;

import java.time.LocalDate;
import java.time.LocalTime;

public class Sports extends Events {
	private String sportName;
	private String teamsName;

	public Sports() {
	}

	public Sports(String event_name, LocalDate date, LocalTime time, String venue_name, int total_seats,
			 int available_seats,double ticket_price, String sportName, String teamsName) {
		super(event_name, date, time, venue_name, total_seats, available_seats, ticket_price, "sports");
		this.sportName = sportName;
		this.teamsName = teamsName;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public String getTeamsName() {
		return teamsName;
	}

	public void setTeamsName(String teamsName) {
		this.teamsName = teamsName;
	}

	@Override
	public void display_event_details() {
		super.display_event_details();
		System.out.println("Sport: " + sportName);
		System.out.println("Teams: " + teamsName);
	}

}
