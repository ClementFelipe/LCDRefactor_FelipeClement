package java;

public class Segment {

    private Point point0;
    private Point point1;
    private int segmentLength;
    private char segmentType;

    public Segment(int segmentLength, char segmentType) {
        this.segmentLength = segmentLength;
        this.segmentType = segmentType;
    }

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

    public int getSegmentLength() {
        return segmentLength;
    }

    public void setSegmentLength(int segmentLength) {
        this.segmentLength = segmentLength;
    }

    public char getSegmentType() {
        return segmentType;
    }

    public void setSegmentType(char segmentType) {
        this.segmentType = segmentType;
    }
}
