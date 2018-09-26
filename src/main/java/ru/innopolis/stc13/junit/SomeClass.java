package ru.innopolis.stc13.junit;

import java.io.IOException;

public class SomeClass {

    public Integer getSumm(int a, int b) {
        return a + b;
    }

    public void doSome(int a) throws IOException {
        if (a == 5) {
            throw new IOException("some exc");
        }
    }
}
