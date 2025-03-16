//Write a program to demonstrate the use of arithmetic, logical, and relational operators.

public class Operators {
    public static void main(String[] args) {
        int a = 15, b = 5;

        // Arithmetic Operators
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));

        // Relational Operators
        System.out.println("Is a greater than b? " + (a > b));
        System.out.println("Is a less than b? " + (a < b));
        System.out.println("Is a greater than or equal to b? " + (a >= b));
        System.out.println("Is a equal to b? " + (a == b));

        // Logical Operators
        boolean x = true, y = false;
        System.out.println("Is x AND y true? " + (x && y));
        System.out.println("Is x OR y true? " + (x || y));
    }
}