package Week_1.Day_3;

import java.util.Scanner;
import java.util.Random;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int num = rand.nextInt(101);
        while (true) {
            System.out.println("enter any random number between 0 and 100:");
            int guess = sc.nextInt();
            if (guess == num) {
                System.out.println("you guesses correctly");
                break;
            } else if (guess < num) {
                System.out.println("guess again num guesses is less than the actual number");
            } else if (guess > num) {
                System.out.println("guess again num guesses is more than the actual number");
            }
        }

        sc.close();
    }

}
