package com.glarimy.spring.api;

public class LibraryException extends Exception {

	public LibraryException() {
		super();
	}

	public LibraryException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public LibraryException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public LibraryException(String arg0) {
		super(arg0);
	}

	public LibraryException(Throwable arg0) {
		super(arg0);
	}

}
