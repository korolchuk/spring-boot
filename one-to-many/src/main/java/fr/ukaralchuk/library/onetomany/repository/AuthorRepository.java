package fr.ukaralchuk.library.onetomany.repository;

import fr.ukaralchuk.library.onetomany.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
