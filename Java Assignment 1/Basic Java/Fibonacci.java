//Write a program to print the Fibonacci sequence up to a specified number

import java.util.Scanner;
public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter limit: ");
        int n = sc.nextInt();
        int prev = 0, curr = 1;
        System.out.print("Fibonacci: " + prev + " " + curr);
        for (int i = 3; i <= n; i++) {
            int next = prev + curr;
            System.out.print(" " + next);
            prev = curr;
            curr = next;
        }
        sc.close();
    }
}
