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
        // Write user input validation here
        ArrayList<String> givenCommandList = parseGivenCommandStringIntoList(userInput);
        Robot robot = new Robot(0, 0, 0, 0);

        moveRobotByCommand(robot, givenCommandList);

        System.out.printf("Current coordinate is (%s,%s) \n", robot.getCoordinateX(), robot.getCoordinateY());
        System.out.printf("Robot current facing direction is %s \n", robot.getFacingDirection());
        System.out.printf("Distance from start point %d  \n", robot.getDistanceFromStartPoint());

//          System.out.println(givenCommandList.get(0).charAt(0));
//          System.out.println(givenCommandList.get(0).charAt(1));
//          System.out.println(givenCommandList.get(1).charAt(0));
//          System.out.println(givenCommandList.get(1).charAt(1));

    }


    /**
     * Parse the given command from the string into the ArrayList in order to get the specific command for each step
     * from given command
     *
     * @param givenCommandString the string of given command
     * @return the ArrayList of the given command
     */

    public static ArrayList<String> parseGivenCommandStringIntoList(String givenCommandString) {
        ArrayList<String> commandList = new ArrayList<>();
        for (String string : givenCommandString.split(",")) {
            String singleCommandName = string;
            commandList.add(singleCommandName);
        }
        return commandList;
    }


    public static void moveRobotByCommand(Robot robot, ArrayList<String> givenCommandList) {
        int coordinateX = robot.getCoordinateX();
        int coordinateY = robot.getCoordinateY();
        int currentFacingDirection = robot.getFacingDirection();
        String commandType;
        String command;

        for (int i = 0; i < givenCommandList.size(); i++) {

            command = givenCommandList.get(i);

            commandType = command.substring(0, 1);

            System.out.println("COMMAND TYPE is " + commandType);

            int numberOfMovement = Integer.valueOf(command.substring(1));

            System.out.println("NUMBER OF MOVEMENTS is " + numberOfMovement);

            switch (commandType) {
                case "R":
                    currentFacingDirection = (currentFacingDirection + numberOfMovement) % 4;
                    break;
                case "L":
                    currentFacingDirection = (4 + currentFacingDirection - numberOfMovement) % 4;
                    break;
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
            // Absolute calculation to handle negative coordinates
            robot.setDistanceFromStartPoint(Math.abs(coordinateX - 0) + Math.abs(coordinateY - 0));

            System.out.printf("1. Your Robot is now at (%s,%s) \n", robot.getCoordinateX(), robot.getCoordinateY());

            System.out.printf("1. Your Robot is currently facing direction number %s \n", robot.getFacingDirection());


            System.out.printf("1. Your Robot is currently facing direction is %s \n", facingDirection(robot.getFacingDirection()));

            System.out.printf("1. Distance from start point %d  \n", robot.getDistanceFromStartPoint());



        }



    }


    public static String facingDirection (int currentFacingDirection){
        String direction = "";
        switch (currentFacingDirection){
            case 0:
                direction = "North";
                break;
            case 1:
                direction = "East";
                break;
            case 2:
                direction = "South";
                break;
            case 3:
                direction = "West";
                break;
        }
        return direction;
    }

}