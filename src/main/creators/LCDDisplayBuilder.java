package main.creators;

import main.model.DisplayDigit;
import main.model.LCDDisplay;

public class LCDDisplayBuilder {

    private static final int SPACE_BETWEEN = 1;

    private LCDDisplay lcdDisplay;

    private int builtDigits = 0;

    public void createLCDDisplay(String number, int segmentLength) {

        lcdDisplay = new LCDDisplay();
        createLCDDisplayMatrix(number, segmentLength);

    }

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
