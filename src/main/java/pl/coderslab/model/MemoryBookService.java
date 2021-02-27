package pl.coderslab.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("books")
@Repository
public class MemoryBookService implements BookService {

    private List<Book> books;
    private static Long nextId = 4L;

    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking in Java","Bruce Eckel","Helion","programming"));
        books.add(new Book(2L, "9788324627738", "Rusz głowa Java.","Sierra Kathy, Bates Bert","Helion","programming"));
        books.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell","Helion","programming"));
    }

    public List<Book> getList() {
        return books;
    }

    public void setList(List<Book> list) {
        this.books = books;
    }

    public static Long getNextId() {
        return nextId;
    }

    public static void setNextId(Long nextId) {
        MemoryBookService.nextId = nextId;
    }

    @Override
    public List<Book> getBooks() {
        return this.books;
    }
}
