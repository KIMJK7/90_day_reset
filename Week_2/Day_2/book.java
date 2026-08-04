package Week_2.Day_2;

public class book {
    String title;
    String authour;

    book(String title, String authour) {
        this.title = title;
        this.authour = authour;
    }

    void display() {
        System.out.println("Title : " + title + " Authuor: " + authour);
    }
}