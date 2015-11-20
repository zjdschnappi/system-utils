package com.system.utils;

public class UserNoExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1456401980503361779L;

	public UserNoExistException() {
		super();
	}

	public UserNoExistException(String userName) {
		super(userName + "is not exist");
	}

}
