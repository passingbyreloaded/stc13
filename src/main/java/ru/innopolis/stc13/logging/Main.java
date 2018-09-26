package ru.innopolis.stc13.logging;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {
        System.err.println("my error message");
        System.out.println("my usual message");

        try {
            System.setErr(new PrintStream(new FileOutputStream("error.log")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.err.println("message to file");
        try {
            throw new Exception("exc mess");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
