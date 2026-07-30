package Week_1.Day_5;

import java.util.Scanner;

public class StudentManagementSystem {

    public static void displayMenu(){
        System.out.println("Menu :");
        System.out.println("1. Display Students \n2.Add Students \n3.Search By ROll No \n4.Highest Marks \n5. Average Marks.")
    }

    public static String addStuName(String name, Scanner sc) {
        System.out.println("Enter name of Student:");
        name = sc.nextLine();
        return name;
    }

    public static int addStuRollNo(int Rollno, Scanner sc) {
        System.out.println("Enter RollNo of Student:");
        Rollno = sc.nextInt();
        return Rollno;
    }

    public static int addStuMarks(int marks, Scanner sc) {
        System.out.println("Enter marks Student:");
        marks = sc.nextInt();
        return marks;
    }

    public static void display(String[] names, int[] Rollno, int[] marks) {
        System.out.println("names \t Rollno \t marks ");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + "\t" + Rollno[i] + "\t" + marks[i]);
        }
    }

    public static int searchStuByRollNo(int[] Rollno, Scanner sc) {
        System.out.println("Enter the RollNO to be searched:");
        int searchNum = sc.nextInt();

        int index = -1;

        for (int i = 0; i < Rollno.length; i++) {
            if (Rollno[i] == searchNum) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static int highestMarks(int[] marks) {
        int stu = marks.length;
        int index = 0;
        int max = marks[0];
        for (int i = 1; i < stu; i++) {
            if (max < marks[i]) {
                max = marks[i];
                index = i;
            }
        }
        System.out.println("Highest marks are " + max);

        return index;

    }

    public static void averageMarks(int[] marks) {
        int stu = marks.length;

        int total = 0;
        for (int i = 0; i < stu; i++) {
            total += marks[i];
        }
        double avg = (double) total / stu;
        System.out.println("Avg marks are " + avg);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Requirements:

        // Store for 10 students:

        // Name
        // Roll Number
        // Marks
        String[] name = new String[10];
        int[] rollno = new int[10];
        int[] marks = new int[10];
        // Features:
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter Details Name, roll no and marks for Student" + (i + 1));
            name[i] = addStuName(name[i], sc);
            rollno[i] = addStuRollNo(rollno[i], sc);
            sc.nextLine();
            marks[i] = addStuMarks(marks[i], sc);
            sc.nextLine();
        }
        // Add student

        // Display all students
        display(name, rollno, marks);
        // Search student by roll number
        int index = searchStuByRollNo(rollno, sc);
        if (index != -1) {
            System.out.println("Name: " + name[index]);
            System.out.println("RollNo: " + rollno[index]);
            System.out.println("Marks: " + marks[index]);
        } else {
            System.out.println("Not found");
        }
        // Find highest marks
        int markIndex = highestMarks(marks);
        System.out.println("Name : " + name[markIndex]);
        System.out.println("Rollno : " + rollno[markIndex]);

        // Find average marks
        averageMarks(marks);

        // Use arrays only (no ArrayList yet).

        // Display menu design:
        displayMenu();
        System.out.println("Choose any option:");

        sc.close();
    }
}
