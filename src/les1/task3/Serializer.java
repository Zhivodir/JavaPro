package les1.task3;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 02.12.2016.
 */
public class Serializer {
    private Class<?> currentClass;
    private String pathToFile;
    private List<String> predefinedTypes;

    public Serializer(String pathToSave) {
        this.pathToFile = pathToSave;
        String[] temp = {"Integer", "int", "double", "Double", "float", "Float",
            "long", "Long", "short", "Short", "char", "Character", "boolean", "Boolean",
            "String", "byte", "Byte"};
        predefinedTypes = Arrays.asList(temp);
    }

    public void startSerialization(Object obj){
        StringBuilder sb = new StringBuilder();
        serialize(sb, obj);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile))){
            writer.write(sb.toString());

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void serialize(StringBuilder sb, Object obj){
        currentClass = obj.getClass();
        sb.append(obj.getClass().getName());
        sb.append("{");
        Field[] fields = currentClass.getDeclaredFields();
        for (Field field:fields) {
            if(field.isAnnotationPresent(Save.class)){
                Class fieldType = field.getType();
                field.setAccessible(true);
                try {
                    if (!predefinedTypes.contains(field.get(obj).getClass().getSimpleName())) {
                        serialize(sb, field.get(obj));
                    } else {
                        sb.append(fieldType.getName() + ":" + field.get(obj) + ";");
                    }
                }catch(IllegalAccessException e){e.printStackTrace();}
            }
        }
        sb.append("}");
        return;
    }

//    public Object startDeserialization(){
//        deserialize(sb, obj);
//        try(BufferedWriter writer = new BufferedWriter(new FileWriter(pathToSave))){
//            writer.write(sb.toString());
//
//        } catch(IOException e){
//            e.printStackTrace();
//        }
//    }

    public <T> T deserialize(){
        StringBuilder sb = new StringBuilder();
        String str = "";
        //T res = (T) cls.newInstance();
        try(BufferedReader reader = new BufferedReader(new FileReader(pathToFile))){
            str = reader.readLine();
            System.out.println(str);
        } catch(IOException e){ e.printStackTrace(); }

        ClassLoaderForDeserialization classLoader = new ClassLoaderForDeserialization();
        String part = str.substring(0, str.indexOf('{'));
        Field[] fields;
        try {
            Object obj = classLoader.loadClass(part).newInstance();
            fields = obj.getClass().getDeclaredFields();
            for(Field f:fields){
                System.out.println(f);
            }
        }catch(ClassNotFoundException e){e.printStackTrace();}
        catch (IllegalAccessException e){e.printStackTrace();}
        catch (InstantiationException e){e.printStackTrace();}
        return null;
    }
}
