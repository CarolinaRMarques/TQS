package bookSearch;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private final List<Book> store = new ArrayList<>();

    public void addBook(final Book book) {
        store.add(book);
    }

    public List<Book> findBooks(final LocalDateTime from, final LocalDateTime to) {

        Date date = Date.from(to.atZone( ZoneId.systemDefault()).toInstant());
        Date date_from = Date.from( from.atZone( ZoneId.systemDefault()).toInstant());

        Calendar end = Calendar.getInstance();
        end.setTime(date);
        end.roll(Calendar.YEAR, 1);

        return store.stream().filter(book -> {
            return date_from.before(book.getPublished()) && end.getTime().after(book.getPublished());
        }).sorted(Comparator.comparing(Book::getPublished).reversed()).collect(Collectors.toList());
    }
}