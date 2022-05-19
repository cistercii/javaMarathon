package FinalProject;

import FinalProject.Exceptions.BadCoordsException;
import FinalProject.Exceptions.BadFormatException;
import FinalProject.Exceptions.BadInputDataException;

public class Coords {

    private static final int MIN_VERTICAL_NUMBER = 1;
    private static final int MAX_VERTICAL_NUMBER = 10;
    private final char horizontal;
    private final int vertical;

    public Coords(String one_pair_coords) throws BadInputDataException {
        final int COUNT_COORDS = 2;
        String [] strings = one_pair_coords.toUpperCase().split(",");
        // Устранение ошибки, которая появилась при тестировании
        if (strings[0].length() != 1 || strings.length < COUNT_COORDS) throw new BadFormatException();
        char horizontal = strings[0].charAt(0);
        int vertical_number = Integer.parseInt(strings[1]);

        if (!FieldPlaying.horizontal_coords.contains(horizontal) ||
            vertical_number < MIN_VERTICAL_NUMBER || vertical_number > MAX_VERTICAL_NUMBER) throw new BadCoordsException();

        this.horizontal = horizontal;
        this.vertical = vertical_number;
    }

    public char getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coords coords = (Coords) o;

        if (horizontal != coords.horizontal) return false;
        return vertical == coords.vertical;
    }

    @Override
    public int hashCode() {
        int result = horizontal;
        result = 31 * result + vertical;
        return result;
    }
};
