//package Train_Ticket_Booking;
// import Train_Ticket_Booking;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        Scanner scanner = new Scanner(System.in);

        // Adding some trains to the system
        bookingSystem.addTrain(new Train(101, "Express 1", "Covai", "Bangalore", 100));
        bookingSystem.addTrain(new Train(102, "Express 2", "Chennai", "Covai", 50));
        bookingSystem.addTrain(new Train(103, "Express 3", "Madurai", "Trichy", 75));

        while (true) {
            System.out.println("\nTrain Ticket Booking System");
            System.out.println("1. View available trains");
            System.out.println("2. Book ticket");
            System.out.println("3. Cancel ticket");
            System.out.println("4. View booked tickets");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // this is to consume newline

            switch (choice) {
                case 1:
                    System.out.println("Available trains:");
                    for (Train train : bookingSystem.getAvailableTrains()) {
                        System.out.println(train);
                    }
                    break;
                case 2:
                    System.out.print("Enter train number: ");
                    int trainNumber = scanner.nextInt();
                    scanner.nextLine(); //to consume newline

                    System.out.print("Enter passenger name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter passenger age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    System.out.print("Enter passenger gender: ");
                    String gender = scanner.nextLine();

                    Passenger passenger = new Passenger(name, age, gender);
                    Ticket ticket = bookingSystem.bookTicket(trainNumber, passenger);
                    if (ticket != null) {
                        System.out.println("Ticket booked successfully: " + ticket);
                    }
                    break;
                case 3:
                    System.out.print("Enter ticket number: ");
                    int ticketNumber = scanner.nextInt();
                    bookingSystem.cancelTicket(ticketNumber);
                    break;
                case 4:
                    System.out.println("Booked tickets:");
                    for (Ticket t : bookingSystem.getBookedTickets()) {
                        System.out.println(t);
                    }
                    break;
                case 5:
                    System.out.println("Exiting the system. Thank you!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
