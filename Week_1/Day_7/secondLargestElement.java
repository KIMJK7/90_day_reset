package Week_1.Day_7;

import java.util.Scanner;

public class secondLargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter values into array of size " + n);
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // two passes one ot find max then seond max
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int secMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > secMax && arr[i] != max) {
                secMax = arr[i];
            }
        }
        if (secMax == Integer.MIN_VALUE) {

            System.out.println("No Second Largest element ");
        } else {
            System.out.println("Second Largest element is " + secMax);
        }

        if (n < 2) {
            System.out.println("No Second Largest element ");
            sc.close();
            return;
        }

        int max2 = arr[0];
        int secondMax = arr[1];
        if (max2 < secondMax) {
            int temp = max2;
            max2 = secondMax;
            secondMax = temp;
        }
        for (int i = 2; i < n; i++) {
            if (arr[i] > max2) {

                secondMax = max2;
                max2 = arr[i];

            } else if (arr[i] > secondMax && arr[i] != max2) {

                secondMax = arr[i];

            }
        }

        sc.close();
    }
}
