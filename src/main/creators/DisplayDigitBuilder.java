package main.creators;

import main.model.DigitSegment;
import main.model.DisplayDigit;

public class DisplayDigitBuilder {

    private static final char HORIZONTAL_CHARACTER = '-';
    private static final char VERTICAL_CHARACTER = '|';
    public static final char SPACE_CHARACTER = ' ';

    private DisplayDigit displayDigit;

    public void createDigit(int digitNumber, int segmentLength) {

        displayDigit = new DisplayDigit(digitNumber, segmentLength);
        createDisplayDigitMatrix();

    }

    private void createDisplayDigitMatrix() {

        int segmentLength = displayDigit.getSegmentLength();
        int matrixHeight = segmentLength * 2 + 3;
        int matrixWidth = segmentLength + 2;

        char[][] digitMatrix = new char[matrixHeight][matrixWidth];

        for (int i = 0; i < digitMatrix.length; i++) {

            for (int j = 0; j < digitMatrix[0].length; j++) {

                digitMatrix[i][j] = SPACE_CHARACTER;

            }

        }

        displayDigit.setDigitMatrix(digitMatrix);

    }

    public void buildSegment(char segmentType) {

        int segmentLength = displayDigit.getSegmentLength();
        DigitSegment digitSegment = DigitSegmentFactory.createSegment(segmentLength, segmentType);

        char[][] digitMatrix = displayDigit.getDigitMatrix();
        fillSegment(digitSegment, digitMatrix);

        displayDigit.setDigitMatrix(digitMatrix);

    }

    private void fillSegment(DigitSegment digitSegment, char[][] digitMatrix) {

        if (digitSegment.getOrientation() == DigitSegment.HORIZONTAL) {

            int row = digitSegment.getSegmentPoint0().getI();

            int startColumn = digitSegment.getSegmentPoint0().getJ();
            int endColumn = digitSegment.getSegmentPoint1().getJ();

            for (int i = startColumn; i <= endColumn; i++) {

                digitMatrix[row][i] = HORIZONTAL_CHARACTER;

            }

        } else {

            int column = digitSegment.getSegmentPoint0().getJ();

            int startRow = digitSegment.getSegmentPoint0().getI();
            int endRow = digitSegment.getSegmentPoint1().getI();

            for (int i = startRow; i <= endRow; i++) {

                digitMatrix[i][column] = VERTICAL_CHARACTER;

            }

        }

    }

    public DisplayDigit getDisplayDigit() {
        return displayDigit;
    }
}
