//Create a program to calculate the sum of even numbers from 1 to 10 using a while loop.

public class SumEvenNumbers {
    public static void main(String[] args) {
        int sum = 0, i = 2;
        while (i <= 10) {
            sum += i;
            i += 2;
        }
        System.out.println("Sum of even numbers (1 to 10): " + sum);
    }
}
