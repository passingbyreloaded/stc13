package ru.innopolis.stc13.classloaderwithproxy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HumanClassLoader extends ClassLoader {

    public HumanClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.equals("ru.innopolis.stc13.classloaderwithproxy.EuropeanHuman")) {
            String dest = "file:D://EuropeanHuman1.class";
            byte[] classData = null;
            try (InputStream inputStream = new URL(dest).openConnection().getInputStream();
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
        return super.loadClass(name);
    }
}
