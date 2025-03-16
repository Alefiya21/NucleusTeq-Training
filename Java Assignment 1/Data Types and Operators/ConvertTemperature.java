// Create a program to convert a temperature from Celsius to Fahrenheit and vice versa.

import java.util.Scanner;
public class ConvertTemperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();
        System.out.print("Convert to (Celcius/Farhenheit): ");
        String type = sc.next().toLowerCase();

        if (type.equals("celcius")) {
            System.out.println("Temperature in Fahrenheit: " + (temp * 9 / 5 + 32));
        } else if (type.equals("farhenheit")) {
            System.out.println("Temperature in Celcius: " + ((temp - 32) * 5 / 9));
        } else {
            System.out.println("Invalid type.");
        }

        sc.close();
    }
}
