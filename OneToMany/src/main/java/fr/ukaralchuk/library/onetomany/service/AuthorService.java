package fr.ukaralchuk.library.onetomany.service;

import fr.ukaralchuk.library.onetomany.domain.Author;
import fr.ukaralchuk.library.onetomany.domain.Book;
import fr.ukaralchuk.library.onetomany.repo.AuthorRepository;
import fr.ukaralchuk.library.onetomany.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Author addAuthor(Author author) {

        Author newAuthor = authorRepository.save(new Author("Vova"));
        Book book1 = new Book("VovaBook1", newAuthor);
        Book newBook = bookRepository.save(book1);
        List<Book> books = new ArrayList<>();
        books.add(newBook);
        newAuthor.setBooks(books);
        return newAuthor;
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).get();
    }

    public Author deleteAuthorById(Long id) {
        Author author = this.getAuthorById(id);
        authorRepository.deleteById(id);
        return author;
    }

    public Author putAuthor(Author author) {
        return null;
    }
}
