package pelicula.exceptions;

public class DatosObligatoriosException extends RuntimeException {
    public DatosObligatoriosException(String message) {
        super(message);
    }
}
