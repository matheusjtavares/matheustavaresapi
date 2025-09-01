package br.edu.infnet.matheustavaresapi.controller.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.infnet.matheustavaresapi.model.domain.exceptions.GameTitleInvalidException;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.GameTitleNotFoundException;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.PlatformInvalidException;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.PlatformNotFoundException;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.PlayerInvalidException;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.PlayerNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Tratamento Validação
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    // Tratamento Exceções de negócio
	@ExceptionHandler(GameTitleInvalidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(GameTitleInvalidException ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put("Data/Hora",LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.BAD_REQUEST.toString());
        errors.put("Message", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(GameTitleNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(GameTitleNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put("Data/Hora",LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.NOT_FOUND.toString());
        errors.put("Message", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PlatformInvalidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(PlatformInvalidException ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put("Data/Hora",LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.BAD_REQUEST.toString());
        errors.put("Message", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(PlatformNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(PlatformNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put("Data/Hora",LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.NOT_FOUND.toString());
        errors.put("Message", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PlayerInvalidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(PlayerInvalidException ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put("Data/Hora",LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.BAD_REQUEST.toString());
        errors.put("Message", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(PlayerNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put("Data/Hora",LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.NOT_FOUND.toString());
        errors.put("Message", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
    
    // Tratamento IllegalArgument
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(IllegalArgumentException ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put("Data/Hora",LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.BAD_REQUEST.toString());
        errors.put("Message", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    // Exceções Genéricas
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(Exception ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put("Data/Hora",LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.toString());
        errors.put("Message", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
