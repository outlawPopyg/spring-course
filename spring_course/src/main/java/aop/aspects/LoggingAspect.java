package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* aop.UniLibrary.*(..))")
    private void allMethodsFromUniLibrary() {}

    @Pointcut("execution(public void aop.UniLibrary.returnMagazine())")
    private void returnMagazineFromUniLibrary() {}
    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
    private void allMethodsExceptReturnMagazineFromUniLibrary() {}

    @Pointcut("execution(public void aop.SchoolLibrary.add*(..))")
    private void allAddMethodsFromSchoolLib() {}

    @Before("allAddMethodsFromSchoolLib()")
    public void beforeAddMethod(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method signature: " + methodSignature);

        if (methodSignature.getName().equals("addBook")) {
            Object[] args = joinPoint.getArgs();
            for (Object obj : args) {
                if (obj instanceof Book) {
                    System.out.println("Book name: " + ((Book) obj).getTitle());
                    System.out.println("Book author: " + ((Book) obj).getAuthor());
                    System.out.println("Books year: " + ((Book) obj).getYearOfPublication());
                } else if (obj instanceof String) {
                    System.out.println("Book was added by" + obj    );
                }
            }
        }



        System.out.println("-----------------------------------");
    }

    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
    public void beforeAllMethodsExceptReturnMagazine() {
        System.out.println( "\u001B[34m" + "(beforeAllMethodsExceptReturnMagazine: ...)" + "\u001B[0m");
    }

    @Pointcut("execution(* get*())")
    private void allGetMethods() {}

    @Before("allGetMethods()")
    public void beforeGetBookAdvice() {
        System.out.println( "\u001B[34m" + "(beforeGetBookAdvice: trying to take a book...)" + "\u001B[0m");
    }

    @Before("execution(public * return*())")
    public void beforeReturnBookAdvice() {
        System.out.println( "\u001B[34m" + "(beforeGetBookAdvice: trying to return a book...)" + "\u001B[0m");
    }

    @Before("execution(public void getBookByTitle(aop.Book))")
    public void beforeGetBookByTitle() {
        System.out.println( "\u001B[34m" + "(beforeGetBookAdvice: trying to find a book...)" + "\u001B[0m");
    }


}
