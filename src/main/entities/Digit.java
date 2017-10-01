package main.entities;

import java.util.HashMap;

public class Digit {

    private HashMap<Integer, char[]> digitSegments = new HashMap<Integer, char[]>(10);

    {
        digitSegments.put(0, new char[]{'A', 'B', 'C', 'D', 'E', 'F'});
        digitSegments.put(1, new char[]{'B', 'C'});
        digitSegments.put(2, new char[]{'A', 'B', 'D', 'E', 'G'});
        digitSegments.put(3, new char[]{'A', 'B', 'C', 'D', 'G'});
        digitSegments.put(4, new char[]{'B', 'C', 'F', 'G'});
        digitSegments.put(5, new char[]{'A', 'C', 'D', 'F', 'G'});
        digitSegments.put(6, new char[]{'A', 'C', 'D', 'E', 'F', 'G'});
        digitSegments.put(7, new char[]{'A', 'B', 'C'});
        digitSegments.put(8, new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'});
        digitSegments.put(9, new char[]{'A', 'B', 'C', 'F', 'G'});
    }

    private int segmentLength;
    private int height;
    private int width;
    private char[] segments;
    private char[][] digitMatrix;

    public Digit(int digitNumber, int segmentLength) {
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
