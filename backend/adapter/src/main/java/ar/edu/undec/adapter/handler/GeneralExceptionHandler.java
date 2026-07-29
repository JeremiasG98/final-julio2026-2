package ar.edu.undec.adapter.handler;

import ar.edu.undec.adapter.data.exception.DataBaseException;
import ar.edu.undec.adapter.data.exception.FailedMapperException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler({FailedMapperException.class, DataBaseException.class})
    ResponseEntity<?> handlerBadRequest(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
