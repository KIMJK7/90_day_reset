package Week_1.Day_4;

import java.util.Scanner;

public class FactorialMethod {
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any Number:");
        int num = sc.nextInt();
        int fac = factorial(num);
        System.out.print(fac);
        sc.close();
    }
}
