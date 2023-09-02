package com.nhnacademy.mart;

import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class MyLogger {
    private static final Logger logger = Logger.getLogger("myLogger");

    public static Logger getLogger() {
        logger.setLevel(Level.INFO);
        return logger;
    }
}
