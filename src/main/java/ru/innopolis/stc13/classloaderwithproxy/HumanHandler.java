package ru.innopolis.stc13.classloaderwithproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HumanHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanClassLoader humanClassLoader = new HumanClassLoader(proxy.getClass().getClassLoader());
        Class europeanHumanClass = humanClassLoader.loadClass("ru.innopolis.stc13.classloaderwithproxy.EuropeanHuman");
        Method method1 = europeanHumanClass.getMethod(method.getName(), method.getParameterTypes());
        return method1.invoke(europeanHumanClass.newInstance(), args);
    }
}
