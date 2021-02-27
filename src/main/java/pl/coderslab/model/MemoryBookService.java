package pl.coderslab.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Book> get(Long id) {
        return books.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    @Override
    public void add(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    @Override
    public void delete(Long id) {
        if (get(id).isPresent()) {
            books.remove(this.get(id).get());
        }
    }

}
