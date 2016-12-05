package les1.task3;

import java.io.Serializable;

/**
 * Created by User on 05.12.2016.
 */
public class Deserializer implements Serializable{
    private String pathToLoad;
    String temp = "les1.task3.examplesOfClasses.Circle";

    public Deserializer(String pathToLoad) {
        this.pathToLoad = pathToLoad;
        ClassLoaderForDeserialization classLoader = new ClassLoaderForDeserialization();
        try {
            Class result = classLoader.loadClass(temp);
            Object obj = result.newInstance();

        }catch(ClassNotFoundException e){e.printStackTrace();}
        catch(InstantiationException e){e.printStackTrace();}
        catch(IllegalAccessException e){e.printStackTrace();}
    }
}
