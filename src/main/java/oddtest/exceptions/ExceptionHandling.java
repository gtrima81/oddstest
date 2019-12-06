package oddtest.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler
    public ResponseEntity<Void> betNotFoundException(BetNotFoundException e) {
        return ResponseEntity.notFound().build();
    }
}
