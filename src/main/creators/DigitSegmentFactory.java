package main.creators;

import main.model.DigitSegment;
import main.model.SegmentPoint;

/**
 * Simple factory for the DigitSegment class, which (depending on length and segment type) instantiates a segment
 */
public class DigitSegmentFactory {

    /**
     * Simple factory method for the creation of DigitSegment objects. Depending on the type of segment
     * it parameterizes the head and tail points for the segment vector.
     *
     * @param length      length of the segment to create
     * @param segmentType Indicates one of the 7 segment types in a standard 7 segment LCD display
     * @return DigitSegment object
     */
    public static DigitSegment createSegment(int length, char segmentType) {

        DigitSegment digitSegment = new DigitSegment();

        SegmentPoint segmentPoint0 = new SegmentPoint();
        SegmentPoint segmentPoint1 = new SegmentPoint();

        int orientation = -1;

        switch (segmentType) {

            /*                    A
             * Vector: (p0.i,p0.j)--->(p1.i,p1.j)
             */
            case DigitSegment.A:

                orientation = DigitSegment.HORIZONTAL;

                segmentPoint0.setI(0);
                segmentPoint1.setI(0);

                segmentPoint0.setJ(1);
                segmentPoint1.setJ(length);

                break;

            /**
             * Vector: (p0.i,p0.j)
             *              |
             *              |B
             *              |
             *             \/
             *         (p1.i,p1.j)
             */
            case DigitSegment.B:

                orientation = DigitSegment.VERTICAL;

                segmentPoint0.setJ(length + 1);
                segmentPoint1.setJ(length + 1);

                segmentPoint0.setI(1);
                segmentPoint1.setI(length);

                break;

            /**
             * Vector: (p0.i,p0.j)
             *              |
             *              |C
             *              |
             *             \/
             *         (p1.i,p1.j)
             */
            case DigitSegment.C:

                orientation = DigitSegment.VERTICAL;

                segmentPoint0.setJ(length + 1);
                segmentPoint1.setJ(length + 1);

                segmentPoint0.setI(length + 2);
                segmentPoint1.setI(2 * length + 1);


                break;

            /**                    D
             * Vector: (p0.i,p0.j)--->(p1.i,p1.j)
             */
            case DigitSegment.D:

                orientation = DigitSegment.HORIZONTAL;

                segmentPoint0.setI(2 * (length + 1));
                segmentPoint1.setI(2 * (length + 1));

                segmentPoint0.setJ(1);
                segmentPoint1.setJ(length);

                break;

            /**
             * Vector: (p0.i,p0.j)
             *              |
             *             E|
             *              |
             *             \/
             *         (p1.i,p1.j)
             */
            case DigitSegment.E:

                orientation = DigitSegment.VERTICAL;

                segmentPoint0.setJ(0);
                segmentPoint1.setJ(0);

                segmentPoint0.setI(length + 2);
                segmentPoint1.setI(2 * length + 1);

                break;

            /**
             * Vector: (p0.i,p0.j)
             *              |
             *             F|
             *              |
             *             \/
             *         (p1.i,p1.j)
             */
            case DigitSegment.F:

                orientation = DigitSegment.VERTICAL;

                segmentPoint0.setJ(0);
                segmentPoint1.setJ(0);

                segmentPoint0.setI(1);
                segmentPoint1.setI(length);

                break;

            /**                    G
             * Vector: (p0.i,p0.j)--->(p1.i,p1.j)
             */
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
