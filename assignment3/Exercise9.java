import java.util.Scanner;

class SquareCalculator extends Thread {
    private int number;

    public SquareCalculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Square: " + (number * number));
    }
}

class CubeCalculator extends Thread {
    private int number;

    public CubeCalculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Cube: " + (number * number * number));
    }
}

class RandomNumberGenerator extends Thread {
    private int iterations;

    public RandomNumberGenerator(int iterations) {
        this.iterations = iterations;
    }

    @Override
    public void run() {
        int[] sample = {4, 7, 10};
        for (int i = 0; i < iterations; i++) {
            int num = (i < sample.length) ? sample[i] : (int) (Math.random() * 20 + 1);
            System.out.println("Generated: " + num);

            if (num % 2 == 0) {
                SquareCalculator sq = new SquareCalculator(num);
                sq.start();
                try {
                    sq.join();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            } else {
                CubeCalculator cube = new CubeCalculator(num);
                cube.start();
                try {
                    cube.join();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

public class Exercise9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Start Simulation");
        System.out.println("2. Exit");
        int choice = sc.nextInt();

        if (choice == 1) {
            RandomNumberGenerator rng = new RandomNumberGenerator(3);
            rng.start();
            try {
                rng.join();
            } catch (InterruptedException e) {
                System.out.println("Simulation interrupted");
            }
        } else {
            System.out.println("Exiting simulation.");
        }
    }
}
