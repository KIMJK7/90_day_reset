package Week_1.Day_4;

import java.util.Scanner;

public class EvenOddChecker {

    public static void evenOdd(int num) {
        if ((num % 2) == 0) {
            System.out.print(num + " is even");
        } else {
            System.out.print(num + " is odd");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any Number:");
        int num = sc.nextInt();
        evenOdd(num);
        sc.close();
    }
}
