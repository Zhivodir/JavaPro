package les1.task3;

import les1.task3.examplesOfClasses.Circle;
import les1.task3.examplesOfClasses.Color;
import les1.task3.examplesOfClasses.Point;

/**
 * Created by User on 02.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        Point center = new Point(3,1);
        Point outer = new Point(5,1);
        Color color = new Color("yellow");

        Circle circle = new Circle(center, outer, color);
        Serializer serializer = new Serializer("c:/DevKit/res.txt");
        Deserializer deserializer = new Deserializer("c:/DevKit/res.txt");
        serializer.startSerialization(circle);
        deserializer.startDeserialization();
    }
}
