package org.example.microservmaintenance.error.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.BadRequestException;
import org.example.microservmaintenance.error.exception.NotExistsException;
import org.example.microservmaintenance.error.dto.MessageDTO;
import org.example.microservmaintenance.error.exception.BadRiquestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NotExistsException.class})
    public ResponseEntity<?> handlerNotExistsExcepion(NotExistsException ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                             .body(MessageDTO.builder()
                                             .message(ex.getMessage())
                                             .details(request.getRequestURI())
                                             .status(HttpStatus.CONFLICT).build());
    }

    @ExceptionHandler({BadRiquestException.class})
    public ResponseEntity<?> handlerBadRequestExcepion(BadRequestException ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(MessageDTO.builder()
                        .message(ex.getMessage())
                        .details(request.getRequestURI())
                        .status(HttpStatus.BAD_REQUEST).build());
    }

}
