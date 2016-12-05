package les1.task3.examplesOfClasses;

import les1.task3.Save;

/**
 * Created by User on 02.12.2016.
 */
public class Color {
    @Save
    private String name;

    public Color() {
    }

    public Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
