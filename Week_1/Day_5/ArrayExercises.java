package Week_1.Day_5;

import java.util.Scanner;

public class ArrayExercises {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("user to enter Size of array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("user to enter values into the array of size : " + arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("user to enter values into the array at position : " + (i + 1));
            arr[i] = sc.nextInt();
        }

        // printing of the array
        System.out.println("Array entered by the user is : ");
        for (int items : arr) {
            System.out.print(items + "\t");
        }

        // Common Array Operations

        // Implement:

        // sum
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

        }
        System.out.println("Sum of the entire array is: " + sum);

        // Average
        double avg = sum / (double) arr.length;
        System.out.println("Avg of the entire array is: " + avg);

        // Maximum

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max <= arr[i]) {
                max = arr[i];
            }
        }

        System.out.println("Max of entire array is: " + max);

        // minimum
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min >= arr[i]) {
                min = arr[i];
            }
        }

        System.out.println("Min of entire array is: " + min);

        // Count even numbers

        int counteven = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                counteven++;
            }
        }
        System.out.println("no of even elements in array is : " + counteven);

        // count of odd number
        int countodd = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                countodd++;
            }
        }
        System.out.println("no of odd elements in array is : " + countodd);

        // Reverse Array

        int[] reverseArray = new int[n];
        int j = 0;
        for (int i = (n - 1); i >= 0; i--) {
            reverseArray[j] = arr[i];
            j++;
        }

        System.out.println("Reverse of Array is : ");
        for (int items : reverseArray) {
            System.out.print(items + "\t");
        }

        // Linear Search
        System.out.println("Enter any numer to search: ");
        int searchNum = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (searchNum == arr[i]) {
                System.out.println(searchNum + " fount at index " + i);
                found = true;
            }

        }
        if (!found) {
            System.out.println(searchNum + " not fount ");
        }

        sc.close();
    }
}
