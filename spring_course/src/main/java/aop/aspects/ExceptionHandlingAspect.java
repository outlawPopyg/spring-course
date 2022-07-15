package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class ExceptionHandlingAspect {
    @Before("aop.aspects.Pointcuts.allMethodsFromUniLibrary()")
    public void beforeGetBookHandleException() {
        System.out.println( "\u001B[34m" + "beforeGetBookHandleException: handling exceptions" + "\u001B[0m");
    }
}
