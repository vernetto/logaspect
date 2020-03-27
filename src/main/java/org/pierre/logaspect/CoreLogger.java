package org.pierre.logaspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class CoreLogger {
    private static final Logger logger = LoggerFactory.getLogger(CoreLogger.class);

    @Around("@annotation(EntryExitLogger)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        Object response = null;
        String method = joinPoint.getSignature().toShortString();
        try {
            logger.info("Starting - " + method);
            response = joinPoint.proceed();
            logger.info("Ending - " + method);
            return response;
        } catch (Exception e) {
            logger.error("Exception while invoking method - " + method);
            throw e;
        }
    }

    @Around("methodsToBeProfiled()")
    public Object logAroundAll(ProceedingJoinPoint joinPoint) throws Throwable{
        Object response = null;
        String method = joinPoint.getSignature().toShortString();
        try {
            logger.info("Starting - " + method + " with parameter " + joinPoint.getArgs());
            Object[] signatureArgs = joinPoint.getArgs();
            for (Object signatureArg: signatureArgs) {
                logger.info("Arg: " + signatureArg);
            }
            response = joinPoint.proceed();
            logger.info("Ending - " + method + " with response " + response);
            return response;
        } catch (Exception e) {
            logger.error("Exception while invoking method - " + method);
            throw e;
        }
    }

    @AfterThrowing(
            pointcut="execution(* org.pierre.logaspect.*.*(..))",
            throwing="exec")
    public void catchAllSQLSyntaxErrors(Exception exec) {
        System.out.println("Here is the exception stacktrace: ");
        exec.printStackTrace();

    }

    @Pointcut("execution(public * org.pierre.logaspect..*(..))")
    public void methodsToBeProfiled(){}

}