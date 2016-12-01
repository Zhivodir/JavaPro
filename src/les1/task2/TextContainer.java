package les1.task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 * Created by User on 01.12.2016.
 */
@SaveTo(path = "c:\\DevKit/file.txt")
public class TextContainer {
    String text = "I believe, I can fly, I believe I can touch the sky";
    @Saver
    public void save() {
        Class<?> cl = this.getClass();
        String path = cl.getAnnotation(SaveTo.class).path();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
            writer.write(text);
        } catch (IOException e){e.printStackTrace();}
    }
}
