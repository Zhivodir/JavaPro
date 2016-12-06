package les1.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by User on 05.12.2016.
 */
public class Deserializer{
    private String pathToLoad;
    private String content = "";
    private ClassLoaderForDeserialization classLoader;
    private Object obj;
    private int currentDelimiter;

    public Deserializer(String pathToLoad) {
        this.pathToLoad = pathToLoad;
        ClassLoaderForDeserialization classLoader = new ClassLoaderForDeserialization();
        try(BufferedReader reader = new BufferedReader(new FileReader(pathToLoad))){
            content = reader.readLine();
            currentDelimiter = content.indexOf(':');
            String part = content.substring(0, currentDelimiter);
            obj = classLoader.loadClass(part).newInstance();
        } catch(IOException e){ e.printStackTrace(); }
        catch (ClassNotFoundException e){e.printStackTrace();}
        catch (IllegalAccessException e){e.printStackTrace();}
        catch (InstantiationException e){e.printStackTrace();}
    }

    public <T> T deserialize(int currentPlace, Object obj){
        //T res = (T) cls.newInstance();
        int delimiter = content.indexOf(':');
        String name = content.substring(0, delimiter);
        Field[] fields = obj.getClass().getDeclaredFields();
        for(int i = 0; i < fields.length; i++){

        }
        return null;
    }

    public Object startDeserialization(){
       return deserialize(currentDelimiter, obj);
    }
}
