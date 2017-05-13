package me.cadox8.LoM.exceptions;

public class RegisteredChampionException extends RuntimeException {

    public RegisteredChampionException(){}

    public RegisteredChampionException(String msg){
        super(msg);
    }
}
