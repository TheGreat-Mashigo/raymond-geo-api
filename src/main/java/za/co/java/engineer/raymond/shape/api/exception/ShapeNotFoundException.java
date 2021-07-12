package za.co.java.engineer.raymond.shape.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ResponseStatus(value  = HttpStatus.NOT_FOUND)
public class ShapeNotFoundException extends Exception{
    @Getter
    private String message;
    
    public ShapeNotFoundException() {
        super("Shape does NOT exist");
        this.message = "Shape does NOT exist";
        log.error(message);
    }
}
