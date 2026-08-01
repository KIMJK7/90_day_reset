package Week_1.Day_7;

import java.util.Scanner;

public class primeNumChecker {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter any number to chack if its prime num:");
        int num = sc.nextInt();

        if(num < 2 ){
           System.out.println("num is not prime"); 
        }

        double max = (num**0.5);
        int n = (int) max;
        boolean isprime = true;
        for(int i = 2 ;i<n; i++){

            if((num%i) != 0){
                System.out.println("num is not prime"); 
                isprime = false;
                break;
            }

        }
        if(isprime){
            System.out.println("num is prime"); 
        }

        sc.close();
    }
}
