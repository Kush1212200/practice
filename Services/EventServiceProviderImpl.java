package Services;

import Beans.*;

import java.util.*;
import java.time.*;
public class EventServiceProviderImpl implements IEventServiceProvider{
    protected List<Event> eventList = new ArrayList<>();


    @Override
    public Event createEvent(int eventID,String eventName, String date, String time, int totalSeats, double ticketPrice, String eventType, Venue venue) {
        Event event = null;
        Scanner sc = new Scanner(System.in);
        LocalDate eventDate = LocalDate.parse(date);
        LocalTime eventTime = LocalTime.parse(time);
        switch (eventType) {
            case "Movie":
                System.out.print("Enter the Genre: ");
                String movieGenre = sc.nextLine();
                System.out.print("Actor name: ");
                String actorName = sc.nextLine();
                System.out.print("Actress Name: ");
                String actressName = sc.nextLine();
                event = new Movie(eventID,eventName, eventDate, eventTime, venue, totalSeats, ticketPrice, eventType, movieGenre, actorName, actressName);
                break;
            case "Concert":
                System.out.print("Artist/Band Name: ");
                String artistName = sc.nextLine();
                System.out.print("Type (Acoustic/Theatrical/Rock): ");
                String type = sc.nextLine();
                event = new Concert(eventID, eventName, eventDate, eventTime, venue, totalSeats, ticketPrice, eventType, artistName,type);
                break;
            case "Sports":
                System.out.print("Sport Name: ");
                String sportsName = sc.nextLine();
                System.out.print("Teams Name: ");
                String teamsName = sc.nextLine();
                event = new Sports(eventID, eventName, eventDate, eventTime, venue, totalSeats, ticketPrice, eventType, sportsName,teamsName);
                break;
        }
        if (event != null) {
            eventList.add(event);
        }
        return event;
    }

    @Override
    public Event[] getEventDetails() {
        return eventList.toArray(new Event[0]);
    }

    @Override
    public int getAvailableNoOfTickets(String eventName) {
        for (Event event : eventList) {
            if (event.getEventName().equalsIgnoreCase(eventName)) {
                return event.getAvailableSeats();
            }
        }
        return 0;
    }
}
