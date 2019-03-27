package fr.ukaralchuk.library.onetomany.controller;

import fr.ukaralchuk.library.onetomany.model.Author;
import fr.ukaralchuk.library.onetomany.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api", produces = "application/json")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("authors")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorById(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }

    @DeleteMapping("author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author deleteAuthorById(@PathVariable("id") Long id) {
        return authorService.deleteAuthorById(id);
    }

    @PostMapping(value = "author", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @PutMapping(value = "author/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Author putAuthor(@RequestBody Author author, @PathVariable("id") Long id) {
        return authorService.putAuthor(author, id);
    }



}
