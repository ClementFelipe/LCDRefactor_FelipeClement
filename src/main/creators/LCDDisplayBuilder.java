package main.creators;

import main.model.DisplayDigit;
import main.model.LCDDisplay;

public class LCDDisplayBuilder {

    private LCDDisplay lcdDisplay;

    private int builtDigits = 0;

    public void createLCDDisplay(String number, int segmentLength) {

        lcdDisplay = new LCDDisplay();

        int numberOfDigits = number.length();
        int matrixHeight = segmentLength * 2 + 3;
        int matrixWidth = (segmentLength + 2) * numberOfDigits;

        char[][] screenMatrix = new char[matrixHeight][matrixWidth];
        lcdDisplay.setScreenMatrix(screenMatrix);

    }

    public void buildDigit(DisplayDigit displayDigit) {

        char[][] screenMatrix = lcdDisplay.getScreenMatrix();

        int digitSegmentLength = displayDigit.getSegmentLength();
        int startingColumn = (digitSegmentLength + 2) * builtDigits;

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
