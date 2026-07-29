package Week_1.Day_4;

import java.util.Scanner;

public class StudentResultMethods {
    public static String inputStudent(Scanner sc) {

        System.out.println("Student must enter their name:");
        String name = sc.nextLine();

        return name;
    }

    public static int calculateTotal(Scanner sc) {

        System.out.println("Enter marks for 5 subjects: ");

        System.out.println("English:");
        int eng = sc.nextInt();

        System.out.println("Science:");
        int sci = sc.nextInt();

        System.out.println("SSt:");
        int sst = sc.nextInt();

        System.out.println("Maths:");
        int maths = sc.nextInt();

        System.out.println("GK:");
        int gk = sc.nextInt();
        int total = eng + sci + sst + maths + gk;

        return total;
    }

    public static float calculatePercentage(int total) {
        float percentatge = ((total / 500.0f) * 100.0f);
        return percentatge;
    }

    public static char assignGrade(float percen) {
        if (percen >= 90) {
            return 'A';
        } else if (percen >= 80) {
            return 'B';
        } else if (percen >= 60) {
            return 'c';
        } else if (percen >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void displayResult(String name, int total, float percen, char grade) {
        System.out.println("\n----- Result -----");
        System.out.println("Name       : " + name);
        System.out.println("Total   : " + total);
        System.out.println("Percentage      : " + percen);
        System.out.println("Grade   : " + grade);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = inputStudent(sc);
        int total_marks = calculateTotal(sc);
        float percentage = calculatePercentage(total_marks);
        char grade = assignGrade(percentage);
        displayResult(name, total_marks, percentage, grade);
        sc.close();
    }
}
