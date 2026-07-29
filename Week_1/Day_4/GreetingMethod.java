package Week_1.Day_4;

import java.util.Scanner;

public class GreetingMethod {

    public static void greet(String name) {
        System.out.println("Welcome," + " " + name + " !");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Name:");
        String name = sc.nextLine();
        greet(name);

        sc.close();

    }
}
