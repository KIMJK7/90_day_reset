package Week_1.Day_2;

public class OperatorsDemo {
    public static void main(String[] args) {
        int num1 = 25;
        int num2 = 30;

        int sum = num1 + num2;
        int subtract = num1 - num2;
        int multiply = num1 * num2;
        float did = num1 / num2;
        float reminder = num1 % num2;

        System.out.println("is num1 + num2" + " = " + sum);
        System.out.println("is num1 - num2" + " = " + subtract);
        System.out.println("is num1 * num2" + " = " + multiply);
        System.out.println("is num1 / num2" + " = " + did);
        System.out.println("is num1 % num2" + " = " + reminder);
        System.out.println("is num1 == num2" + " = " + (num1 == num2));
        System.out.println("is num1 != num2" + " = " + (num1 != num2));
        System.out.println("is num1 <= num2" + " = " + (num1 <= num2));
        System.out.println("is num1 >= num2" + " = " + (num1 >= num2));

        System.out.println("num1++" + " = " + (num1++));
        System.out.println("num1--" + " = " + (num1--));
        System.out.println("++num1" + " = " + (++num1));
        System.out.println("--num1" + " = " + (--num1));

        if (num1 != num2 && num1 < num2) {
            System.out.println("(num1 != num2 && num1 < num2)" + " = " + "true");
        } else {
            System.out.println("(num1 != num2 && num1 < num2)" + " = " + "false");
        }

        if (num1 != num2 || num1 > num2) {
            System.out.println("(num1 != num2 || num1 > num2)" + " = " + "true");
        } else {
            System.out.println("(num1 != num2 || num1 > num2)" + " = " + "false");
        }

    }
}
