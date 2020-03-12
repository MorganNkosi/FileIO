import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);

        System.out.println("Enter full name:");
        String fullName = enter.next();

        System.out.println("age:");
        int age = enter.nextInt();

        System.out.println("Enter date");
        int date = enter.nextInt();

        System.out.println("Enter time");
        int time = enter.nextInt();

        System.out.println("Enter comments");
        String comments = enter.next();

        System.out.println("Enter assistant");
        String assistant = enter.next();

        Visitor.save(fullName,age,date,time,comments,assistant);
        Visitor.load(fullName);
    }
}
