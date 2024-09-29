

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<Train> trains;
    private List<Ticket> tickets;

    public BookingSystem() {
        trains = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    public void addTrain(Train train) {
        trains.add(train);
    }

    public List<Train> getAvailableTrains() {
        return trains;
    }

    public Ticket bookTicket(int trainNumber, Passenger passenger) {
        for (Train train : trains) {
            if (train.getTrainNumber() == trainNumber && train.getAvailableSeats() > 0) {
                train.bookSeat();
                Ticket ticket = new Ticket(train, passenger, train.getAvailableSeats());
                tickets.add(ticket);
                return ticket;
            }
        }
        System.out.println("Booking failed. Train not found or no available seats.");
        return null;
    }

    public void cancelTicket(int ticketNumber) {
        Ticket ticketToCancel = null;
        for (Ticket ticket : tickets) {
            if (ticket.getTicketNumber() == ticketNumber) {
                ticket.getTrain().cancelSeat();
                ticketToCancel = ticket;
                break;
            }
        }
        if (ticketToCancel != null) {
            tickets.remove(ticketToCancel);
            System.out.println("Ticket cancelled successfully.");
        } else {
            System.out.println("Ticket not found.");
        }
    }

    public List<Ticket> getBookedTickets() {
        return tickets;
    }
}
