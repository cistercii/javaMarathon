package FinalProject;

import FinalProject.Exceptions.BadCoordsException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coords {

    private static final int MIN_VERTICAL_NUMBER = 1;
    private static final int MAX_VERTICAL_NUMBER = 10;
    private final char horizontal;
    private final int vertical;

    public Coords(String one_pair_coords) throws BadCoordsException {
        one_pair_coords = one_pair_coords.replaceAll(" ", "").toUpperCase();
        Pattern pattern = Pattern.compile("([А-ИК]),(10|[1-9])");
        if (!one_pair_coords.matches(pattern.toString())) throw new BadCoordsException();
        Matcher matcher = pattern.matcher(one_pair_coords);
        matcher.find();

        this.horizontal = matcher.group(1).charAt(0);
        this.vertical = Integer.parseInt(matcher.group(2));
    }
    // Для тестов
    public Coords(char horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
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
