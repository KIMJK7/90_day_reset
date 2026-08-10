package Week_2.Day_6;

import java.util.Scanner;

public class Main {

    public static void displayMenu() {
        System.out.println(
                "1. Add Student\n2. Delete Stduent\n3.Search Student info using Roll NO\n4.Display all students info\n5. Find highest marks\n6.calculate Average amrks\n7.exist");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager SM = new StudentManager();
        Student[] Stu = new Student[10];
        boolean exit = false;
        do {
            displayMenu();
            System.out.println("Choose your option: ");
            int option = sc.nextInt();
            switch (option) {
                case (1):
                    SM.addStudent(Stu, sc);
                    break;
                case (2):
                    SM.deleteStudent(Stu, sc);
                    break;
                case (3):
                    SM.searchRollNo(Stu, sc);
                    break;
                case (4):
                    SM.diaplyStudentInfo(Stu);
                    break;
                case (5):
                    SM.highestMarks(Stu);
                    break;
                case (6):
                    SM.avgMarks(Stu);
                    break;
                case (7):
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Request");
                    break;

            }
        } while (!exit);

        sc.close();
    }
}
