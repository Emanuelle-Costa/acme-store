package br.com.acme.application.domain.exception;

public class CardNotFoundException extends RuntimeException{
    public CardNotFoundException(Long id){

        super(String.format("Card with %d not found", id));
    }
}
