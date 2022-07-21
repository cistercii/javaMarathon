package FinalProject;

import FinalProject.Exceptions.BadCoordsException;
import FinalProject.Exceptions.BadInputDataException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coords {

    private static final int MIN_VERTICAL_NUMBER = 1;
    private static final int MAX_VERTICAL_NUMBER = 10;
    private final char horizontal;
    private final int vertical;

    public Coords(String one_pair_coords) throws BadInputDataException {
        one_pair_coords = one_pair_coords.replaceAll(" ", "").toUpperCase();
        Pattern pattern = Pattern.compile("([А-ИК]),(10|[1-9])");
        if (!one_pair_coords.matches(pattern.toString())) throw new BadCoordsException();
        Matcher matcher = pattern.matcher(one_pair_coords);
        matcher.find();
        char horizontal = matcher.group(1).charAt(0);
        int vertical_number = Integer.parseInt(matcher.group(2));

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
