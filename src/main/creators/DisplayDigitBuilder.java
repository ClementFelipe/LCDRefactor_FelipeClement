package main.creators;

import main.model.DigitSegment;
import main.model.DisplayDigit;

/**
 * Builder pattern class for DisplayDigit objects, creates the DisplayDigit and builds it's segments based on segment type tokens
 *
 */
public class DisplayDigitBuilder {

    //Constants that define the type of character depending on segment orientation
    private static final char HORIZONTAL_CHARACTER = '-';
    private static final char VERTICAL_CHARACTER = '|';

    //Constant for "empty" character in the LCD display
    public static final char SPACE_CHARACTER = ' ';

    //DisplayDigit object to be built
    private DisplayDigit displayDigit;

    /**
     * Instantiates the DisplayDigit and initializes and fills it's matrix with spaces
     * @param digitNumber Number in [0,9] in integer format; is the digit that will be represented
     * @param segmentLength Number in [0,9] in integer format; is the length of every segment in the digit
     */
    public void createDigit(int digitNumber, int segmentLength) {

        displayDigit = new DisplayDigit(digitNumber, segmentLength);
        createDisplayDigitMatrix();

    }

    /**
     * Initializes the DigitMatrix, where height = (segment length) * 2 + 3 and
     * width = (segment length) * 2
     */
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

    /**
     * From a segment type token, creates the DigitSegment (by calling DigitSegmentFactory) and
     * fills the DisplayDigit matrix with the corresponding segment information
     * @param segmentType Character token that represents the type of segment
     */
    public void buildSegment(char segmentType) {

        int segmentLength = displayDigit.getSegmentLength();
        DigitSegment digitSegment = DigitSegmentFactory.createSegment(segmentLength, segmentType);

        char[][] digitMatrix = displayDigit.getDigitMatrix();
        fillSegment(digitSegment, digitMatrix);

        displayDigit.setDigitMatrix(digitMatrix);

    }

    /**
     * Fills the DisplayDigit matrix with a segment, based on it's orientation and underlying segment vector
     * @param digitSegment
     * @param digitMatrix
     */
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
