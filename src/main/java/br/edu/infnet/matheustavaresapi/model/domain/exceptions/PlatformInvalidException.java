package br.edu.infnet.matheustavaresapi.model.domain.exceptions;

public class PlatformInvalidException  extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public PlatformInvalidException(String message){
        super(message);
    }
}
