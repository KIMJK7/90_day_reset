package Week_1.Day_7;

import java.util.Scanner;

public class linearSarch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter values into array of size " + n);
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Num to find:");
        int num = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] == num) {
                System.out.println(num + " found at index " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(num + " not found  ");
        }

        sc.close();
    }

}
