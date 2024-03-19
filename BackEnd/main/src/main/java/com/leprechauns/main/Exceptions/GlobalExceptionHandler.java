package com.leprechauns.main.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponses errorResponse = new ErrorResponses("Invalid argument", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(NotFoundEndPoint.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleCalculatorIdException(NotFoundEndPoint ex1){
        ErrorResponses errorResponse = new ErrorResponses("That endpoint doesn't exist", ex1.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleGlobalException(Exception ex) {
        ErrorResponses errorResponse = new ErrorResponses("Error in the application", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidApplicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleInvalidInputException(InvalidApplicationException ex) {
        ErrorResponses errorResponse = new ErrorResponses("Invalid input data", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleDatabaseException(DataAccessException ex) {
        ErrorResponses errorResponse = new ErrorResponses("Database error", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // @ExceptionHandler(AuthorizationException.class)
    // @ResponseStatus(HttpStatus.UNAUTHORIZED)
    // public ResponseEntity<Object> handleAuthorizationException(AuthorizationException ex) {
    //     ErrorResponses errorResponse = new ErrorResponses("Authorization error", ex.getMessage());
    //     return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    // }
}
