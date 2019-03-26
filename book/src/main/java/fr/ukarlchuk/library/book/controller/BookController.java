package fr.ukarlchuk.library.book.controller;

import fr.ukarlchuk.library.book.exception.BookException;
import fr.ukarlchuk.library.book.model.Book;
import fr.ukarlchuk.library.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable("id") long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookException("Book " + id + " not found"));
    }

    @GetMapping("author/{author}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooksByAuthor(@PathVariable("author") String author) {
        return bookRepository.findBooksByAuthor(author);
    }

    @PostMapping("book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book deleteBook(@PathVariable("id") long id) {
        Book bookDeleted = bookRepository.findById(id)
                .orElseThrow(() -> new BookException("Book " + id + " not found"));
        bookRepository.deleteById(id);
        return bookDeleted;
    }

    @PutMapping("book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(@PathVariable("id") long id, @Valid @RequestBody Book book) {
        Book bookUpdeted = bookRepository.findById(id)
                .orElseThrow(() -> new BookException("Book " + id + " not found"));
        bookUpdeted.setTitle(book.getTitle());
        bookUpdeted.setAuthor(book.getAuthor());
        return bookRepository.save(bookUpdeted);
    }




}
