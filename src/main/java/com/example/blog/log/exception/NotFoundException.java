package com.example.blog.log.exception;


import org.springframework.http.HttpStatus;

/* 
* The 404 (Not Found) status code indicates that the origin server did
* not find a current representation for the target resource or is not
* willing to disclose that one exists.  A 404 status code does not
* indicate whether this lack of representation is temporary or
* permanent.
*/
public class NotFoundException extends BaseException {
	
	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		this.setCode("404");
		this.setMessage("Not Found");
		this.setStatus(HttpStatus.NOT_FOUND);
	}

	public NotFoundException(String field) {
		this.setCode("404");
		this.setMessage(field + " is Not Found");
		this.setStatus(HttpStatus.NOT_FOUND);
	}

	public NotFoundException(String message, String code) {
		this.setCode(code);
		this.setMessage(message);
		this.setStatus(HttpStatus.NOT_FOUND);
	}
}