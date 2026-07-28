package Week_1.Day_3;

import java.util.Scanner;

public class PatternPrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num of rows:");
        int rows = sc.nextInt();
        // acending order
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        // inverted pattern
        for (int i = rows; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}
