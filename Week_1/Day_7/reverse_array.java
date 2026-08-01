package Week_1.Day_7;

public class reverse_array {
    public static void main(String[] args) {

        int myarray[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        int n = myarray.length;
        int reversearray[] = new int[n];
        for (int i = 0; i < myarray.length; i++) {
            reversearray[i] = myarray[n - 1];
            n--;
        }
        System.out.println("Original array :");
        for (int i : myarray) {
            System.out.print(i + "\t");
        }

        System.out.println("\nReverse array :");
        for (int i : reversearray) {
            System.out.print(i + "\t");
        }

        int t = myarray.length;
        for (int i = 0; i < t / 2; i++) {
            int temp = myarray[i];
            myarray[i] = myarray[t - 1];
            myarray[t - 1] = temp;
            t--;
        }
        System.out.println("\nOriginal array :");
        for (int i : myarray) {
            System.out.print(i + "\t");
        }

    }
}
