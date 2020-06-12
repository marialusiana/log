package com.example.blog.log.exception;


import org.springframework.http.HttpStatus;

/* 
* The 409 (Conflict) status code indicates that the request could not
* be completed due to a conflict with the current state of the target
* resource.  This code is used in situations where the user might be
* able to resolve the conflict and resubmit the request.  The server
* SHOULD generate a payload that includes enough information for a user
* to recognize the source of the conflict. 
*/
public class ConflictException extends BaseException {
	
	private static final long serialVersionUID = 1L;

	public ConflictException() {
		this.setCode("409");
		this.setMessage("Conflict");
		this.setStatus(HttpStatus.CONFLICT);
	}

	public ConflictException(String message) {
		this.setCode("409");
		this.setMessage(message);
		this.setStatus(HttpStatus.CONFLICT);
	}

	public ConflictException(String message, String code) {
		this.setCode(code);
		this.setMessage(message);
		this.setStatus(HttpStatus.CONFLICT);
	}

    public ConflictException(String message, String code, Object object) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(object);
		this.setStatus(HttpStatus.CONFLICT);
    }
}