package ru.innopolis.stc13.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainJul {

    private static final Logger logger = Logger.getLogger(MainJul.class.getName());

    public static void main(String[] args) {
        logger.info("my logging message");
        logger.log(Level.WARNING, "my warning");
        try {
            FileHandler fh = new FileHandler("jullog.log");
            logger.addHandler(fh);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.log(Level.INFO, "mess to file and console");
        logger.log(Level.WARNING, "warn to file and console");
    }
}
