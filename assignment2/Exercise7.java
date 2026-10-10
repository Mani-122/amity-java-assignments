import java.util.Scanner;

class Team {
    protected String name;
    protected int matchesPlayed;
    protected int wins;
    protected int draws;

    public Team(String name, int matchesPlayed, int wins, int draws) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.wins = wins;
        this.draws = draws;
    }

    public int calculatePoints() {
        return 0;
    }
}

class CricketTeam extends Team {
    public CricketTeam(String name, int matchesPlayed, int wins, int draws) {
        super(name, matchesPlayed, wins, draws);
    }

    @Override
    public int calculatePoints() {
        return (wins * 2) + (draws * 1);
    }

    @Override
    public String toString() {
        return "Team: " + name + " (Cricket) Points: " + calculatePoints();
    }
}

class FootballTeam extends Team {
    public FootballTeam(String name, int matchesPlayed, int wins, int draws) {
        super(name, matchesPlayed, wins, draws);
    }

    @Override
    public int calculatePoints() {
        return (wins * 3) + (draws * 1);
    }

    @Override
    public String toString() {
        return "Team: " + name + " (Football) Points: " + calculatePoints();
    }
}

public class Exercise7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            String line = sc.nextLine();
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] parts = line.split(",");
            String sport = parts[0].trim();
            String name = parts[1].trim();
            int played = Integer.parseInt(parts[1 + 1].trim());
            int wins = Integer.parseInt(parts[3].trim());
            int draws = Integer.parseInt(parts[4].trim());

            if (sport.equalsIgnoreCase("Cricket")) {
                CricketTeam ct = new CricketTeam(name, played, wins, draws);
                System.out.println(ct);
            } else {
                FootballTeam ft = new FootballTeam(name, played, wins, draws);
                System.out.println(ft);
            }
        }
    }
}
