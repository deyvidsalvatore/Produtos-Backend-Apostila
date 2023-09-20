package com.deyvidsalvatore.produtosapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> handleResourceNotFoundException(
			ResourceNotFoundException ex,
			HttpServletRequest request) {
		var standardError = new StandardError(LocalDateTime.now(), ex.getMessage(), HttpStatus.NOT_FOUND.value(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class) // Anotação para indicar que este método lida com exceções do tipo MethodArgumentNotValidException
	public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
	    // Este método trata exceções que ocorrem quando há problemas na validação dos argumentos de uma requisição
	    // Cria uma lista de erros de campo, onde cada erro é representado como um mapa (chave-valor)
	    List<Map<String, String>> fieldErrors = ex.getBindingResult().getFieldErrors().stream()
	            .map(fieldError -> Map.of("campo", fieldError.getField(), "mensagem", fieldError.getDefaultMessage()))
	            .toList();
	    // Cria um mapa para representar a resposta de erro
	    Map<String, Object> errorResponse = Map.of(
	        "erro", "Falha na validação do corpo", // Mensagem geral de erro
	        "erros de campo", fieldErrors // Lista de erros de campo
	    );
	    // Retorna uma resposta HTTP com status 400 (BadRequest) e o corpo contendo o mapa de resposta de erro em formato JSON
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<StandardError> handleExceptionServer(Exception ex, HttpServletRequest request) {
		var standardError = new StandardError(LocalDateTime.now(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(standardError);
	}

}
