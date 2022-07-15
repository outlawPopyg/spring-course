package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class)) {
            UniLibrary uniLibrary  = context.getBean("uniLibrary", UniLibrary.class);
//            uniLibrary.getBook();
//            uniLibrary.getMagazine();

            SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
//            schoolLibrary.getBook();

//            uniLibrary.returnBook();

            Book book = context.getBean("book", Book.class);
//            uniLibrary.getBookByTitle(book);

            schoolLibrary.addBook("Kalim", book);

        }
    }
}
