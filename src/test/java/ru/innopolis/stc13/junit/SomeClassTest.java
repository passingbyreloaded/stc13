package ru.innopolis.stc13.junit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SomeClassTest {

    private static Logger LOGGER = Logger.getLogger(SomeClassTest.class);
    private SomeClass someClass;

    @Before
    public void setUp() {
        LOGGER.info("before each method");
        someClass = new SomeClass();
    }

    @After
    public void tearDown() {
        LOGGER.info("after each method");
    }

    @Test
    public void getSumm() {
        int res = someClass.getSumm(1, 2);
        assertEquals(3, res);
    }

    @Test(expected = IOException.class)
    public void doSome() throws IOException {
        someClass.doSome(5);
    }
}
