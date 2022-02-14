import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class App {

    public static void main(String[] args) {
        start(HomeworkSevenTest.class);
    }

    public static void start(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        try {
            Object obj = clazz.newInstance();
            Method methodTempBeforeSuit = null;
            Method methodTempAfterSuit = null;
            ArrayList<Method> tempArray;
            TreeMap<Integer, ArrayList<Method>> testMap = new TreeMap<>();
            int tempBeforeSuit = 0;
            int tempAfterSuit = 0;
            for (Method m : methods) {
                if (m.getAnnotation(BeforeSuite.class) != null) {
                    methodTempBeforeSuit = m;
                    tempBeforeSuit++;
                }
                if (m.getAnnotation(AfterSuite.class) != null) {
                    methodTempAfterSuit = m;
                    tempAfterSuit++;
                }
                if (m.getAnnotation(Test.class) != null) {
                    if (testMap.get(m.getAnnotation(Test.class).priority()) != null) {
                        tempArray = testMap.get(m.getAnnotation(Test.class).priority());

                    } else {
                        tempArray = new ArrayList<>();
                    }
                    tempArray.add(m);
                    testMap.put(m.getAnnotation(Test.class).priority(), tempArray);
                }
            }
            if (tempAfterSuit > 1 || tempBeforeSuit > 1) {
                throw new RuntimeException("В классе несколько методов с аннотацией BeforeSuit или AfterSuite");
            } else {
                if (methodTempBeforeSuit != null) {
                    methodTempBeforeSuit.invoke(obj);
                }
                for (Map.Entry<Integer, ArrayList<Method>> entry : testMap.entrySet()) {
                    for (Method m : entry.getValue()) {
                        m.invoke(obj);
                    }
                }
                if (methodTempAfterSuit != null) {
                    methodTempAfterSuit.invoke(obj);
                }
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }


}
