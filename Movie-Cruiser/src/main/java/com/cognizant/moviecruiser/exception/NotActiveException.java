package com.cognizant.moviecruiser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "All future or not active")
public class NotActiveException extends Exception{
public NotActiveException(String msg)
{
	super(msg);
}
public NotActiveException() {
	
}
}
