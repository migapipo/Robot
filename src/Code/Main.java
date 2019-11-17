package Code;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * The Code.Main program implements a CLI application to parse commands and display the result.
 * <p>
 * In this application, you can create a robot, and you can give in a string of comma-separated commands to move the
 * robot. These commands will tell the robot to go forwards or backwards, and turn left or right. These commands
 * should be input in a specific format. For example 'L1' means 'turn left by 90 degrees once'. 'B2' would mean go
 * backwards 2 units.
 * <p>
 * After running the application successfully, the application will show the main menu including 2 choices for users to
 * select. Users just need to follow the instructions to input the necessary parameters to reach the output.
 * After implementing a series of commands and the final result returned successfully, the application will return to
 * the main menu for users to choose to continue or exit the application.
 * <p>
 * There are 2 options for users to choose:
 * 1. Create a new robot to start the game
 * 2. Exit the application
 * <p>
 * There is one main functions and one exit function to complete the above functions. The main function includes
 * different methods to complete the function of moving the robot and get the robot's distance from it's starting
 * point.
 *
 * @author Xiaoyu Sun
 * @see Robot
 */


public class Main {

    private static final int ORIGIN_X = 0; // origin x and y initalise doesn't change
    private static final int ORIGIN_Y = 0;

    private static ArrayList<String> AVAILABLE_COMMAND_LIST;

    static {
        ArrayList<String> availableCommandList = new ArrayList<>();
        availableCommandList.add("F");
        availableCommandList.add("B");
        availableCommandList.add("R");
        availableCommandList.add("L");
        AVAILABLE_COMMAND_LIST = availableCommandList;
    }


    public static void main(String[] args) {


        boolean exit = false;
        int userChoice;
        String givenCommandString;


        String welcomeMessage = ("Welcome to the Robot Application! Here is the Main Menu. Please select your " +
                "choice with a number: \n" + "1. Create a new robot to start the game \n" + "2. Exit the " +
                "application\n" + "Make your selection by typing 1 or 2: ");

        // Create a scanner to read the user's input in the terminal
        Scanner scanner = new Scanner(System.in);

        try {

            do {
                System.out.println(welcomeMessage);

                // Create a scanner to read the users' choice in the terminal
                Scanner userChoiceScanner = new Scanner(System.in);
                userChoice = userChoiceScanner.nextInt();

                switch (userChoice) {
                    case 1:
                        /*
                         * Initialise a robot object with starting point as (0, 0), starting direction as N North,
                         * distance from start point as 0
                         */
                        Robot robot = new Robot(ORIGIN_X, ORIGIN_Y, 0, 0);
                        System.out.println("Your robot has been created successfully! Now try to input " +
                                "some commands to make it move! \n");
                        System.out.println("Enter a list of commands including 4 available command types: F, B, L, R," +
                                " followed by the number of times to implement each command (NO negative values)");
                        System.out.println("Available commands:\n" +
                                        "F - move forward 1 unit\n" +
                                        "B - move backward 1 unit\n" +
                                        "R - turn right 90 degrees\n" +
                                        "L - turn left 90 degrees)");
                        System.out.println ("Valid Command Example: F1,R1,B2,L1,B3 \n" +
                                "Invalid Command Example: *1, 11, P1 \n");
                        System.out.println("Please Enter Valid Commands Below: ");

                        givenCommandString = scanner.nextLine();

                        // Parse the given command from String to the ArrayList
                        ArrayList<String> givenCommandList = parseGivenCommandStringIntoList(givenCommandString);

                        /*
                         * Check the validity of the user input by checking each command in the given command list
                         */
                        if (! isEachInputCommandValid(givenCommandList)) {
                            System.out.println("Invalid Entries! Please try again and re-enter another list of " +
                                    "commands! \n");
                            continue;
                        }

                        // Move robot by the given commands
                        moveRobotByCommands(robot, givenCommandList);

                        /* Considering extensibility, the coordinate and facing direction of robot can be obtained
                        easily to extend other functions. */

//                        System.out.printf("Robot's final coordinate is (%s,%s) \n", robot.getCoordinateX(), robot
//                                .getCoordinateY());
//                        System.out.printf("Robot's final facing direction is %s \n", facingDirection(robot
//                                .getFacingDirection()));

                        // Output of this application
                        System.out.printf("The minimum amount of distance to get back to the starting point is %d " +
                                "\n\n", robot.getDistanceFromStartPoint());

                        // Sleep for a short time before re-run the application
                        Thread.sleep(2000);
                        break;

                    case 2:
                        /* If userInput is 2, exit the application and sleep for a short time before re-run the
                        application */
                        exit = true;
                        System.out.println("Exit the application successful!");
                        System.out.println("Thank you! ");
                        Thread.sleep(1000);
                        break;

                    default:
                        // Handle invalid user choice input
                        System.out.println("Invalid user choice!");
                        System.out.println("Please type in a valid choice\n");
                }

            } while (!exit);

        } catch (Exception e) {
            // Handle the exception thrown by the application
            System.out.println(e.toString());
            System.out.println("Please restart the application and try again.");
        }
    }


