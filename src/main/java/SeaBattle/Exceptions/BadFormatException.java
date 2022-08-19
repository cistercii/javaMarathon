package SeaBattle.Exceptions;

public class BadFormatException extends BadInputDataException {
    public BadFormatException() {
        super("Неверный формат строки");
    }
}
