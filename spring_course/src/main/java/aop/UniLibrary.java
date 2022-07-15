package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends Library {
    @Override
    public void getBook() {
        System.out.println("take a book from UniLibrary");
    }

    public void getMagazine() {
        System.out.println("take a magazine from UniLibrary");
    }

    public void returnMagazine() {
        System.out.println("return magazine to UniLibrary");
    }

    public String returnBook() {
        System.out.println("return book to UniLibrary");
        return "";
    }

    public void getBookByTitle(Book book) {
        System.out.println("finding book with title: " + book.getTitle());
    }
}
