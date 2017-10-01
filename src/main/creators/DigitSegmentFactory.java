package main.creators;

import main.model.DigitSegment;
import main.model.SegmentPoint;

public class DigitSegmentFactory {

    public static DigitSegment createSegment(int length, char segmentType) {

        DigitSegment digitSegment = new DigitSegment();

        SegmentPoint segmentPoint0 = new SegmentPoint();
        SegmentPoint segmentPoint1 = new SegmentPoint();

        int orientation = -1;

        switch (segmentType) {

            case DigitSegment.A:

                orientation = DigitSegment.HORIZONTAL;

                segmentPoint0.setI(0);
                segmentPoint1.setI(0);

                segmentPoint0.setJ(1);
                segmentPoint1.setJ(length);

                break;
            case DigitSegment.B:

                orientation = DigitSegment.VERTICAL;

                segmentPoint0.setJ(length + 1);
                segmentPoint1.setJ(length + 1);

                segmentPoint0.setI(1);
                segmentPoint1.setI(length);

                break;
            case DigitSegment.C:

                orientation = DigitSegment.VERTICAL;

                segmentPoint0.setJ(length + 1);
                segmentPoint1.setJ(length + 1);

                segmentPoint0.setI(length + 2);
                segmentPoint1.setI(2 * length + 1);


                break;
            case DigitSegment.D:

                orientation = DigitSegment.HORIZONTAL;

                segmentPoint0.setI(2 * (length + 1));
                segmentPoint1.setI(2 * (length + 1));

                segmentPoint0.setJ(1);
                segmentPoint1.setJ(length);

                break;
            case DigitSegment.E:

                orientation = DigitSegment.VERTICAL;

                segmentPoint0.setJ(0);
                segmentPoint1.setJ(0);

                segmentPoint0.setI(length + 2);
                segmentPoint1.setI(2 * length + 1);

                break;
            case DigitSegment.F:

                orientation = DigitSegment.VERTICAL;

                segmentPoint0.setJ(0);
                segmentPoint1.setJ(0);

                segmentPoint0.setI(1);
                segmentPoint1.setI(length);

                break;
            case DigitSegment.G:

                orientation = DigitSegment.HORIZONTAL;

                segmentPoint0.setI(length + 1);
                segmentPoint1.setI(length + 1);

                segmentPoint0.setJ(1);
                segmentPoint1.setJ(length);

                break;

            default:
                break;

        }

        digitSegment.setOrientation(orientation);

        digitSegment.setSegmentPoint0(segmentPoint0);
        digitSegment.setSegmentPoint1(segmentPoint1);

        return digitSegment;

    }


}
