package main.creators;

import main.entities.Segment;
import main.entities.Point;

public class SegmentFactory {

    public static Segment createSegment(int length, char segmentType) {

        Segment segment = new Segment();

        Point point0 = new Point();
        Point point1 = new Point();

        int orientation = -1;

        switch (segmentType) {

            case 'A':

                orientation = Segment.HORIZONTAL;

                point0.setI(0);
                point1.setI(0);

                point0.setJ(1);
                point1.setJ(length);

                break;
            case 'B':

                orientation = Segment.VERTICAL;

                point0.setJ(length + 1);
                point1.setJ(length + 1);

                point0.setI(1);
                point1.setI(length);

                break;
            case 'C':

                orientation = Segment.VERTICAL;

                point0.setJ(length + 1);
                point1.setJ(length + 1);

                point0.setI(length + 2);
                point1.setI(2 * length + 1);


                break;
            case 'D':

                orientation = Segment.HORIZONTAL;

                point0.setI(2 * (length + 1));
                point1.setI(2 * (length + 1));

                point0.setJ(1);
                point1.setJ(length);

                break;
            case 'E':

                orientation = Segment.VERTICAL;

                point0.setJ(0);
                point1.setJ(0);

                point0.setI(length + 2);
                point1.setI(2 * length + 1);

                break;
            case 'F':

                orientation = Segment.VERTICAL;

                point0.setJ(0);
                point1.setJ(0);

                point0.setI(1);
                point1.setI(length);

                break;
            case 'G':

                orientation = Segment.HORIZONTAL;

                point0.setI(length + 1);
                point1.setI(length + 1);

                point0.setJ(1);
                point1.setJ(length);

                break;

            default:
                break;

        }

        segment.setOrientation(orientation);

        segment.setPoint0(point0);
        segment.setPoint1(point1);

        return segment;

    }


}
