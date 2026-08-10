package Week_2.Day_5;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = s1;
        Student s3 = new Student("Aman", 102216093);
        Student s4 = new Student("Aman", 102216093);
        Student s5 = s4;

        s2.displayDetails();
        s3.displayDetails();
        s4.displayDetails();

        s2.setName("Jasleen kaur");
        s2.updateMarks(98);
        s2.setRollNumber(102216087);

        s1.displayDetails();

        System.out.println("is s1==s2 ? " + (s1 == s2));
        System.out.println("is s3 == s4 ? " + (s3 == s4));
        System.out.println("is s3.equals(s4) ?" + s3.equals(s4));

        System.out.println("is s4 == s5? " + (s4 == s5));
        System.out.println("is s3 == s5? " + (s3 == s5));

    }
}
