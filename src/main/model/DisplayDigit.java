package main.model;

import java.util.HashMap;

/**
 * This class represents a digit of the LCDDisplay as a matrix of characters, digit will be of height = (segment length) * 2 + 3
 * and width (segment length) + 2
 *
 * Conceptually consists of a list of segments
 */
public class DisplayDigit {

    /**
     * Determines the mapping between digits and its corresponding list of segments.
     */
    private static HashMap<Integer, char[]> digitSegments = new HashMap<Integer, char[]>(10);

    {
        digitSegments.put(0, new char[]{DigitSegment.A, DigitSegment.B, DigitSegment.C, DigitSegment.D, DigitSegment.E, DigitSegment.F});
        digitSegments.put(1, new char[]{DigitSegment.B, DigitSegment.C});
        digitSegments.put(2, new char[]{DigitSegment.A, DigitSegment.B, DigitSegment.D, DigitSegment.E, DigitSegment.G});
        digitSegments.put(3, new char[]{DigitSegment.A, DigitSegment.B, DigitSegment.C, DigitSegment.D, DigitSegment.G});
        digitSegments.put(4, new char[]{DigitSegment.B, DigitSegment.C, DigitSegment.F, DigitSegment.G});
        digitSegments.put(5, new char[]{DigitSegment.A, DigitSegment.C, DigitSegment.D, DigitSegment.F, DigitSegment.G});
        digitSegments.put(6, new char[]{DigitSegment.A, DigitSegment.C, DigitSegment.D, DigitSegment.E, DigitSegment.F, DigitSegment.G});
        digitSegments.put(7, new char[]{DigitSegment.A, DigitSegment.B, DigitSegment.C});
        digitSegments.put(8, new char[]{DigitSegment.A, DigitSegment.B, DigitSegment.C, DigitSegment.D, DigitSegment.E, DigitSegment.F, DigitSegment.G});
        digitSegments.put(9, new char[]{DigitSegment.A, DigitSegment.B, DigitSegment.C, DigitSegment.F, DigitSegment.G});
    }

    //Length of every segment in the digit
    private int segmentLength;

    //Height of the digit = segmentLength * 2 + 3
    private int height;

    //Width of the digit = segmentLength + 2
    private int width;

    //Character list of corresponding segments (lit up segments)
    private char[] segments;

    //Character matrix which represents the digit
    private char[][] digitMatrix;

    /**
     * Constructor for DisplayDigit class
     *
     * @param digitNumber   Number in [0,9]; is the digit in integer format
     * @param segmentLength Number in [0,9]; is the length of the digits segments in integer format
     */
    public DisplayDigit(int digitNumber, int segmentLength) {
        this.segmentLength = segmentLength;
        height = 2 * segmentLength + 3;
        width = segmentLength + 2;
        segments = digitSegments.get(digitNumber);
    }


    public int getSegmentLength() {
        return segmentLength;
    }

    public char[] getSegments() {
        return segments;
    }

    public char[][] getDigitMatrix() {
        return digitMatrix;
    }

    public void setDigitMatrix(char[][] digitMatrix) {
        this.digitMatrix = digitMatrix;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
