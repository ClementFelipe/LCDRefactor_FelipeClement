package main.entities;

public class Segment {

    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    private Point point0;
    private Point point1;
    private int orientation;

    public Point getPoint0() {
        return point0;
    }

    public void setPoint0(Point point0) {
        this.point0 = point0;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }
}
