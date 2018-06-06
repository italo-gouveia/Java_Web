package br.com.italo.springrest.exception;

public class IdNaoValidoServiceException extends RuntimeException {
	 
    public IdNaoValidoServiceException(String message) {
        super(message);
    }
}