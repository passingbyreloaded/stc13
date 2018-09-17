package ru.innopolis.stc13.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TrainingCenter implements InvocationHandler {

    private Trainer trainer;

    public TrainingCenter(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("i take your money");
        System.out.println("i give money to trainer");
        System.out.println("lets go work! we are team");

        if (method.getName().equals("talk")) {
            System.out.println("whos late");
        }

        return method.invoke(trainer, args);
    }
}
