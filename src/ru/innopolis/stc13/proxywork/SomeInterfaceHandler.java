package ru.innopolis.stc13.proxywork;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SomeInterfaceHandler implements InvocationHandler {
    private SomeClass someClass;

    public SomeInterfaceHandler(SomeClass someClass) {
        this.someClass = someClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (someClass.getClass().getMethod(method.getName()).getAnnotation(Logged.class) != null) {
            System.out.println("method invoked");
        }
        long start = System.currentTimeMillis();
        Object result = method.invoke(someClass, args);
        System.out.println("Execution time: " + (System.currentTimeMillis() - start));
        return result;
    }
}
