import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Visitor {
    private static final Logger logger = LogManager.getLogger(Visitor.class.getName());
    String fullName;
    int age;
    int date;
    int time;
    String comments;
    String assistant;

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

        save(fullName,age,date,time,comments,assistant);
        load(fullName);

    }
    public static String save(String fullName, int age, int date, int time, String comments, String assistant) {
        fullName.replace(" ","_");
        try {
            FileWriter myWriter = new FileWriter("visitor_" + fullName.toLowerCase() + ".txt");
            myWriter.write("Full name: " + fullName);
            myWriter.write("\nage: " + age);
            myWriter.write("\nDate: " + date);
            myWriter.write("\nTime: " + time);
            myWriter.write("\nComments: " + comments);
            myWriter.write("\nAssistant: " + assistant);
            myWriter.close();
            logger.info("Successfully wrote to the file.");
            logger.info(fullName + ".save() # results in visitor_" + fullName + ".txt");
            return "Success";
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(" \"An error occurred.\"");
            return "Not success";
        }
    }

    public static String load(String name) {
        try {
            File myObj = new File("visitor_" + name.toLowerCase() + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                System.out.println(data);
            }
            myReader.close();
            return "read";
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return "couldn't read";
        }
    }
}
