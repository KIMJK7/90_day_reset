package Week_2.Day_6;

import java.util.Scanner;

public class StudentManager {

    int count = 0;

    public void addStudent(Student[] stu, Scanner sc) {
        if (count == 10) {
            System.out.println("No new entries can be made!");
            return;
        }
        String name;
        int RollNo = 0;
        int marks = 0;
        boolean set = true;
        System.out.println("Enter name: ");
        name = sc.nextLine();

        while (set) {
            System.out.println("Enter RollNo: ");
            RollNo = sc.nextInt();
            boolean duplicate = false;
            for (int i = 0; i < count; i++) {
                if (RollNo == stu[i].getRollNumber()) {
                    System.out.println("Roll NO. already exist! enter again");
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                set = false;
            }
        }

        System.out.println("Enter Marks: ");
        marks = sc.nextInt();
        sc.nextLine();

        stu[count] = new Student(name, RollNo, marks);
        count++;

    }

    public void deleteStudent(Student[] stu, Scanner sc) {
        if (count == 0) {
            System.out.println("No student available, invalid request");
            return;
        }

        int index = searchRollNo(stu, sc);
        if (index == -1) {
            System.out.println("student doesnot exist");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            stu[i] = stu[i + 1];
        }
        stu[count - 1] = null;
        count--;
        System.out.println("Student Successfully Deleted");
    }

    public int searchRollNo(Student[] stu, Scanner sc) {
        if (count == 0) {
            System.out.println("No student available, invalid request");
            return -1;
        }
        System.out.println("Enter the roll No of Student:");
        int RollNo = sc.nextInt();
        boolean found = false;
        int index = 0;
        for (int i = 0; i < count; i++) {

            if (stu[i].getRollNumber() == RollNo) {
                found = true;
                index = i;
                break;
            }
        }
        if (found == false) {
            return -1;
        }
        return index;
    }

    public void diaplyStudentInfo(Student[] stu) {
        if (count == 0) {
            System.out.println("No student available, invalid request");
            return;
        }
        for (int i = 0; i < count; i++) {
            String name = stu[i].getName();
            int RollNo = stu[i].getRollNumber();
            int Marks = stu[i].getMarks();
            System.out.println("Student " + i + "\nname: " + name + "\nRoll Number: " + RollNo + "\nMarks: " + Marks);
        }
    }

    public void highestMarks(Student[] stu) {
        if (count == 0) {
            System.out.println("No student available, invalid request");
            return;
        }
        int index = 0;
        int max = stu[0].getMarks();
        for (int i = 1; i < count; i++) {
            if (max < stu[i].getMarks()) {
                max = stu[i].getMarks();
                index = i;
            }
        }
        System.out.println("Highest Scorer is: ");
        stu[index].displayDetails();
    }

    public void avgMarks(Student[] stu) {
        if (count == 0) {
            System.out.println("No student available, invalid request");
            return;
        }
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += stu[i].getMarks();
        }

        System.out.println("Avgrage Marks are : " + ((double) total / count));
    }

}
