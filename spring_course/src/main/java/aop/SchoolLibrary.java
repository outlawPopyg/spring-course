package aop;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends Library {
    @Override
    public void getBook() {
        System.out.println("take a book from SchoolLibrary");
    }

    public void returnBook() {
        System.out.println("return book to school lib");
    }

    public void getMagazine() {
        System.out.println("take magazine from school lib");
    }

    public void returnMagazine() {
        System.out.println("return magazine to school lib");
    }

    public void addBook(String name, Book book) {
        System.out.println(name + " added a book: " + book.getTitle());
        System.out.println("-----------------------------------");
    }

    public void addMagazine() {
        System.out.println("-----------------------------------");
    }
}
