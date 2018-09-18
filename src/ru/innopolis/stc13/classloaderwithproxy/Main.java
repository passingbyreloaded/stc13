package ru.innopolis.stc13.classloaderwithproxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        Human human = new EuropeanHuman();
//        System.out.println(human.talk());
//        human.eat("apple", 3);
//        human.sleep(2);
//
//        ClassLoader parentClassLoader = EuropeanHuman.class.getClassLoader();
//        HumanClassLoader humanClassLoader = new HumanClassLoader(parentClassLoader);
//
//        Class europeanHumanClass = humanClassLoader.loadClass("ru.innopolis.stc13.classloaderwithproxy.EuropeanHuman");
//        System.out.println(europeanHumanClass.getMethod("talk").invoke(europeanHumanClass.newInstance()));

        Human human1 = (Human) Proxy.newProxyInstance(Human.class.getClassLoader(), new Class[]{Human.class}, new HumanHandler());
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            human1.sleep(50);
            System.out.println(human1.talk());
            human1.eat("candy", 25);
            scanner.nextLine();
        }
    }
}
