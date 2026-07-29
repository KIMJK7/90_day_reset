package Week_1.Day_4;

import java.util.Scanner;

public class BankingUtility {
    double balance;

    public void deposit(Scanner sc) {
        System.out.print("Enter the Amt to be deposited:");
        double credit = sc.nextDouble();
        balance += credit;
    }

    public void widhraw(Scanner sc) {
        System.out.print("Enter the Amt to be withdrawn:");
        double debit = sc.nextDouble();
        if (balance >= debit) {
            balance -= debit;
        } else {
            System.out.println("Insufficient balance.");
        }

    }

    public void checkBalance() {
        System.out.println("Your current balance is : " + balance);
    }

    public void displayMenu() {
        System.out.println("1. Check your current balance ");
        System.out.println("2. Widhraw cash ");
        System.out.println("3. Deposit cash ");
        System.out.println("4. Exit ");
    }

    public boolean validateAmount(double amt) {
        if (amt >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankingUtility P1 = new BankingUtility();
        int choose;
        do {
            P1.displayMenu();
            System.out.println("Pick you choice:");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    P1.checkBalance();
                    break;
                case 2:
                    P1.widhraw(sc);
                    break;
                case 3:
                    P1.deposit(sc);
                case 4:
                    System.out.println("Thank you for using our bank.");
                    break;
                default:
                    System.out.println("invalid choice");
            }
        } while (choose != 4);

        sc.close();
    }
}
