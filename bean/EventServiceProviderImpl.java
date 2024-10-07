package bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import service.IEventServiceProvider;

public class EventServiceProviderImpl implements IEventServiceProvider {
	protected ArrayList<Event> events = new ArrayList<>();

	@Override
	public Event create_event(String event_name, String date, String time, Venue venue, int total_seats,
			int available_seats, double ticket_price, String event_type) {
		  LocalDate eventDate = LocalDate.parse(date);
	        LocalTime eventTime = LocalTime.parse(time);
	        Event event = null;
	        switch (event_type.toLowerCase()) {
	        case "movie":
	        	event = new Movie(event_name, eventDate, eventTime, venue, total_seats, available_seats, ticket_price,
	        			"Action", "Tom Cruise", "Scarlett Johansson");
	        	break;
	        case "concert":
	        	event = new Concert(event_name, eventDate, eventTime,venue, total_seats, available_seats,
	        			ticket_price, "Coldplay", "Rock");
	        	break;
	        case "sports":
	        	event = new Sports(event_name, eventDate, eventTime, venue,total_seats, available_seats, ticket_price,
	        			"Football", "India vs Pakistan");
	        	break;
	        }

	        if (event != null) {
	        	events.add(event);
	        }
	        return event;

	}
	@Override
	public Event[] get_event_details() {
		  return events.toArray(new Event[0]);
		
	}

	@Override
	public int getAvailableNoOfTickets(String event_name) {
		  for (Event event : events) {
	            if (event.getEvent_name().equalsIgnoreCase(event_name)) {
	                return event.getAvailableSeats();
	            }
	        }
	        return 0;
	    }

	    }
	
	


