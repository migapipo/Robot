
public class Robot {

    int coordinateX;
    int coordinateY;

    int facingDirection;

    public Robot(int coordinateX, int coordinateY, int facingDirection) {

        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.facingDirection = facingDirection;

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

}
