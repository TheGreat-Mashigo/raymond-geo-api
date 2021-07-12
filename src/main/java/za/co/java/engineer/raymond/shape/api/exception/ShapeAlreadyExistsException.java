package za.co.java.engineer.raymond.shape.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ResponseStatus(value  = HttpStatus.CONFLICT)
public class ShapeAlreadyExistsException extends Exception {
    @Getter
    private String message;

    public ShapeAlreadyExistsException() {
        super("Shape already exists");
        this.message = "Shape already exists";
        log.error(message);
    }
}
