package fr.ukaralchuk.library.onetomany.repo;

import fr.ukaralchuk.library.onetomany.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
