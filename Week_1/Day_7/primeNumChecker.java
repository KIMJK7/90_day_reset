package Week_1.Day_7;

import java.util.Scanner;

// If a number has a factor greater than its square root, it must also have a corresponding factor 
// smaller than its square root. 
// Therefore, if no divisor is found up to √n, no larger divisor can exist without a smaller matching one, 
// so the number is prime.
// time complexity = O(root(n))
public class primeNumChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter any number to chack if its prime num:");
        int num = sc.nextInt();

        if (num < 2) {
            System.out.println("num is not prime");
            sc.close();
            return;
        }

        double max = Math.sqrt(num);
        // or double max = Math.pow(num, 0.5);
        int n = (int) max;
        boolean isprime = true;
        for (int i = 2; i <= n; i++) {

            if ((num % i) == 0) {
                System.out.println("num is not prime");
                isprime = false;
                break;
            }

        }
        if (isprime) {
            System.out.println("num is prime");
        }

        sc.close();
    }
}
