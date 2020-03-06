package bookSearch;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Book {
    private final String title;
    private final String author;
    private final Date published;

    public Book(String title, String author, Date published) {
        this.title = title;
        this.author = author;
        this.published = published;
    }

    public Book(String title, String author, LocalDateTime published) {
        this.title = title;
        this.author = author;
        this.published = Date.from(published.atZone( ZoneId.systemDefault()).toInstant());
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getPublished() {
        return published;
    }

}