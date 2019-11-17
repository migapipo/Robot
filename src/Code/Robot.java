package Code;

/**
 *
 * Represents a robot class
 *
 * @author Xiaoyu Sun
 *
 */

public class Robot {

    int coordinateX;
    int coordinateY;
    int facingDirection;
    int distanceFromStartPoint;

    /**
     * Constructor of Robot Class. When creating a robot object, each robot has 4 parameters: coordinateX,
     * coordinateY, facingDirection and distanceFromStartPoint.
     *
     * @param coordinateX coordinate X in the coordinate system
     * @param coordinateY coordinate Y in the coordinate system
     * @param facingDirection robot's current facing direction
     * @param distanceFromStartPoint the minimum amount of distance to get back to the starting point (the target
     *                               Output of this application)
     */
    public Robot(int coordinateX, int coordinateY, int facingDirection, int distanceFromStartPoint) {

        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.facingDirection = facingDirection;
        this.distanceFromStartPoint = distanceFromStartPoint;

    }


    /**
     * Get the coordinate X
     * @return the coordinate X
     */
    public int getCoordinateX() {
        return coordinateX;
    }

    /**
     * Set the robot's coordinate X with the parameter coordinateX
     * @param coordinateX
     */
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    /**
     * Get the coordinate Y
     * @return the coordinate Y
     */
    public int getCoordinateY() {
        return coordinateY;
    }

    /**
     * Set the robot's coordinate Y with the parameter coordinateY
     * @param coordinateY
     */
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    /**
     * Returns the current facing direction
     * @return he current facing direction represents as a number from 0 to 3
     *
     */
    public int getFacingDirection() {
        return facingDirection;
    }
    /**
     * Change the facing direction of a robot
     * @param facingDirection
     */
    public void setFacingDirection(int facingDirection) {
        this.facingDirection = facingDirection;
    }

    /**
     * Returns the distance from start point
     * @return the distance from start point as an integer
     */
    public int getDistanceFromStartPoint() {
        return distanceFromStartPoint;
    }

    /**
     * Change the distance from start point
     * @param distanceFromStartPoint
     */
    public void setDistanceFromStartPoint(int distanceFromStartPoint) {
        this.distanceFromStartPoint = distanceFromStartPoint;
    }
}
