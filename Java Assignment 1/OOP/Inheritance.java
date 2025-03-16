//Implement inheritance to create a "GraduateStudent" class that extends the "Student" class with additional features.
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

class GraduateStudent extends Student {
    private String projectTopic;

    public GraduateStudent(String name, String rollNumber, int marks, String projectTopic) {
        super(name, rollNumber, marks);
        this.projectTopic = projectTopic;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Project Topic: " + projectTopic);
    }
}
public class Inheritance {
    public static void main(String[] args) {
        GraduateStudent graduateStudent = new GraduateStudent("Alefiya", "1001", 90, "Machine Learning");
        graduateStudent.displayInfo();
    }
}