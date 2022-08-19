package SeaBattle.Exceptions;

public class BadCoordsException extends BadInputDataException {

    public BadCoordsException() {
        super("Недопустимые координаты");
    }
    public BadCoordsException (String mes) {
        super(mes);
    }

    public static class BadShipCoords extends BadCoordsException {
        public BadShipCoords() {
            super("Корабль не может иметь такие координаты");
        }
    }
}
