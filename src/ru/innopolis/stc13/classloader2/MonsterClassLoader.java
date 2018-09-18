package ru.innopolis.stc13.classloader2;

import java.io.*;

public class MonsterClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        byte[] classData = null;
        try (InputStream inputStream = new FileInputStream(new File("Monster.class"));
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            int data = inputStream.read();
            while (data != -1) {
                byteArrayOutputStream.write(data);
                data = inputStream.read();
            }
            classData = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, classData, 0, classData.length);
    }
}
