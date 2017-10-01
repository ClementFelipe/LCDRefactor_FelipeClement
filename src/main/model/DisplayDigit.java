package main.model;

import java.util.HashMap;

public class DisplayDigit {

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

    private int segmentLength;
    private int height;
    private int width;
    private char[] segments;
    private char[][] digitMatrix;

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
