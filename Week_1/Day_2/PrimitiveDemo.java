package Week_1.Day_2;

public class PrimitiveDemo {
    public static void main(String[] args) {
        var name = "Jasleen kaur";
        var subject = "project Semester";
        byte age = 20;
        short gap_year = 1;
        int repeat_classes = 7;
        long bigNum = 150000000L;
        char grade = 'A';
        float marks = 8.7f;
        double proper_marks = 8.78;
        boolean Pass = true;

        System.out.println(
                name + subject + gap_year + repeat_classes + bigNum + grade + marks + proper_marks + Pass + age);

        // type casting
        // explicit
        int roundoff_marks = (int) marks;
        // implicit
        int long_age = age;

        System.out.println(roundoff_marks + long_age);

        int a = 65;
        char demo = (char) a;
        System.out.println(demo);
    }
}
