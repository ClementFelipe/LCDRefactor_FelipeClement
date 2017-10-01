package main.model;

/**
 * This class represents a segment in a digit, as given by the standard 7 segment LCD display, this being:
 *
 *    A
 *    -
 *  F| |B
 *    G
 *    -
 *  E| |C
 *    -
 *    D
 *
 * This segment is represented as a vector, with a head and tail, which are both points inside the digit matrix, the
 * tail coordinates will always be equal to/smaller than the head coordinates respectively
 *
 */
public class DigitSegment {

    //List of character constants to represent segment types
    public static final char A = 'A';
    public static final char B = 'B';
    public static final char C = 'C';
    public static final char D = 'D';
    public static final char E = 'E';
    public static final char F = 'F';
    public static final char G = 'G';

    //Segment orientation constants
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    //Represents the --smaller (coordinate-wise)-- tail of the segment
    private SegmentPoint segmentPoint1;

    //Represents the --bigger (coordinate-wise)-- head of the segment
    private SegmentPoint segmentPoint0;

    //Represnts the orientation of the segment
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
