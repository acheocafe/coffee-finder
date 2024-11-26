package br.com.coffeefinder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalHandlerException
 */
@RestControllerAdvice
public class GlobalHandlerException {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred. Please contact support.");
	}

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred. Please contact support.");
	}

	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<String> handleNullPointerException(NullPointerException e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected null value encountered. Please contact support.");
	}

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found: " + e.getMessage());
	}

	@ExceptionHandler(value = MerchantNotFoundException.class)
	public ResponseEntity<String> handleMerchantNotFoundException(MerchantNotFoundException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Merchant not found");
	}

}
