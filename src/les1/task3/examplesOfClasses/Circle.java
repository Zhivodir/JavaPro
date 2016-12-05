package les1.task3.examplesOfClasses;

import les1.task3.Save;

/**
 * Created by User on 02.12.2016.
 */
public class Circle {
    @Save
    private Point center;
    @Save
    private Point outer;
    @Save
    private Color color;

    public Circle() {
    }

    public Circle(Point center, Point outer, Color color) {
        this.center = center;
        this.outer = outer;
        this.color = color;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Point getOuter() {
        return outer;
    }

    public void setOuter(Point inner) {
        this.outer = outer;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
