package fr.ukaralchuk.library.onetomany.repo;

import fr.ukaralchuk.library.onetomany.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
