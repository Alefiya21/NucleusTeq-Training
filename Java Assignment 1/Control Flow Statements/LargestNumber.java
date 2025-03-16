//Implement a program to find the largest number among three given numbers using a conditional 

import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

        int largest = (a > b) ? (a > c ? a : c) : (b > c ? b : c);
        System.out.println("Largest Number: " + largest);
        sc.close();
    }

}
