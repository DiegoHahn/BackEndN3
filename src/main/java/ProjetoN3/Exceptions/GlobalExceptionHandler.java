package ProjetoN3.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// Classe que trata as exceções lançadas pela aplicação
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Método que trata as exceções de validação dos campos, para lançar a mensagem passada na anotação @NotNull ao usuário
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) { //MethodArgumentNotValidException é a exceção lançada quando um campo não passa na validação
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }

    // Método que trata a exceção de categoria não encontrada, para lançar a mensagem passada na exceção ao usuário
    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleCategoryNotFoundException(CategoryNotFoundException ex) { //CategoryNotFoundException é a exceção personalizada
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return error;
    }
}
