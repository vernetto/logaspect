package org.pierre.logaspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CoreLogger {
    private static final Logger logger = LogManager.getLogger(CoreLogger.class);

    @Around("@annotation(EntryExitLogger)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        Object response = null;
        String method = joinPoint.getSignature().toShortString();
        try {
            logger.info("Starting - " + method);
            System.out.println("starting ");
            response = joinPoint.proceed();
            logger.info("Ending - " + method);
            return response;
        } catch (Exception e) {
            logger.error("Exception while invoking method - " + method);
            throw e;
        }
    }
}