package fr.ukaralchuk.library.onetomany.service;

import fr.ukaralchuk.library.onetomany.domain.Book;
import fr.ukaralchuk.library.onetomany.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService{

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

}
