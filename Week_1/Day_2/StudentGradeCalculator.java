package Week_1.Day_2;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter students name:\n");
        String name = sc.next();
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

        int total = (eng + sci + sst + maths + gk);
        float avg = total / 5;
        float percentatge = ((total / 500.0f) * 100);
        System.out.println("Student name:" + " " + name + "\n" + "Total marks:" + " " + total + "\n" + "Total Avg:"
                + " " + avg + "\n" + "Percentage:" + " " + percentatge);

        sc.close();
    }

}
