package Solis3D.exceptions;

import java.util.UUID;

public class NoMatchException extends RuntimeException{
    public NoMatchException(UUID id) {
        super("L'elemento con id" + id + "non è stato trovato!");
    }
}
