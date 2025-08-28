package br.edu.infnet.matheustavaresapi.model.domain.exceptions;

public class PlayerNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 2L;
    public PlayerNotFoundException(String message){
        super(message);
    }
}
