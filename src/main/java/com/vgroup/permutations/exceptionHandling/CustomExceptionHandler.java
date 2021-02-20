/**
 * 
 */
package com.vgroup.permutations.exceptionHandling;

import java.time.LocalDateTime;

/**
 * @author skadale
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vgroup.permutations.dto.ErrorResponse;
 
@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler 
{
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}
		ErrorResponse error = new ErrorResponse();
		error.setMessage("Validation Failed");
		error.setDetails(details);
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}
	
    @ExceptionHandler(InvalidInputException.class)
    public final ResponseEntity<Object> handleAllExceptions(InvalidInputException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse();
        error.setTimeStamp(LocalDateTime.now());
        error.setMessage("Invalid Input Data");
        error.setErrorCode(400);
        error.setDetails(details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
 
}
