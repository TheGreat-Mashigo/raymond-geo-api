package za.co.java.engineer.raymond.shape.api.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(ShapeNotFoundException.class)
    public ResponseEntity<?> shapeNotFoundException(ShapeNotFoundException shapeNotFoundException, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), shapeNotFoundException.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
	 public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

    @ExceptionHandler(ShapeAlreadyExistsException.class)
    public ResponseEntity<?> shapeAlreadyExistsException(ShapeAlreadyExistsException shapeAlreadyExistsException, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), shapeAlreadyExistsException.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }
}
