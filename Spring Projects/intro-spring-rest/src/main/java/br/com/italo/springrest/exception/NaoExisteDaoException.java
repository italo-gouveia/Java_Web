package br.com.italo.springrest.exception;

public class NaoExisteDaoException extends RuntimeException {
	 
    public NaoExisteDaoException(String message) {
        super(message);
    }
}