package les1.task3.examplesOfClasses;

import les1.task3.Save;

/**
 * Created by User on 02.12.2016.
 */
public class Point {
    @Save
    private int x;
    @Save
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
