

public class Ticket {
    private static int ticketCounter = 1000;
    private int ticketNumber;
    private Train train;
    private Passenger passenger;
    private int seatNumber;

    public Ticket(Train train, Passenger passenger, int seatNumber) {
        this.ticketNumber = ticketCounter++;
        this.train = train;
        this.passenger = passenger;
        this.seatNumber = seatNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public Train getTrain() {
        return train;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    @Override
    public String toString() {
        return "Ticket [ticketNumber=" + ticketNumber + ", train=" + train + ", passenger=" + passenger
                + ", seatNumber=" + seatNumber + "]";
    }
}
