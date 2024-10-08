package repository;

import Beans.*;
import java.sql.*;
import java.sql.Date;
import java.time.*;
import java.util.*;

public class BookingSystemRepositoryImpl implements IBookingSystemRepository {
    private Connection connection;

    public BookingSystemRepositoryImpl() {
        try {
            this.connection = DBUtil.getDBConn();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Event createEvent(String eventName, String date, String time, int totalSeats, double ticketPrice, String eventType, Venue venue) {
        Event event = null;
        try {

            String insertVenueSQL = "INSERT INTO venue (venue_name, address) VALUES (?, ?)";
            PreparedStatement venueStmt = connection.prepareStatement(insertVenueSQL, Statement.RETURN_GENERATED_KEYS);
            venueStmt.setString(1, venue.getVenueName());
            venueStmt.setString(2, venue.getAddress());
            venueStmt.executeUpdate();


            ResultSet venueKeys = venueStmt.getGeneratedKeys();
            int venueId = 0;
            if (venueKeys.next()) {
                venueId = venueKeys.getInt(1);
            }


            String timeWithSeconds = time + ":00"; 

            String insertEventSQL = "INSERT INTO event (event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, event_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(insertEventSQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, eventName);
            pstmt.setDate(2, Date.valueOf(date));  
            pstmt.setTime(3, Time.valueOf(timeWithSeconds));  
            pstmt.setInt(4, venueId);  
            pstmt.setInt(5, totalSeats);
            pstmt.setInt(6, totalSeats); 
            pstmt.setDouble(7, ticketPrice);
            pstmt.setString(8, eventType);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                
                event = new Event(-1, eventName, LocalDate.parse(date), LocalTime.parse(time), venue, totalSeats, ticketPrice, eventType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return event;
    }


    @Override
    public List<Event> getEventDetails() {
        List<Event> events = new ArrayList<>();
        try {
            String sql = "SELECT e.event_id, e.event_name, e.event_date, e.event_time, e.total_seats, e.available_seats, e.ticket_price, e.event_type, v.venue_name, v.address FROM event e JOIN venue v ON e.venue_id = v.venue_id";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int eventId = rs.getInt("event_id");
                String eventName = rs.getString("event_name");
                LocalDate eventDate = rs.getDate("event_date").toLocalDate();
                LocalTime eventTime = rs.getTime("event_time").toLocalTime();
                int totalSeats = rs.getInt("total_seats");
                int availableSeats = rs.getInt("available_seats");
                double ticketPrice = rs.getDouble("ticket_price");
                String eventType = rs.getString("event_type");
                String venueName = rs.getString("venue_name");
                String address = rs.getString("address");

                Venue venue = new Venue(0, venueName, address);  
                Event event = new Event(eventId, eventName, eventDate, eventTime, venue, totalSeats, ticketPrice, eventType);
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    @Override
    public int getAvailableNoOfTickets(String eventName) {
        int availableSeats = 0;
        try {
            String sql = "SELECT available_seats FROM event WHERE event_name = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, eventName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                availableSeats = rs.getInt("available_seats");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return availableSeats;
    }

    @Override
    public double calculateBookingCost(int numTickets, double ticketPrice) {
        return numTickets * ticketPrice;
    }

    @Override
    public Booking bookTickets(String eventName, int numTickets, Customer customer) {
        Booking booking = null;
        try {
            String sql = "SELECT event_id, ticket_price, available_seats FROM event WHERE event_name = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, eventName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int eventId = rs.getInt("event_id");
                double ticketPrice = rs.getDouble("ticket_price");
                int availableSeats = rs.getInt("available_seats");

                if (availableSeats >= numTickets) {
                    double totalCost = calculateBookingCost(numTickets, ticketPrice);
                    System.out.println("Total booking cost for " + numTickets + " tickets: " + totalCost);

                   
                    String insertBookingSQL = "INSERT INTO booking (customer_id, event_id, num_tickets, total_cost, booking_date) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement bookingStmt = connection.prepareStatement(insertBookingSQL, Statement.RETURN_GENERATED_KEYS);
                    bookingStmt.setInt(1, customer.getCustomerId());
                    bookingStmt.setInt(2, eventId);
                    bookingStmt.setInt(3, numTickets);
                    bookingStmt.setDouble(4, totalCost);
                    bookingStmt.setDate(5, Date.valueOf(LocalDate.now()));  

                    int rowsAffected = bookingStmt.executeUpdate();
                    if (rowsAffected > 0) {
                        ResultSet bookingKeys = bookingStmt.getGeneratedKeys();
                        int bookingId = 0;
                        if (bookingKeys.next()) {
                            bookingId = bookingKeys.getInt(1);
                        }

                        booking = new Booking(bookingId, customer.getCustomerId(), eventId, numTickets, totalCost, LocalDate.now());

                        String updateEventSQL = "UPDATE event SET available_seats = available_seats - ? WHERE event_id = ?";
                        PreparedStatement updateStmt = connection.prepareStatement(updateEventSQL);
                        updateStmt.setInt(1, numTickets);
                        updateStmt.setInt(2, eventId);
                        updateStmt.executeUpdate(); 

                    }
                } else {
                    System.out.println("Not enough available seats.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booking;
    }


    @Override
    public boolean cancelBooking(int bookingId) {
        boolean cancelled = false;
        try {
            String selectBookingSQL = "SELECT event_id, num_tickets FROM booking WHERE booking_id = ?";
            PreparedStatement selectStmt = connection.prepareStatement(selectBookingSQL);
            selectStmt.setInt(1, bookingId);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                int eventId = rs.getInt("event_id");
                int numTickets = rs.getInt("num_tickets");

                String deleteBookingSQL = "DELETE FROM booking WHERE booking_id = ?";
                PreparedStatement deleteStmt = connection.prepareStatement(deleteBookingSQL);
                deleteStmt.setInt(1, bookingId);
                int rowsAffected = deleteStmt.executeUpdate();

                if (rowsAffected > 0) {

                    String updateEventSQL = "UPDATE event SET available_seats = available_seats + ? WHERE event_id = ?";
                    PreparedStatement updateStmt = connection.prepareStatement(updateEventSQL);
                    updateStmt.setInt(1, numTickets);
                    updateStmt.setInt(2, eventId);
                    updateStmt.executeUpdate();
                    cancelled = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cancelled;
    }

    @Override
    public Booking getBookingDetails(int bookingId) {
        Booking booking = null;
        try {
            String sql = "SELECT b.booking_id, b.customer_id, b.event_id, b.num_tickets, b.total_cost, b.booking_date, e.event_name FROM booking_table b JOIN event_table e ON b.event_id = e.event_id WHERE b.booking_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, bookingId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int customerId = rs.getInt("customer_id");
                int eventId = rs.getInt("event_id");
                int numTickets = rs.getInt("num_tickets");
                double totalCost = rs.getDouble("total_cost");
                LocalDate bookingDate = rs.getDate("booking_date").toLocalDate();
                String eventName = rs.getString("event_name");

                booking = new Booking(bookingId, customerId, eventId, numTickets, totalCost, bookingDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booking;
    }
}

