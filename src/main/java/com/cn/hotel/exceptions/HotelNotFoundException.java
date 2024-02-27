package com.cn.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class HotelNotFoundException extends RuntimeException {

	

	public HotelNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

	
	
	
	
}
