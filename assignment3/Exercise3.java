import java.util.Scanner;

class ArrayDivision {
    private int[] arr;

    public ArrayDivision(int[] arr) {
        this.arr = arr;
    }

    public void divide(int index, int divisor) {
        try {
            int value = arr[index];
            int result = value / divisor;
            System.out.println("Result: " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception: Array index out of bounds");
        } catch (ArithmeticException e) {
            System.out.println("Division by zero not allowed");
        }
    }
}

public class Exercise3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {10, 20, 30, 40};

        System.out.println("Array: [10, 20, 30, 40]");

        System.out.print("Enter index: ");
        int index = sc.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();

        ArrayDivision ad = new ArrayDivision(arr);
        ad.divide(index, divisor);
    }
}
