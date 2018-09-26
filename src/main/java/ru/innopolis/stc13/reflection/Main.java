package ru.innopolis.stc13.reflection;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        Capucin mrJenkins = new Capucin(10, 100, 33);
//        Field field = mrJenkins.getClass().getDeclaredField("footsize");
//        field.setAccessible(true);
//        System.out.println(field.get(mrJenkins));
//        field.set(mrJenkins, 34);
//        System.out.println(field.get(mrJenkins));
//        Field tailLenghtField = mrJenkins.getClass().getDeclaredField("tailLenght");
//        tailLenghtField.setAccessible(true);
//        System.out.println(tailLenghtField.get(mrJenkins));
//        tailLenghtField.set(mrJenkins, 45);
//        System.out.println(tailLenghtField.get(mrJenkins));

        Capucin abou = new Capucin(50);
        Class<Capucin> clazz = (Class<Capucin>) abou.getClass();
        ReflectionUtils.printClass(clazz);
    }
}
