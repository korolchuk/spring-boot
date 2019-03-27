package fr.ukaralchuk.library.onetomany.repository;

import fr.ukaralchuk.library.onetomany.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
