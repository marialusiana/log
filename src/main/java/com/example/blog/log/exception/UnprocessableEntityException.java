package com.example.blog.log.exception;


import org.springframework.http.HttpStatus;
/* 
* The server understands the content type of the request entity, 
* and the syntax of the request entity is correct 
* but was unable to process the contained instructions.
*/
public class UnprocessableEntityException extends BaseException {
	
	private static final long serialVersionUID = 1L;

	public UnprocessableEntityException() {
		this.setCode("422");
		this.setMessage("Unprocessable Entity");
		this.setStatus(HttpStatus.UNPROCESSABLE_ENTITY);
	}

	public UnprocessableEntityException(String message) {
		this.setCode("422");
		this.setMessage(message);
		this.setStatus(HttpStatus.UNPROCESSABLE_ENTITY);
	}

	public UnprocessableEntityException(String message, String code) {
		this.setCode(code);
		this.setMessage(message);
		this.setStatus(HttpStatus.UNPROCESSABLE_ENTITY);
	}
}