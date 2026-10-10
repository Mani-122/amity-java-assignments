import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Guest {
    private String name;
    private int age;
    private String idProof;

    public Guest(String name, int age, String idProof) {
        this.name = name;
        this.age = age;
        this.idProof = idProof;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getIdProof() {
        return idProof;
    }

    @Override
    public String toString() {
        return name + "," + age + "," + idProof;
    }
}

class Reservation {
    private String reservationId;
    private String roomType;
    private List<Guest> guests;

    public Reservation(String reservationId, String roomType) {
        this.reservationId = reservationId;
        this.roomType = roomType;
        this.guests = new ArrayList<>();
    }

    public void addGuest(Guest g) {
        guests.add(g);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reservation ID: ").append(reservationId).append(" Room: ").append(roomType).append("\n");
        sb.append("Guests:\n");
        for (Guest g : guests) {
            sb.append(g.toString()).append("\n");
        }
        return sb.toString().trim();
    }
}

public class Exercise13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] resParts = sc.nextLine().split(",");
        String resId = resParts[0].trim();
        String roomType = resParts[1].trim();
        int guestCount = Integer.parseInt(resParts[2].trim());

        Reservation reservation = new Reservation(resId, roomType);
        for (int i = 0; i < guestCount; i++) {
            String[] guestParts = sc.nextLine().split(",");
            String name = guestParts[0].trim();
            int age = Integer.parseInt(guestParts[1].trim());
            String idProof = guestParts[2].trim();
            reservation.addGuest(new Guest(name, age, idProof));
        }

        System.out.println(reservation);
    }
}
