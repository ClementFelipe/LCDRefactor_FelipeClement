package main.creators;

import main.entities.Digit;
import main.entities.LCDScreen;

public class LCDScreenBuilder {

    private LCDScreen lcdScreen;

    private static int builtDigits = 0;

    public void createLCDScreen(String number, int segmentLength) {

        lcdScreen = new LCDScreen();

        int numberOfDigits = number.length();

        char[][] screenMatrix = new char[segmentLength * 2 + 3][(segmentLength + 2) * numberOfDigits];

        lcdScreen.setScreenMatrix(screenMatrix);

    }

    public void buildDigit(Digit digit) {

        char[][] screenMatix = lcdScreen.getScreenMatrix();

        int segmentLength = digit.getSegmentLength();

        int startingColumn = (segmentLength + 2) * builtDigits;

        int digitHeight = digit.getHeight();
        int digitWidth = digit.getWidth();

        for (int i = 0; i < digitHeight; i++) {

            for (int j = startingColumn; j < digitWidth + startingColumn; j++) {

                screenMatix[i][j] = digit.getDigitMatrix()[i][j - startingColumn];

            }

        }

        lcdScreen.setScreenMatrix(screenMatix);
        builtDigits++;

    }

    public LCDScreen getLcdScreen() {
        return lcdScreen;
    }
}
