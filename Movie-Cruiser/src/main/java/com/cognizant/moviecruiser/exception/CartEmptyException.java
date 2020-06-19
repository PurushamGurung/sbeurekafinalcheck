package com.cognizant.moviecruiser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Your Cart is Empty")
public class CartEmptyException extends Exception{

	public CartEmptyException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}
	public CartEmptyException() {}

}
