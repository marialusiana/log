package com.example.blog.log.configuration.rpc;


import javax.servlet.http.HttpServletRequest;

import com.example.blog.log.dto.response.BaseResponse;
import com.example.blog.log.exception.BaseException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ErrorExceptionHandler {

	@ExceptionHandler({ RuntimeException.class })
	public ResponseEntity<Object> handleRuntimeException (Exception ex, WebRequest request) {
		BaseResponse<Object> response = new BaseResponse<Object>();
		response.setStatus(false);
		response.setMessage("Interval Server Error");
		response.setCode("500");
		response.setMessage(ex.getMessage());

		
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		if (ex instanceof BaseException) {
			BaseException exc = (BaseException) ex;
			response.setCode(exc.getCode());
			response.setMessage(exc.getMessage());
			if (exc.getData() != null) {
				response.setData(exc.getData());
			}

			status = exc.getStatus();
		} 

		return new ResponseEntity<>(response, status);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
    public @ResponseBody String handleNoMethodException(HttpServletRequest request, NoHandlerFoundException ex) {
        return ex.getMessage();
    }
}