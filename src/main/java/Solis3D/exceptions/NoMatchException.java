package Solis3D.exceptions;

public class NoMatchException extends RuntimeException{
    public NoMatchException(long id) {
        super("L'elemento con id" + id + "non è stato trovato!");
    }
}
