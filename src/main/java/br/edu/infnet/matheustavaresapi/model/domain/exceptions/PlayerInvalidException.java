package br.edu.infnet.matheustavaresapi.model.domain.exceptions;

public class PlayerInvalidException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public PlayerInvalidException(String message){
        super(message);
    }
}
