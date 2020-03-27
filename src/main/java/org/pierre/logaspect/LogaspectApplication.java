package org.pierre.logaspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class LogaspectApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(LogaspectApplication.class);

    @Autowired
    LoggingTest loggingTest;

    public static void main(String[] args) {
        SpringApplication.run(LogaspectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("starting!");
        loggingTest.logMePlease("bello");
        loggingTest.logMePleaseWithException("bello");

    }
}
