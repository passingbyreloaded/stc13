package ru.innopolis.stc13.proxywork;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        SomeClass someClass = new SomeClass();
        SomeInterfaceHandler handler = new SomeInterfaceHandler(someClass);
        SomeInterface proxy = (SomeInterface) Proxy.newProxyInstance(SomeInterfaceHandler.class.getClassLoader(), new Class[]{SomeInterface.class}, handler);
        proxy.someMethod();
    }
}
