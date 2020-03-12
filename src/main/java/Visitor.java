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
