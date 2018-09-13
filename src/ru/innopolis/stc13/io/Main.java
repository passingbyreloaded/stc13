package ru.innopolis.stc13.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        copyFile("D://note.txt", "D://note2.txt");
//        readFile("D://note.txt");
//        String text = "File not found";
//        writeFile("D://note.txt", text);
//        readFile("D://note.txt");
    }

    public static void readFile(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            System.out.println("File size: " + fileInputStream.available());
            int i = -1;
            while ((i = fileInputStream.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String fileName, String content) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            byte[] buffer = content.getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String fileName, String fileName2) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             FileOutputStream fileOutputStream = new FileOutputStream(fileName2)) {
            int i;
            while ((i = fileInputStream.read()) != -1) {
                fileOutputStream.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
