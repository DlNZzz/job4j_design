package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
        byte b = 1;
        short s = 2;
        char c = '3';
        int age = 33;
        long l = 4L;
        float f = 5f;
        double d = 6;
        boolean bb = false;

        LOG.debug("{} {} {} {} {} {} {} {}", b, s, c, age, l, f, d, bb);
    }
}