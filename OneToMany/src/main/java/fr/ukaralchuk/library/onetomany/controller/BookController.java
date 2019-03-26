package fr.ukaralchuk.library.onetomany.controller;

import fr.ukaralchuk.library.onetomany.domain.Book;
import fr.ukaralchuk.library.onetomany.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api", produces = "application/json")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("books")
    public Iterable<Book> getAllBooks() {
        return bookService.findAllBooks();
    }


}
