package ua.mycompany.task7.myjunit;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class Runner {
    private Runner() {
    }

    public static void run() throws InvocationTargetException,
            IllegalAccessException {

        TestClass testClass = new TestClass();
        Class<?> clazz = testClass.getClass();
        Method[] methods = clazz.getMethods();
        int counter = 0;

        List<Method> beforeClassMethods = getMethodByAnnotation(methods, BeforeClass.class);
        List<Method> beforeMethods = getMethodByAnnotation(methods, Before.class);
        List<Method> testMethods = getMethodByAnnotation(methods, Test.class);
        List<Method> afterMethods = getMethodByAnnotation(methods, After.class);
        List<Method> afterClassMethods = getMethodByAnnotation(methods, AfterClass.class);

        invokeClassMethods(beforeClassMethods);
        invokeTestMethods(beforeMethods, testMethods, afterMethods,testClass);
        invokeClassMethods(afterClassMethods);
    }

    private static void invokeClassMethods(List<Method> classMethods) throws InvocationTargetException, IllegalAccessException {
        for (Method method : classMethods) {
            method.invoke(null);
        }
    }

    private static void invokeTestMethods(List<Method> beforeTestMethods, List<Method> testMethods,
                                          List<Method> afterTestMethods, Object object)
            throws InvocationTargetException, IllegalAccessException {

        for (Method testMethod : testMethods) {

            for (Method beforeTestMethod : beforeTestMethods) {
                beforeTestMethod.invoke(null);
            }

            testMethod.invoke(object);

            for (Method afterTestMethod : afterTestMethods) {
                afterTestMethod.invoke(null);
            }

        }
    }


    private static List<Method> getMethodByAnnotation(Method[] methods, Class<? extends Annotation> clazz) {
        List<Method> resultMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(clazz)) {
                resultMethods.add(method);
            }
        }
        return resultMethods;
    }

}

