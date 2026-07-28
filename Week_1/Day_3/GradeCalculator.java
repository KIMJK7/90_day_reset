package Week_1.Day_3;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Marks:\n");
        int marks = sc.nextInt();
        if (marks > 90) {
            System.out.println("Grade : A");
        } else if (marks <= 90 && marks > 80) {
            System.out.println("Grade : B");
        } else if (marks <= 80 && marks > 70) {
            System.out.println("Grade : c");
        } else if (marks <= 70 && marks > 60) {
            System.out.println("Grade : D");
        } else if (marks <= 60 && marks > 50) {
            System.out.println("Grade : E");
        } else {
            System.out.println("Fail");
        }

        sc.close();
    }
}
