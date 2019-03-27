package fr.ukaralchuk.library.onetomany.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AuthorException extends RuntimeException {
    public AuthorException(String message) {
        super(message);
    }
}
