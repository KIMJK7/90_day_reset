package Week_1.Day_6;

import java.util.Scanner;

public class integrationProjectSMSV2 {

    public static void displayMenu() {
        System.out.println("Menu :");
        System.out.println(
                "1. Display Students \n2.Add Students \n3.Search By ROll No \n4.Highest Marks \n5. Average Marks.\n6.Delete Student Info \n7. Update Marks \n8. Exit");
    }

    public static void addStuInfo(String[] name, int[] rollno, int[] marks, int i, Scanner sc) {

        name[i] = addStuName(sc);
        rollno[i] = addStuRollNo(rollno, sc, i);
        sc.nextLine();
        marks[i] = addStuMarks(sc);
        sc.nextLine();

    }

    public static String addStuName(Scanner sc) {
        System.out.println("Enter name of Student:");
        String name = sc.nextLine();
        return name;
    }

    public static int addStuRollNo(int[] rollno, Scanner sc, int count) {
        System.out.println("Enter RollNo of Student:");
        int Rollno = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (Rollno == rollno[i]) {
                System.out.println("This Rollno already exists");
                System.out.println("Enter Unique RollNo of Student:");
                Rollno = sc.nextInt();
            }
        }
        return Rollno;
    }

    public static int addStuMarks(Scanner sc) {
        System.out.println("Enter marks Student between 0 to 100:");
        int marks = sc.nextInt();
        if (marks >= 0 && marks <= 100) {
            return marks;
        } else {
            System.out.println("Invalid! marks entered");
            return -1;
        }

    }

    public static void display(String[] names, int[] Rollno, int[] marks, int count) {
        System.out.println("names \t Rollno \t marks ");
        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + "\t" + Rollno[i] + "\t" + marks[i]);
        }
    }

    public static void deleteStuInfo(String[] name, int[] Rollno, int[] mark, int count, int index) {

        for (int i = index; i < count - 1; i++) {
            name[i] = name[i + 1];
            Rollno[i] = Rollno[i + 1];
            mark[i] = mark[i + 1];
        }
        name[count - 1] = null;
        Rollno[count - 1] = 0;
        mark[count - 1] = 0;

    }

    public static void updateStuMarks(int[] marks, int index, Scanner sc) {
        System.out.println("What will be the changes Marks between 0 - 100");
        int newMarks = sc.nextInt();
        if (newMarks >= 0 && newMarks <= 100) {
            marks[index] = newMarks;
        } else {
            System.out.println("invalide! Marks should be between 0 and 100");

        }

    }

    public static int searchStuByRollNo(int[] Rollno, Scanner sc, int count) {
        System.out.println("Enter the RollNO to be searched:");
        int searchNum = sc.nextInt();

        int index = -1;

        for (int i = 0; i < count; i++) {
            if (Rollno[i] == searchNum) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static int highestMarks(int[] marks, int count) {
        if (count == 0) {
            System.out.println("Enter Student Info First");
            return 0;
        }
        int index = 0;
        int max = marks[0];
        for (int i = 1; i < count; i++) {
            if (max < marks[i]) {
                max = marks[i];
                index = i;
            }
        }
        System.out.println("Highest marks are " + max);

        return index;

    }

    public static void averageMarks(int[] marks, int count) {

        int total = 0;
        for (int i = 0; i < count; i++) {
            total += marks[i];
        }
        if (count != 0) {
            double avg = (double) total / count;
            System.out.println("Avg marks are " + avg);
        } else {
            System.out.println("Enter Student Info before Choosing this option");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] name = new String[10];
        int[] rollno = new int[10];
        int[] marks = new int[10];

        int count = 0;
        int option;
        boolean running = true;
        do {
            // Display menu design:
            displayMenu();
            System.out.println("Choose any option:");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    display(name, rollno, marks, count);
                    break;
                case 2:
                    if (count < 10) {
                        addStuInfo(name, rollno, marks, count, sc);
                        count++;
                    } else {
                        System.out.println("Student Reaached max capacity");
                    }

                    break;
                case 3:
                    int indexSearch = searchStuByRollNo(rollno, sc, count);
                    if (indexSearch != -1) {
                        System.out.println("Name: " + name[indexSearch]);
                        System.out.println("RollNo: " + rollno[indexSearch]);
                        System.out.println("Marks: " + marks[indexSearch]);
                    } else {
                        System.out.println("Not found");
                    }
                    break;
                case 4:
                    int markIndex = highestMarks(marks, count);
                    System.out.println("Name : " + name[markIndex]);
                    System.out.println("Rollno : " + rollno[markIndex]);
                    break;
                case 5:
                    averageMarks(marks, count);
                    break;
                case 6:

                    System.out.println("Enter the Student Rollno to delete:");
                    int position = searchStuByRollNo(rollno, sc, count);
                    if (position != -1) {
                        deleteStuInfo(name, rollno, marks, count, position);
                        count--;
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;
                case 7:
                    System.out.println("Enter the Student Rollno whose marks needs to be updated:");
                    int index = searchStuByRollNo(rollno, sc, count);
                    if (index != -1) {
                        updateStuMarks(marks, index, sc);

                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 8:
                    System.out.println("Exit");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid");

            }
        } while (running);

        sc.close();
    }
}
