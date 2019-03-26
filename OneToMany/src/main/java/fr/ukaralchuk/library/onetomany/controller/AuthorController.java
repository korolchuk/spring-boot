package fr.ukaralchuk.library.onetomany.controller;

import fr.ukaralchuk.library.onetomany.domain.Author;
import fr.ukaralchuk.library.onetomany.domain.Book;
import fr.ukaralchuk.library.onetomany.service.AuthorService;
import fr.ukaralchuk.library.onetomany.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api", produces = "application/json")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("authors")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Author> getAllAuthors() {
        return authorService.findAllAuthors();
    }

    @GetMapping("author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorById(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping(value = "author/add", consumes ="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @PutMapping(value = "author/update", consumes ="application/json")
    @ResponseStatus(HttpStatus.OK)
    public Author putAuthor(@RequestBody Author author) {
        return authorService.putAuthor(author);
    }

    @DeleteMapping("author/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public Author deleteAuthorById(@PathVariable("id") Long id) {
        return authorService.deleteAuthorById(id);
    }

}
