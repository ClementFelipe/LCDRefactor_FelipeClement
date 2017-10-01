package main.creators;

import main.model.DisplayDigit;
import main.model.LCDDisplay;

/**
 * Builder pattern class for the LDCDisplay object, creates the LCDDisplay (initializing it's matrix) and builds (fills)
 * digits onto the LCDDisplay matrix from DisplayDigit tokens
 */
public class LCDDisplayBuilder {

    //Constant that defines number of empty columns between digits in the LCDDisplay
    private static final int SPACE_BETWEEN = 1;

    //LCDDisplay object to be built
    private LCDDisplay lcdDisplay;

    //Variable that keeps track of the current number of digits built into the display
    private int builtDigits = 0;

    /**
     * Instantiates the LCDDisplay instance and creates it's corresponding matrix
     *
     * @param number        Positive number to be represented on the LCD display
     * @param segmentLength Length of every segment of the display
     */
    public void createLCDDisplay(String number, int segmentLength) {

        lcdDisplay = new LCDDisplay();
        createLCDDisplayMatrix(number, segmentLength);

    }

    /**
     * Creates the empty (filled with spaces) matrix for the LCDDisplay. Width is defined as
     * (segmentLength + 2 + SPACE_BETWEEN) * numberOfDigits - SPACE_BETWEEN, this is beacause every digit must account
     * for segmentLength + 2 + (number of columns (to the right) between digits), and the number of columns to the right
     * of the last digit is subtracted
     *
     * @param number        Positive number to be represented on the LCD display
     * @param segmentLength Length of every segment of the display
     */
    private void createLCDDisplayMatrix(String number, int segmentLength) {

        int numberOfDigits = number.length();
        int matrixHeight = segmentLength * 2 + 3;
        int matrixWidth = (segmentLength + 2 + SPACE_BETWEEN) * numberOfDigits - SPACE_BETWEEN;

        char[][] screenMatrix = new char[matrixHeight][matrixWidth];
        for (int i = 0; i < screenMatrix.length; i++) {

            for (int j = 0; j < screenMatrix[0].length; j++) {
                screenMatrix[i][j] = DisplayDigitBuilder.SPACE_CHARACTER;
            }

        }
        lcdDisplay.setScreenMatrix(screenMatrix);

    }

    /**
     * Builds (fills) the LCDDisplay matrix from DisplayDigit tokens
     * @param displayDigit The digit to fill into the LCDDisplay
     */
    public void buildDigit(DisplayDigit displayDigit) {

        char[][] screenMatrix = lcdDisplay.getScreenMatrix();

        int digitSegmentLength = displayDigit.getSegmentLength();
        int startingColumn = (digitSegmentLength + 2 + SPACE_BETWEEN) * builtDigits;

        int digitHeight = displayDigit.getHeight();
        int digitWidth = displayDigit.getWidth();

        for (int i = 0; i < digitHeight; i++) {

            for (int j = startingColumn; j < digitWidth + startingColumn; j++) {

                screenMatrix[i][j] = displayDigit.getDigitMatrix()[i][j - startingColumn];

            }

        }

        lcdDisplay.setScreenMatrix(screenMatrix);
        builtDigits++;

    }

    public LCDDisplay getLcdDisplay() {
        return lcdDisplay;
    }
}
