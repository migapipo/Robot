# Robot CLI Application


## Introductions
A robot can receive commands and move forwards or backwards, and turn left or right. This is a CLI application can receive a string of commands and will output the robot's distance from it's 
starting point. 


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


 Users can select a choice to interact with this application. This design makes this application extensible and
 increases the flexibility of this application. This design provides an easy way to upgrade or increase more
 functions of this application without changing the core part.
 
 For now, there are 2 options for users to choose:
 
 1. Create a new robot to start the game
 
 2. Exit the application