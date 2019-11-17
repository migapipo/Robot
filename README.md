## Robot CLI Application

This Robot application is a CLI application, which can be used to parse commands and display the result.

### Introductions
A robot can receive commands and move forwards or backwards, and turn left or right. The robot can receive a 
string of commands and will output the robot's distance from it's starting point. 


### Requirements

* JDK1.8
* IDE
* JUnit4 (for running the unit test) 


### Contents

This zip file contains the source code of this application:

    /README.md - this file
    /Code - main function code to implement the application
    /Test - the unit test using JUnit4 library
    
### Background
               N
               |
               |
       W -------------- E
               |
               |
               S 
                            
   
The move Forward("F") changes either x or y according to following rules.
* a) If current direction is North, then "F" increments y and doesn’t change x.
* b) If current direction is East, then "F" increments x and doesn’t change y.
* c) If current direction is South, then "F" decrements y and doesn’t change x.
* d) If current direction is West, then "F" decrements x and doesn’t change y.

The move Backward("B") changes either x or y according to following rules.
* a) If current direction is North, then "B" decrements y and doesn’t change x.
* b) If current direction is East, then "B" decrements x and doesn’t change y.
* c) If current direction is South, then "B" increments y and doesn’t change x.
* d) If current direction is West, then "B" increments x and doesn’t change y.

The moves Left("L") and Right("R"), do not change x and y coordinates, they only change direction according to 
following rule.
* a) If current direction is North, then "L" changes direction to West and "R" changes to East
* b) If current direction is East, then "L" changes direction to North and "R" changes to South
* c) If current direction is South, then "L" changes direction to East and "R" changes to West
* d) If current direction is West, then "L" changes direction to South and "R" changes to North.


In this project, directions have been represented by numbers from 0 to 3 
There are four directions, each direction represent with a number. 

0 - direction North

1 - direction East

2 - direction South

3 - direction West

### Extensibility 
Users can select a choice to interact with this application. This design makes this application extensible and 
increases the flexibility of this application. This design provides an easy way to upgrade or increase more
functions of this application without changing the core part.
 
For now, there are 2 options for users to choose:
 
1. Create a new robot to start the game
 
2. Exit the application

### Steps to run the application

1. Start running the application.

2. You will see a Welcome message. 

3. Make sure you enter correct User Choice in the Main Menu (either 1 or 2 in this case).

   You can see the main menu as follows including 2 choices:
   
         1. Create a new robot to start the game 
        
         2. Exit the application
        
4. Make your selection by typing 1 or 2. Enter a number of "1" or "2" to continue. 

5. You can select a choice to implement different functions as you need and get relevant result (Extensibility). 
The result of this application will be given in a string format. Also, you can select "2" to exit the application.

6. If you enter number "1"", you need to input necessary parameters for move the robot. Please follow the
instructions given by the application to reach the output.
NOTE: All the inputs should follow the input format, otherwise the application will output a string says: 
            
        "Invalid Entries! Please try again and re-enter another list of commands! "
     
   It indicates that the format of the input is not correct. 
   You need to try again to input a string of comma-separated commands in correct format.

7. After the main function of the application implemented, the application will return to the main menu. You can 
choose to continue or exit the application.


### Input format

In this program, the input should be a string of comma-separated commands

For examole:

    F1,R1,B2,L1,B3


### Output format

For the readability of the result, the output will be shown in a sentence as a string. The number at the end of the
string is the desired result. (as shown in the specification of the project)

For example:
If you implement the string of commands as shown in the example, the result you will get from the application is (you
 will see this string shown in the terminal): 

    "The minimum amount of distance to get back to the starting point is 4"

The number "4" at the end of this string is the expected output.

That is:

    "The minimum amount of distance to get back to the starting point is 4"
    
    => Output: 4


### Classes in this project 

* Robot - the Robot class represents a robot to execute the commands 
* Main - main code to execute the application 




