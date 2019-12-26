package com.day11.session2.assignment;

public class NotSufficientStockException extends Exception{
	private static final long serialVersionUID = 1L;

	public NotSufficientStockException(String message){
		super(message);
	}
}
