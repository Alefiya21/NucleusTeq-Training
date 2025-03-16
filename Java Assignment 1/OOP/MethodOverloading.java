//Demonstrate polymorphism by creating methods with the same name but different parameters in a parent and child class.

class MathOperations {

    public int multiply(int a, int b) {
        return a * b;
    }

    public int multiply(int a, int b, int c) {
        return a * b * c;
    }
}

public class MethodOverloading {
    public static void main(String[] args) {
        MathOperations math = new MathOperations();

        int result1 = math.multiply(5, 10);
        System.out.println("Multiplication of two numbers: " + result1);

        int result2 = math.multiply(4, 6, 2);
        System.out.println("Multiplication of three numbers: " + result2);
    }
}
