package Week_2.Day_5;

public class Student {

    private String name;
    private int rollNumber;
    private int marks;

    // No-argument constructor
    Student() {
        this("Unknown", 0, 0);
    }

    // Constructor with name
    Student(String name) {
        this(name, 0, 0);
    }

    // Constructor with name and roll number
    Student(String name, int rollNumber) {
        this(name, rollNumber, 0);
    }

    // Main constructor
    Student(String name, int rollNumber, int marks) {
        setName(name);
        setRollNumber(rollNumber);
        setMarks(marks);
    }

    // Display student details
    void displayDetails() {
        System.out.println(
                "Name: " + name +
                        "\nRoll No: " + rollNumber +
                        "\nMarks: " + marks);
    }

    // Update marks
    void updateMarks(int marks) {
        setMarks(marks);
    }

    // Getters
    String getName() {
        return name;
    }

    int getRollNumber() {
        return rollNumber;
    }

    int getMarks() {
        return marks;
    }

    // Setters
    void setName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("Invalid name.");
            return;
        }

        this.name = name;
    }

    void setRollNumber(int rollNumber) {
        if (rollNumber <= 0) {
            System.out.println("Invalid roll number.");
            return;
        }

        this.rollNumber = rollNumber;
    }

    void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }

        this.marks = marks;
    }
}