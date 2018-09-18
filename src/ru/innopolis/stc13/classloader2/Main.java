package ru.innopolis.stc13.classloader2;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder builder = new StringBuilder();
        builder.append("package ru.innopolis.stc13.classloader2; public class Monster { public void doWork(){");
        while (!(line = reader.readLine()).equals("")) {
            builder.append(line);
        }
        builder.append("}}");
        File file = new File("Monster.java");
        file.createNewFile();
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.write(builder.toString());
        }

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, file.getAbsolutePath());
        Class monsterClass = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                if (name.equals("ru.innopolis.stc13.classloader2.Monster")) {
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
                return super.loadClass(name);
            }
        }.loadClass("ru.innopolis.stc13.classloader2.Monster");
        monsterClass.getMethod("doWork").invoke(monsterClass.newInstance());
    }
}
