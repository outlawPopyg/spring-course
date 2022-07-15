package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class SecurityAspect {
    @Before("aop.aspects.Pointcuts.allMethodsFromUniLibrary()")
    public void beforeGetBookSecurityAdvice() {
        System.out.println( "\u001B[34m" + "beforeGetBookSecurityAdvice: checking rights" + "\u001B[0m");
    }
}
