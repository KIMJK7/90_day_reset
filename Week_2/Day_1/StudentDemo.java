package Week_2.Day_1;

public class StudentDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Alice";
        s.age = 20;
        s.marks = 78;
        System.out.println("Student A");
        System.out.println("Name: " + s.name + " Age: " + s.age + " Marks: " + s.marks);

        Student s2 = new Student();
        s2.name = "Alice";
        s2.age = 20;
        s2.marks = 78;
        System.out.println("Student B");
        System.out.println("Name: " + s2.name + " Age: " + s2.age + " Marks: " + s2.marks);

        System.out.println("is s = s2 ? " + (s == s2));
        System.out.println("s != s2  bacause they are different objects - same values but different memory addresses");

        Student s1 = s;

        System.out.println("is s = s1 ? " + (s == s1));
        System.out.println(
                "s1 == s  bacause both point to the same momory address in heap any changes done to s1 will reflect back on s");
        s1.name = "bob";
        System.out.println("s1.name = \"bob\"; then s.name = ? " + s.name);

        System.out.println(
                "s = null; it will point to null the object in heap will be come orphan (in our case it will not as s1 points to it but if lets assume it does not), eligible for Garbage collector");
    }
}
