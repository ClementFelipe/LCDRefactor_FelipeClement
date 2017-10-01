package main.model;

/**
 * This class represents the a pair of coordinates within 0 indexed matrix, where i indicates row and j indicates column
 */
public class SegmentPoint {

    //Indicates the row within the matrix
    private int i;

    //Indicates the column within the matrix
    private int j;


    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}