package Week_1.Day_1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num 1 to calculate:\n");
        int num1 = sc.nextInt();
        System.out.println("Enter num 2 to calculate:\n");
        int num2 = sc.nextInt();
        System.out.println("Enter + - * / for calculations:\n");
        String sign = sc.next();
        switch (sign) {
            case "+":
                System.out.println(num1 + " " + sign + " " + num2 + "=" + " " + (num1 + num2));
                break;
            case "-":
                System.out.println(num1 + " " + sign + " " + num2 + "=" + " " + (num1 - num2));
                break;
            case "*":
                System.out.println(num1 + " " + sign + " " + num2 + "=" + " " + (num1 * num2));
                break;
            case "/":
                if (num2 != 0) {
                    System.out.println(num1 + " " + sign + " " + num2 + "=" + " " + (num1 / num2));
                } else {
                    System.out.println("cannot be divided with 0");
                }
                break;
            default:
                System.out.println("undefined");
        }
        sc.close();

    }
}
