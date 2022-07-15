package aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution(* aop.SchoolLibrary.*(..))")
    public void allMethodsFromUniLibrary() {}
}
