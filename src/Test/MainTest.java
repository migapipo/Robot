package Test;

import Code.Main;
import Code.Robot;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class MainTest {

    Robot testRobot = new Robot(0, 0, 0, 0);

    // Test the main function of this application
    @Test
    public void mainFunctionTest1() {
        ArrayList<String> testGivenCommandList1 = new ArrayList<> ();
        testGivenCommandList1.add("F1");
        testGivenCommandList1.add("R1");
        testGivenCommandList1.add("B2");
        testGivenCommandList1.add("L1");
        testGivenCommandList1.add("B3");

        Main.moveRobotByCommands(testRobot,testGivenCommandList1);
        assertEquals(4, testRobot.getDistanceFromStartPoint());
    }

    @Test
    public void mainFunctionTest2() {
        ArrayList<String> testGivenCommandList2 = new ArrayList<> ();
        testGivenCommandList2.add("F1");
        testGivenCommandList2.add("R2");
        testGivenCommandList2.add("B2");

        Main.moveRobotByCommands(testRobot,testGivenCommandList2);
        assertEquals(3, testRobot.getDistanceFromStartPoint());
    }

    @Test
    public void mainFunctionTest3() {
        ArrayList<String> testGivenCommandList3 = new ArrayList<> ();
        testGivenCommandList3.add("F1");
        testGivenCommandList3.add("R8");
        testGivenCommandList3.add("B9");

        Main.moveRobotByCommands(testRobot,testGivenCommandList3);
        assertEquals(8, testRobot.getDistanceFromStartPoint());
    }

    @Test
    public void mainFunctionTest4() {
        ArrayList<String> testGivenCommandList4 = new ArrayList<> ();
        testGivenCommandList4.add("F1");
        testGivenCommandList4.add("B9");
        testGivenCommandList4.add("F8");
        testGivenCommandList4.add("R9");

        Main.moveRobotByCommands(testRobot,testGivenCommandList4);
        assertEquals(0, testRobot.getDistanceFromStartPoint());
    }

    @Test
    public void moveRobotByCommandTest1() {
        ArrayList<String> testGivenCommandList1 = new ArrayList<> ();
        testGivenCommandList1.add("F1");
        testGivenCommandList1.add("R1");
        testGivenCommandList1.add("B2");
        testGivenCommandList1.add("L1");
        testGivenCommandList1.add("B3");

        Main.moveRobotByCommands(testRobot,testGivenCommandList1);

        assertEquals( -2,testRobot.getCoordinateX());
        assertEquals( -2,testRobot.getCoordinateY());
        assertEquals( 4, testRobot.getDistanceFromStartPoint());
        assertEquals(0, testRobot.getFacingDirection());
        assertEquals("North", Main.facingDirection(testRobot.getFacingDirection()));
    }

    @Test
      public void moveRobotByCommandTest2() {
        ArrayList<String> testGivenCommandList2 = new ArrayList<> ();
        testGivenCommandList2.add("R2");
        testGivenCommandList2.add("L3");

        Main.moveRobotByCommands(testRobot,testGivenCommandList2);

        assertEquals( 0,testRobot.getCoordinateX());
        assertEquals( 0,testRobot.getCoordinateY());
        assertEquals( 0, testRobot.getDistanceFromStartPoint());
        assertEquals(3, testRobot.getFacingDirection());
        assertEquals("West", Main.facingDirection(testRobot.getFacingDirection()));
    }

    @Test
    public void moveRobotByCommandTest3() {
        ArrayList<String> testGivenCommandList3 = new ArrayList<> ();
        testGivenCommandList3.add("L4");
        testGivenCommandList3.add("R5");
        testGivenCommandList3.add("F1000");

        Main.moveRobotByCommands(testRobot,testGivenCommandList3);

        assertEquals( 1000,testRobot.getCoordinateX());
        assertEquals( 0,testRobot.getCoordinateY());
        assertEquals( 1000, testRobot.getDistanceFromStartPoint());
        assertEquals(1, testRobot.getFacingDirection());
        assertEquals("East", Main.facingDirection(testRobot.getFacingDirection()));
    }

    @Test
    public void moveRobotByCommandTest4() {

        ArrayList<String> testGivenCommandList4 = new ArrayList<> ();
        testGivenCommandList4.add("R14");
        testGivenCommandList4.add("F1");
        testGivenCommandList4.add("L15");

        Main.moveRobotByCommands(testRobot,testGivenCommandList4);

        assertEquals( 0,testRobot.getCoordinateX());
        assertEquals( -1,testRobot.getCoordinateY());
        assertEquals( 1, testRobot.getDistanceFromStartPoint());
        assertEquals(3, testRobot.getFacingDirection());
        assertEquals("West", Main.facingDirection(testRobot.getFacingDirection()));
    }

    @Test
    public void isEachInputCommandValidTest1() {
        ArrayList<String> testGivenCommandList = new ArrayList<> ();
        testGivenCommandList.add("f1skfhel");
        testGivenCommandList.add("R1");
        testGivenCommandList.add("B2");

        boolean testIsEachInputCommandValid = Main.isEachInputCommandValid(testGivenCommandList);
        assertEquals(false, testIsEachInputCommandValid);
    }

    @Test
    public void isEachInputCommandValidTest2() {
        ArrayList<String> testGivenCommandList = new ArrayList<> ();
        testGivenCommandList.add("F1");
        testGivenCommandList.add("B1");
        testGivenCommandList.add("p2");

        boolean testIsEachInputCommandValid = Main.isEachInputCommandValid(testGivenCommandList);
        assertEquals(false, testIsEachInputCommandValid);
    }

    @Test
    public void isEachInputCommandValidTest3() {
        ArrayList<String> testGivenCommandList = new ArrayList<> ();
        testGivenCommandList.add("019");
        testGivenCommandList.add("11");
        testGivenCommandList.add("p2");

        boolean testIsEachInputCommandValid = Main.isEachInputCommandValid(testGivenCommandList);
        assertEquals(false, testIsEachInputCommandValid);
    }

    @Test
    public void isEachInputCommandValidTest4() {
        ArrayList<String> testGivenCommandList = new ArrayList<> ();
        testGivenCommandList.add("(1");
        testGivenCommandList.add("F2");
        testGivenCommandList.add("p2");

        boolean testIsEachInputCommandValid = Main.isEachInputCommandValid(testGivenCommandList);
        assertEquals(false, testIsEachInputCommandValid);
    }



    // Test the facing direction method: each number represents one direction
    @Test
    public void facingDirectionTest1() {
        int testDirection = 0 ;
        assertEquals("North", Main.facingDirection(testDirection));
    }

    @Test
    public void facingDirectionTest2() {
        int testDirection = 1 ;
        assertEquals("East", Main.facingDirection(testDirection));
    }

    @Test
    public void facingDirectionTest3() {
        int testDirection = 2 ;
        assertEquals("South", Main.facingDirection(testDirection));
    }

    @Test
    public void facingDirectionTest4() {
        int testDirection = 3 ;
        assertEquals("West", Main.facingDirection(testDirection));
    }
}