    /**
     * Parse the given command from a string of comma-separated commands into the ArrayList.
     *
     * @param givenCommandString the string of given command, which include different commands separated by comma
     * @return An ArrayList including all the given commands
     */

    private static ArrayList<String> parseGivenCommandStringIntoList(String givenCommandString) {
        ArrayList<String> givenCommandList = new ArrayList<>();
        for (String singleInputCommand : givenCommandString.split(",")) {
            givenCommandList.add(singleInputCommand);
        }
        return givenCommandList;
    }


    /**
     *
     * Move the robot according to the commands in the given command list, there are 4 main available Command Types:
     * 1. F - move forward 1 unit
     * 2. B - move backward 1 unit
     * 3. R - turn right 90 degrees
     * 4. L - turn left 90 degrees
     * <p>
     * If the command is either "R" - Right or "L" - Left, only change the current facing direction of the robot.
     * If the command is either "F" - Forward or "B" - Backward, change x or y coordinate according to the robot's
     * current facing direction.
     *
     * @param robot            the robot object
     * @param givenCommandList the given command list to make a series of moves
     *
     */
    public static void moveRobotByCommands(Robot robot, ArrayList<String> givenCommandList) {
        int coordinateX = robot.getCoordinateX();
        int coordinateY = robot.getCoordinateY();
        int currentFacingDirection = robot.getFacingDirection();
        String commandType;
        String singleCommand;

        for (int i = 0; i < givenCommandList.size(); i++) {

            singleCommand = givenCommandList.get(i);
            commandType = singleCommand.substring(0, 1);
            int numberOfMovement = Integer.valueOf(singleCommand.substring(1));

            switch (commandType) {
                /*
                If the command is either "R" - Right or "L" - Left, then only change the current facing direction of
                the robot
                */
                case "R":
                    currentFacingDirection = (currentFacingDirection + numberOfMovement) % 4;
                    if(currentFacingDirection < 0 ){
                        currentFacingDirection += 4;
                    }
                    break;
                case "L":
                    currentFacingDirection = (4 + (currentFacingDirection) - (numberOfMovement)) % 4;
                    if(currentFacingDirection < 0 ){
                        currentFacingDirection += 4;
                    }
                    break;
                /*
                If the command is either "F" or "B", change x or y coordinate according to the current facing direction.
                 */
                case "F":
                    if (currentFacingDirection == 0) {
                        coordinateY += numberOfMovement;
                    } else if (currentFacingDirection == 1) {
                        coordinateX += numberOfMovement;
                    } else if (currentFacingDirection == 2) {
                        coordinateY -= numberOfMovement;
                    } else { // currentFacingDirection == 3
                        coordinateX -= numberOfMovement;
                    }
                    break;
                case "B":
                    if (currentFacingDirection == 0) {
                        coordinateY -= numberOfMovement;
                    } else if (currentFacingDirection == 1) {
                        coordinateX -= numberOfMovement;
                    } else if (currentFacingDirection == 2) {
                        coordinateY += numberOfMovement;
                    } else { // currentFacingDirection == 3
                        coordinateX += numberOfMovement;
                    }
                    break;
            }

            robot.setCoordinateX(coordinateX);
            robot.setCoordinateY(coordinateY);

            robot.setFacingDirection(currentFacingDirection);
            // Use absolute calculation to handle negative coordinates
            robot.setDistanceFromStartPoint(Math.abs(coordinateX - ORIGIN_X) + Math.abs(coordinateY - ORIGIN_Y));
        }

    }

    /**
     * Check if each command in the given command list is one of the available commands
     * <p>
     * Available commands: F, B, R, L
     * <p>
     * F - move forward 1 unit
     * B - move backward 1 unit
     * R - turn right 90 degrees
     * L - turn left 90 degrees
     *
     * @param givenCommandList the given command list given by users
     * @return the boolean value to indicate whether each input command is valid
     */
    public static boolean isEachInputCommandValid(ArrayList<String> givenCommandList) {


        for (int i = 0; i < givenCommandList.size(); i++) {

            // Check each of the input command has at least two characters and contains a valid command
            // which is included in the available command list
            if ((givenCommandList.get(i).length() < 2) ||
                    !(AVAILABLE_COMMAND_LIST.contains(Character.toString(givenCommandList.get(i).charAt(0))))) {
                return false;
            }

            for (int j = 1; j < givenCommandList.get(i).length(); j++) {
                if (!Character.isDigit(givenCommandList.get(i).charAt(j))) {
                    return false;
                }
            }

        }
        return true;
    }

    /**
     * Represent each direction with numbers.
     * North - 0 (Initial direction)
     * East  - 1
     * South - 2
     * West  - 3
     *
     * @param currentFacingDirectionNumber the current facing direction number representation
     * @return the current facing direction "North", "East", "South", "West"
     */
    public static String facingDirection(int currentFacingDirectionNumber) {

        String facingDirection = "";

        switch (currentFacingDirectionNumber) {
            case 0:
                facingDirection = "North";
                break;
            case 1 :
                facingDirection = "East";
                break;
            case 2:
                facingDirection = "South";
                break;
            case 3:
                facingDirection = "West";
                break;
            case -1:
                facingDirection = "West";
                break;

        }
        return facingDirection;
    }

}