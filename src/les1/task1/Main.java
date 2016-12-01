package les1.task1;

import java.lang.reflect.Method;

/**
 * Created by User on 01.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        Class<?> c = T.class;

        Method[] methods = c.getMethods();
        for(Method method:methods){
            if(method.isAnnotationPresent(Test.class)){
                Test test = method.getAnnotation(Test.class);
                try {
                    method.invoke(null, test.a(), test.b());
                }catch(Exception e){e.printStackTrace();}
            }
        }
    }
}
