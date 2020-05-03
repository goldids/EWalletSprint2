package com.cg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.userException.AddmoneyErrorMessage;
import com.cg.userException.AddmoneyServiceException;


@RestControllerAdvice
public class RestAdvice {
	@ExceptionHandler(value= {AddmoneyServiceException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public AddmoneyErrorMessage handleAddmoneyServiceException(AddmoneyServiceException ex)
	{
		return new AddmoneyErrorMessage(ex.getMessage());
	}
	
}
