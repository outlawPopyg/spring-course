package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("S.T.A.L.K.E.R: Запасной путь")
    private String title;

    @Value("Ежи Тумановский")
    private String author;

    @Value("2014")
    private int yearOfPublication;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}
