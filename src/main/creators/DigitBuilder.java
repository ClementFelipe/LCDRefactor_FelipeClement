package main.creators;

import main.entities.Segment;
import main.entities.Digit;

public class DigitBuilder {

    private static final char HORIZONTAL_CHARACTER = '-';
    private static final char VERTICAL_CHARACTER = '|';
    private static final char SPACE_CHARACTER = ' ';

    private Digit digit;

    public void createDigit(int digitNumber, int segmentLength) {

        digit = new Digit(digitNumber, segmentLength);

        createDigitMatrix();

    }

    private void createDigitMatrix() {

        int segmentLength = digit.getSegmentLength();

        int matrixHeight = segmentLength * 2 + 3;
        int matrixWidth = segmentLength + 2;

        char[][] digitMatrix = new char[matrixHeight][matrixWidth];

        for (int i = 0; i < digitMatrix.length; i++) {

            for (int j = 0; j < digitMatrix[0].length; j++) {

                digitMatrix[i][j] = SPACE_CHARACTER;

            }

        }

        digit.setDigitMatrix(digitMatrix);

    }

    public void buildSegment(char segmentType) {

        int segmentLength = digit.getSegmentLength();

        Segment segment = SegmentFactory.createSegment(segmentLength, segmentType);

        char[][] digitMatrix = digit.getDigitMatrix();

        fillSegment(segment, digitMatrix);

        digit.setDigitMatrix(digitMatrix);

    }

    private void fillSegment(Segment segment, char[][] digitMatrix) {

        if (segment.getOrientation() == Segment.HORIZONTAL) {

            int row = segment.getPoint0().getI();

            int startColumn = segment.getPoint0().getJ();
            int endColumn = segment.getPoint1().getJ();

            for (int i = startColumn; i <= endColumn; i++) {

                digitMatrix[row][i] = HORIZONTAL_CHARACTER;

            }

        } else {

            int column = segment.getPoint0().getJ();

            int startRow = segment.getPoint0().getI();
            int endRow = segment.getPoint1().getI();

            for (int i = startRow; i <= endRow; i++) {

                digitMatrix[i][column] = VERTICAL_CHARACTER;

            }

        }

    }

    public Digit getDigit() {
        return digit;
    }
}
