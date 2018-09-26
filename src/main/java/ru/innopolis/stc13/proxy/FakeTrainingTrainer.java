package ru.innopolis.stc13.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class FakeTrainingTrainer implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("we do nothing");
        return 42;
    }
}
