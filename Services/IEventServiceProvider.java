
package Services;

import Beans.Event;
import Beans.Venue;

public interface IEventServiceProvider {
    Event createEvent(int eventID,String eventName, String date, String time, int totalSeats, double ticketPrice, String eventType, Venue venue);
    Event[] getEventDetails();
    int getAvailableNoOfTickets(String eventName);
}

