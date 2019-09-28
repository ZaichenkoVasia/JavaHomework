package ua.mycompany.task7.example2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, InstantiationException {
        Singleton singleton1 = Singleton.SINGLETON;
//        Singleton singleton2 = new Singleton();
//        System.out.println(singleton1 == singleton2);
//        singleton1.notStaticMethod();

        Class<Singleton> singletonClass = Singleton.class;

        //Not static method without parameters
        Method method1 = singletonClass.getDeclaredMethod("notStaticMethod");
        method1.setAccessible(true);
        System.out.println(method1.getName());
        Object invoke1 = method1.invoke(singleton1);

        //Not static method with parameter
        Method method2 = singletonClass.getDeclaredMethod("notStaticMethod", int.class);
        method2.setAccessible(true);
        System.out.println(method2.getName());
        Object invoke2 = method2.invoke(singleton1, 1);

        //Static method without parameters
        Method method3 = singletonClass.getDeclaredMethod("staticMethod");
        method3.setAccessible(true);
        System.out.println(method3.getName());
        Object invoke3 = method3.invoke(null);

        //Private constructor
        Constructor<Singleton> declaredConstructor = singletonClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton singleton = declaredConstructor.newInstance();
        System.out.println(singleton == singleton1);
    }
}

class Singleton {

    public static final Singleton SINGLETON = new Singleton();

    private Singleton() {
    }

    private void notStaticMethod() {
        System.out.println("Hello");
    }

    private void notStaticMethod(int code) {
        System.out.println("Hello " + code);
    }

    private static void staticMethod() {
        System.out.println("Hello from static");
    }
}
