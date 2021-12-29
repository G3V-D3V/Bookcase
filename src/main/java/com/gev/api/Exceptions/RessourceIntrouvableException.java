package com.gev.api.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RessourceIntrouvableException extends RuntimeException {

	private static final long serialVersionUID = 4085830553730058108L;

	public RessourceIntrouvableException(String string) {
		super(string);
	}

}
