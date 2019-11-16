
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {


            String welcomeMessage = "Please input a string of comma-separated commands to move the robot: ";

            System.out.println(welcomeMessage);

            // Create a scanner to read the command-line input
            Scanner scanner = new Scanner(System.in);

            String userInput = scanner.nextLine();

            System.out.println("User input is " + userInput);

            ArrayList<String> givenCommandList = parseGivenCommand(userInput);

            for (int i =0; i < givenCommandList.size();i++){
                System.out.println(givenCommandList.get(i));
                for (int j=0; j < givenCommandList.get(i).length();j++){
                    System.out.println(givenCommandList.get(i).charAt(j));
                }

            }

//          System.out.println(givenCommandList.get(0).charAt(0));
//          System.out.println(givenCommandList.get(0).charAt(1));
//          System.out.println(givenCommandList.get(1).charAt(0));
//          System.out.println(givenCommandList.get(1).charAt(1));

    }


    /**
     * Parse the given route from the string into the ArrayList in order to implement the calculation functions on the
     * given route
     *
     * @param givenCommandString the string of given route
     * @return the ArrayList of the given route
     */
    public static  ArrayList<String> parseGivenCommand(String givenCommandString) {
        ArrayList<String> commandList = new ArrayList<>();
        for (String string : givenCommandString.split(",")) {
            String singleCommandName = string;
            commandList.add(singleCommandName);
        }
        return commandList;
    }


    public static void moveRoboteByCommand(Robot robot, ArrayList<String> command){



    }

}