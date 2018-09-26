package ru.innopolis.stc13.logging;

import org.apache.log4j.Logger;

public class MainLog4j {

    final static Logger LOGGER = Logger.getLogger(MainLog4j.class);

    public static void main(String[] args) {
        LOGGER.debug("debug-mess");
        for (int i = 0; i < 10_000; i++) {
            LOGGER.info("info-mess");
        }
    }
}
