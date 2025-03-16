//Explain the difference between primitive and reference data types with examples.

/*
Primitive Data Types: These store actual values and are predefined (e.g., int, char, float, double, boolean).
Reference Data Types: These store memory addresses of objects (e.g., String, Arrays, Classes, Interfaces).
 */

 public class DataTypes {
    public static void main(String[] args) {
        // Primitive Data Types
        int num = 10; 
        double price = 99.99; 
        char letter = 'A'; 

        // Reference Data Types
        String name = "Alefiya";

        System.out.println("Primitive Data Types: " + num + "  " + price + "  " + letter);
        System.out.println("Reference Data Types: " + name + "  " + name.length());
    }
}