package ProjetoN3.Exceptions;

// Exceção personalizada para quando tentar adicionar um recurso com uma categoria não encontrada no banco
public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}