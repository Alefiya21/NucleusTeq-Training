//Implement a function to count the number of vowels in a string.

import java.util.Scanner;

public class CountVowels {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine().toLowerCase();

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
           if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
               count++;
           }
        }

        System.out.println("Number of vowels: " + count);
        sc.close();
    }
}
