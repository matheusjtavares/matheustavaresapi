package br.edu.infnet.matheustavaresapi.model.domain.exceptions;

public class GameCopyNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public GameCopyNotFoundException(String message){
        super(message);
    }
}
