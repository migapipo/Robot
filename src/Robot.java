
public class Robot {

    int coordinateX;
    int coordinateY;
    int facingDirection;
    int distanceFromStartPoint;

    public Robot(int coordinateX, int coordinateY, int facingDirection, int distanceFromStartPoint) {

        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.facingDirection = facingDirection;
        this.distanceFromStartPoint = distanceFromStartPoint;

    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public int getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(int facingDirection) {
        this.facingDirection = facingDirection;
    }

    public int getDistanceFromStartPoint() {
        return distanceFromStartPoint;
    }

    public void setDistanceFromStartPoint(int distanceFromStartPoint) {
        this.distanceFromStartPoint = distanceFromStartPoint;
    }
}
