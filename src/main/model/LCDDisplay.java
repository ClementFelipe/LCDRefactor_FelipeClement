package main.model;


/**
 * This class represents the LCDDisplay as a matrix of characters. This matrix will be of height = (segment length) * 2 + 3
 * and width of (segment length + 3) * (number of digits) - 1. Width is determined this way because each digit must have a column
 * of spaces to its right, but the las column is removed, as it is the last digits, which is unnecessary.
 *
 * An LCDDisplay consists (conceptually) as a concatenation of digit matrices
 */
public class LCDDisplay {

    private char[][] screenMatrix;

    public char[][] getScreenMatrix() {
        return screenMatrix;
    }

    public void setScreenMatrix(char[][] screenMatrix) {
        this.screenMatrix = screenMatrix;
    }

}
