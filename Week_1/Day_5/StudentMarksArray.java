package Week_1.Day_5;

import java.util.Scanner;

public class StudentMarksArray {

    public static int[] inputData(Scanner sc) {
        System.out.println("Enter number of students:");
        int stu = sc.nextInt();

        int[] marks = new int[stu];

        for (int i = 0; i < stu; i++) {

            System.out.println("Enter marks for Student " + (i + 1));
            marks[i] = sc.nextInt();

            while (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Enter marks between 0 and 100:");
                marks[i] = sc.nextInt();
            }
        }

        return marks;
    }

    public static void display(int[] marks) {
        System.out.println("Marks entered : ");
        for (int elements : marks) {
            System.out.print(elements + "\t");
        }
    }

    public static void HighestLowestMarks(int[] marks) {
        int stu = marks.length;
        int max = marks[0];
        for (int i = 1; i < stu; i++) {
            if (max < marks[i]) {
                max = marks[i];
            }
        }
        System.out.println("Highest marks are " + max);

        int min = marks[0];
        for (int i = 1; i < stu; i++) {
            if (min > marks[i]) {
                min = marks[i];
            }
        }
        System.out.println("Lowest marks are " + min);
    }

    public static void AverageMarks(int[] marks) {
        int stu = marks.length;

        int total = 0;
        for (int i = 0; i < stu; i++) {
            total += marks[i];
        }
        double avg = (double) total / stu;
        System.out.println("Avg marks are " + avg);
    }

    public static void PassFailCount(int[] marks) {
        int stu = marks.length;
        int pass = 40;
        int count = 0;
        for (int items : marks) {
            if (items >= pass) {
                count++;
            }
        }
        System.out.println("Pass count " + count);

        System.out.println("fail count " + (stu - count));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] marks = inputData(sc);

        // print marks for all students:
        display(marks);

        // Highest marks
        // lowest marks
        HighestLowestMarks(marks);

        // Average
        AverageMarks(marks);

        // Pass count pass marks are 40
        PassFailCount(marks);
        sc.close();
    }

}
