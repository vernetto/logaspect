package org.pierre.logaspect;

import org.springframework.stereotype.Component;

@Component
public class LoggingTest {
    @EntryExitLogger
    public void logMePlease() {
        System.out.println("fanculo");
    }
}
