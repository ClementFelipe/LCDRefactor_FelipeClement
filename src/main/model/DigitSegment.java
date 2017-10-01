package main.model;

public class DigitSegment {

    public static final char A = 'A';
    public static final char B = 'B';
    public static final char C = 'C';
    public static final char D = 'D';
    public static final char E = 'E';
    public static final char F = 'F';
    public static final char G = 'G';

    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    private SegmentPoint segmentPoint0;
    private SegmentPoint segmentPoint1;
    private int orientation;

    public SegmentPoint getSegmentPoint0() {
        return segmentPoint0;
    }

    public void setSegmentPoint0(SegmentPoint segmentPoint0) {
        this.segmentPoint0 = segmentPoint0;
    }

    public SegmentPoint getSegmentPoint1() {
        return segmentPoint1;
    }

    public void setSegmentPoint1(SegmentPoint segmentPoint1) {
        this.segmentPoint1 = segmentPoint1;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }
}
