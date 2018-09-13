package ru.innopolis.stc13.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Main2 {
    public static void main(String[] args) {
        String text = "Hello, world!";
        byte[] buffer = text.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(buffer);
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
            int c;
            while ((c = bufferedInputStream.read()) != -1) {
                System.out.println((char) c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
