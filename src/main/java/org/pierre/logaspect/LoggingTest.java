package org.pierre.logaspect;

import org.springframework.stereotype.Component;

@Component
public class LoggingTest {
    @EntryExitLogger
    public String logMePlease(String name) {
        System.out.println("in LoggingTest.logMePlease");
        return "hello " + name;
    }

    public String logMePleaseWithException(String name) {
        System.out.println("in LoggingTest.logMePleaseWithException");
        if (true) throw new IllegalArgumentException("hello I am an exception");

        return "hello " + name;
    }


}
