import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {


            String welcomeMessage = "Please input a string of comma-separated commands to move the robot: ";

            System.out.println(welcomeMessage);

            // Create a scanner to read the command-line input
            Scanner scanner = new Scanner(System.in);

            String userInput = scanner.nextLine();

            System.out.println("User input is " + userInput);





    }
}