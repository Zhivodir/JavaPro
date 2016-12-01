package les1.task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by User on 01.12.2016.
 */

public class ClassSaver {
    private TextContainer textContainer;

    public ClassSaver(TextContainer textContainer) {
        this.textContainer = textContainer;

        Class<?> cl = textContainer.getClass();
        String path = cl.getAnnotation(SaveTo.class).path();
        Method[] methods = cl.getMethods();
        for(Method method:methods){
            if(method.isAnnotationPresent(Saver.class)){
                try {
                    method.invoke(textContainer);
                }catch(IllegalAccessException e1){e1.printStackTrace();}
                catch (InvocationTargetException e2){e2.printStackTrace();}
            }
        }
    }
}
