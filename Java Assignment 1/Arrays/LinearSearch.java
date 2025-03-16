//Create a program to search for a specific element within an array using linear search.

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to search: ");
        int key = sc.nextInt();

        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at index: " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Element not found");
        }
        sc.close();
    }
}
