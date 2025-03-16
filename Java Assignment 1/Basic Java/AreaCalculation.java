//Write a program to calculate the area of a circle, rectangle, or triangle based on user input.

import java.util.Scanner;
public class AreaCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose shape: Circle, Rectangle, Triangle");
        String shape = sc.next().toLowerCase();
        
        switch (shape) {
            case "circle":
                System.out.print("Enter radius: ");
                double radius = sc.nextDouble();
                System.out.println("Area: " + (Math.PI * radius * radius));
                break;
            case "rectangle":
                System.out.print("Enter length and width: ");
                double length = sc.nextDouble(), width = sc.nextDouble();
                System.out.println("Area: " + (length * width));
                break;
            case "triangle":
                System.out.print("Enter base and height: ");
                double base = sc.nextDouble(), height = sc.nextDouble();
                System.out.println("Area: " + (0.5 * base * height));
                break;
            default:
                System.out.println("Invalid shape.");
        }
        
        sc.close();
    }
}
