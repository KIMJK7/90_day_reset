package Week_2.Day_6;

public class Student {

    private String name;
    private final int rollNumber;
    private int marks;

    // No-argument constructor
    Student(int rollNumber) {
        this("Unknown", rollNumber);
    }

    // Constructor with name and roll number
    Student(String name, int rollNumber) {
        this(name, rollNumber, 0);
    }

    // Main constructor
    Student(String name, int rollNumber, int marks) {
        setName(name);
        if (rollNumber <= 0) {
            throw new IllegalArgumentException("Invalid roll number.");
        }

        this.rollNumber = rollNumber;
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
    private void setName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("Invalid name.");
            return;
        }

        this.name = name;
    }

    private void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }

        this.marks = marks;
    }
}