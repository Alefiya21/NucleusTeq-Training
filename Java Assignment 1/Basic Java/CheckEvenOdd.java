//Create a program to check if a number is even or odd.

import java.util.Scanner;
public class CheckEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println(num % 2 == 0 ? "Even" : "Odd");
        sc.close();
    } 
}