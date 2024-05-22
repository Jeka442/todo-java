package jeka.gudilov.TodoRestApi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = { ResponseStatusException.class })
    public ResponseEntity<Object> handleException(ResponseStatusException ex) {
        var body = new ExceptionBody(ex.getStatusCode().toString(), ex.getReason());
        return new ResponseEntity<>(body, ex.getStatusCode());
    }
}
