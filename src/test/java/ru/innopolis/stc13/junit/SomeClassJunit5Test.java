package ru.innopolis.stc13.junit;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class SomeClassJunit5Test {

    private static Logger LOGGER = Logger.getLogger(SomeClassJunit5Test.class);
    private SomeClass someClass;

    @BeforeEach
    void setUp() {
        LOGGER.info("before each method");
        someClass = new SomeClass();
    }

    @AfterEach
    void tearDown() {
        LOGGER.info("after each method");
    }

    @Test
    void getSumm() {
        int res = someClass.getSumm(1, 2);
        assertEquals(3, res);
    }

    @Test
    void doSome() {
        assertThrows(IOException.class, () -> this.someClass.doSome(5));
    }

    @Test
    void doSomeNoException() {
        assertDoesNotThrow(() -> this.someClass.doSome(4));
    }
}
