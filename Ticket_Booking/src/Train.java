

public class Train {
    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private int availableSeats;

    public Train(int trainNumber, String trainName, String source, String destination, int availableSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        } else {
            System.out.println("No available seats.");
        }
    }

    public void cancelSeat() {
        availableSeats++;
    }

    @Override
    public String toString() {
        return "Train [trainNumber=" + trainNumber + ", trainName=" + trainName + ", source=" + source
                + ", destination=" + destination + ", availableSeats=" + availableSeats + "]";
    }
}

