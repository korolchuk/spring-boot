package fr.ukaralchuk.library.onetomany.service;

import fr.ukaralchuk.library.onetomany.model.Book;
import fr.ukaralchuk.library.onetomany.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

}
