import java.util.Scanner;

class Passport {
    private String passportNo;
    private String issueDate;
    private String expiryDate;

    public Passport(String passportNo, String issueDate, String expiryDate) {
        this.passportNo = passportNo;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Passport: " + passportNo + " Issue: " + issueDate + " Expiry: " + expiryDate;
    }
}

class Citizen {
    private String name;
    private String dob;
    private String address;
    private Passport passport;

    public Citizen(String name, String dob, String address, Passport passport) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public Passport getPassport() {
        return passport;
    }

    @Override
    public String toString() {
        return "Citizen: " + name + " DOB: " + dob + " Address: " + address + "\n" + passport.toString();
    }
}

public class Exercise15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] citizenParts = sc.nextLine().split(",");
        String name = citizenParts[0].trim();
        String dob = citizenParts[1].trim();
        String address = citizenParts[2].trim();

        String[] passportParts = sc.nextLine().split(",");
        String passNo = passportParts[0].trim();
        String issue = passportParts[1].trim();
        String expiry = passportParts[2].trim();

        Passport passport = new Passport(passNo, issue, expiry);
        Citizen citizen = new Citizen(name, dob, address, passport);

        System.out.println(citizen);
    }
}
