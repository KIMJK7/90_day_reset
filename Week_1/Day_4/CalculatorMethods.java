package Week_1.Day_4;

import java.util.Scanner;

public class CalculatorMethods {

    public static void add(int a, int b) {
        System.out.println("Sum of" + a + " + " + b + " = " + (a + b));
    }

    public static void sub(int a, int b) {
        System.out.println("Substraction of" + a + " - " + b + " = " + (a - b));
    }

    public static void multiply(int a, int b) {
        System.out.println("Sum of" + a + " * " + b + " = " + (a * b));
    }

    public static void divide(int a, int b) {
        if (b != 0) {
            System.out.println("Division of" + a + " / " + b + " = " + (a / b));
        } else {
            System.out.println("Cannot divide b =0");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Two numbers:");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        add(num1, num2);
        sub(num1, num2);
        multiply(num1, num2);
        divide(num1, num2);
        sc.close();
    }

}
