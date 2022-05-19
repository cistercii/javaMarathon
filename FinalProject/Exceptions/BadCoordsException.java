package FinalProject.Exceptions;

public class BadCoordsException extends BadInputDataException {

    public BadCoordsException() {
        super("Недопустимые координаты корабля");
    }
}
