import java.util.Scanner;

class TicketBooking {
    private int availableSeats;

    public TicketBooking(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public synchronized void bookSeat(String userName, int seats) {
        if (seats <= availableSeats) {
            availableSeats -= seats;
            System.out.println(userName + " booked " + seats + " seat(s) successfully");
        } else {
            System.out.println(userName + " booking failed. Not enough seats");
        }
    }
}

class UserThread extends Thread {
    private TicketBooking bookingSystem;
    private String userName;
    private int seatsToBook;

    public UserThread(TicketBooking bookingSystem, String userName, int seatsToBook) {
        this.bookingSystem = bookingSystem;
        this.userName = userName;
        this.seatsToBook = seatsToBook;
    }

    @Override
    public void run() {
        bookingSystem.bookSeat(userName, seatsToBook);
    }
}

public class Exercise7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Available Seats: ");
        int availableSeats = sc.nextInt();

        System.out.print("User1 wants to book: ");
        int user1Seats = sc.nextInt();

        System.out.print("User2 wants to book: ");
        int user2Seats = sc.nextInt();

        TicketBooking booking = new TicketBooking(availableSeats);

        UserThread user1 = new UserThread(booking, "User1", user1Seats);
        UserThread user2 = new UserThread(booking, "User2", user2Seats);

        try {
            user1.start();
            user1.join();
            user2.start();
            user2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}
