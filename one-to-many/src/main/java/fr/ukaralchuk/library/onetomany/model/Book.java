package fr.ukaralchuk.library.onetomany.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonIgnore
    private Author author;

    public String getAuthorName() {
        return author.getName();
    }

    public Book() {
    }

    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
    }
}
