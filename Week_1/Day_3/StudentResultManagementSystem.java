package Week_1.Day_3;

import java.util.Scanner;

public class StudentResultManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean stu = true;
        while (stu) {
            System.out.println("Enter Name of Student:");
            String name = sc.next();

            System.out.println("Enter Roll No. of Student:");
            String rollNo = sc.next();

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
            float avg = (float) (total / 5.0f);
            float percentatge = ((total / 500.0f) * 100);
            System.out.println("\n----- Result -----");
            System.out.println("Name       : " + name);
            System.out.println("Roll No    : " + rollNo);
            System.out.println("Total      : " + total);
            System.out.println("Average    : " + avg);
            System.out.println("Percentage : " + percentatge);

            if (percentatge > 90) {
                System.out.println("Grade : A, Pass");
            } else if (percentatge <= 90 && percentatge > 80) {
                System.out.println("Grade : B, Pass");
            } else if (percentatge <= 80 && percentatge > 65) {
                System.out.println("Grade : c, Pass");
            } else if (percentatge <= 65 && percentatge > 40) {
                System.out.println("Grade : D, Pass");
            } else if (percentatge <= 40 && percentatge > 7) {
                System.out.println("Grade : E, Pass");
            } else {
                System.out.println("Fail");
            }

            System.out.println("Next Student?");
            stu = sc.nextBoolean();

        }
        sc.close();
    }
}
