package com.nhnacademy.mart;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {
    private final static Logger logger = Logger.getLogger("myLogger");

    public static Logger getLogger() {
        logger.setLevel(Level.INFO);
        return logger;
    }
}
