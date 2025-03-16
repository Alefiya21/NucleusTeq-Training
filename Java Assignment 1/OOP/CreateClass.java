//Create a class to represent a student with attributes like name, roll number, and marks.

class Student {
    private String name;
    private String rollNumber;
    private int marks;

    public Student(String name, String rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
    }
}

public class CreateClass {
    public static void main(String[] args) {
        Student student = new Student("Alefiya", "1001", 90);
        student.displayInfo();
    }
    
}
