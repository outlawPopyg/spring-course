package aop.aspects;


import aop.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityAspect {

    @Before("execution(public java.util.List aop.University.getStudents())")
    public void beforeGetStudentsAdvice() {
        System.out.println("\u001B[34m" + "(beforeGetStudentsAdvice: ...)" + "\u001B[0m");
    }

    @AfterReturning(pointcut = "execution(public java.util.List aop.University.getStudents())", returning = "students")
    public void afterGetStudentsAdvice(JoinPoint joinPoint, List<Student> students) {
        System.out.println("\u001B[34m" + "(afterGetStudentsAdvice: ...)" + "\u001B[0m");
        Student student = students.get(0);
        student.setName("Derek");
    }

    @AfterThrowing(pointcut = "execution(public java.util.List aop.University.getStudents())", throwing = "exception")
    public void afterGetStudentsThrowing(Throwable exception) {
        System.out.println("afterGetStudentsThrowing: " + exception);
    }

    @Around("execution(public String aop.University.someMethod())")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before someMethod()");

        Object targetMethod = null;

        try {
            targetMethod = joinPoint.proceed();
        } catch (Exception e) {
            System.out.println("logged exception " + e);
            throw new IllegalArgumentException(e);
        }

        System.out.println("after someMethod()");
        return targetMethod;
    }
}
