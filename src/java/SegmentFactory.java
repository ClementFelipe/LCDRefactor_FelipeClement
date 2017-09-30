package java;

public class SegmentFactory {

    public static Segment createSegment(int length, char segmentType) {

        Segment segment = new Segment(length, segmentType);

        Point point0 = new Point();
        Point point1 = new Point();

        switch (segmentType) {

            case 'A':

                point0.setI(0);
                point0.setJ(0);

                point1.setI(0);
                point1.setJ(length + 1);

                break;
            case 'B':

                point0.setI(0);
                point0.setJ(length + 1);

                point1.setI(length + 1);
                point1.setJ(length + 1);

                break;
            case 'C':

                point0.setI(length + 1);
                point0.setJ(length + 1);

                point1.setI(2 * (length + 1));
                point1.setJ(length + 1);

                break;
            case 'D':

                point0.setI(2 * (length + 1));
                point0.setJ(0);

                point1.setI(2 * (length + 1));
                point1.setJ(length + 1);

                break;
            case 'E':

                point0.setI(length + 1);
                point0.setJ(0);

                point1.setI(2 * (length + 1));
                point1.setJ(0);

                break;
            case 'F':

                point0.setI(0);
                point0.setJ(0);

                point1.setI(length + 1);
                point1.setJ(0);

                break;
            case 'G':

                point0.setI(length + 1);
                point0.setJ(0);

                point1.setI(length + 1);
                point1.setJ(length + 1);

                break;

        }

        segment.setPoint0(point0);
        segment.setPoint1(point1);

        return segment;

    }


}
