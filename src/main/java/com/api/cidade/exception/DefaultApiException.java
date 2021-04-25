package com.api.cidade.exception;

import org.springframework.http.HttpStatus;

public class DefaultApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private HttpStatus status;

	public DefaultApiException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public DefaultApiException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }
	
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	
	
}
