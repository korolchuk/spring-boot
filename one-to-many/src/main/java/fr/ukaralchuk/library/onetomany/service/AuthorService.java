package fr.ukaralchuk.library.onetomany.service;

import fr.ukaralchuk.library.onetomany.exception.AuthorException;
import fr.ukaralchuk.library.onetomany.model.Author;
import fr.ukaralchuk.library.onetomany.model.Book;
import fr.ukaralchuk.library.onetomany.repository.AuthorRepository;
import fr.ukaralchuk.library.onetomany.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new AuthorException("Author " + id + " not found"));
    }

    public Author addAuthor(Author author) {
        Author newAuthor = authorRepository.save(new Author(author.getName()));
        System.out.println(author.getBooks());
        if (author.getBooks() != null) {
            List<Book> books = author.getBooks();
            List<Book> newBooks = new ArrayList<>();
            for (Book book : books) {
                Book newBook = bookRepository.save(new Book(book.getName(), newAuthor));
                newBooks.add(newBook);
            }
            newAuthor.setBooks(newBooks);
        }
        return newAuthor;
    }

    public Author deleteAuthorById(Long id) {
        Author authorDeleted = this.getAuthorById(id);
        if (authorDeleted.getBooks() != null) {
            List<Book> booksDeleted = authorDeleted.getBooks();
            for (Book book : booksDeleted) {
                bookRepository.delete(book);
            }
        }
        authorRepository.deleteById(id);
        return authorDeleted;
    }

    public Author putAuthor(Author author, Long id) {
        Author authorUpdated = this.getAuthorById(id);
        authorUpdated.setName(author.getName());
        return authorRepository.save(authorUpdated);
    }
}
