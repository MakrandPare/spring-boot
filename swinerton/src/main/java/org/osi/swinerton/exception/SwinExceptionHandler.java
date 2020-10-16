
package org.osi.swinerton.exception;

import org.osi.swinerton.dto.SwinertonDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SwinExceptionHandler {

	@ExceptionHandler(SwinException.class)
	public ResponseEntity<SwinertonDTO> getExceptionData(SwinException exception) {
		SwinertonDTO swinDto = new SwinertonDTO();
		swinDto.setSuccess("FALSE");
		swinDto.setMessage(exception.getMessage());
		return new ResponseEntity<>(swinDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
