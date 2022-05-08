package FinalProject.Ship;

import FinalProject.BadFormatException;
import FinalProject.Coords;
import FinalProject.FieldPlaying;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final int COUNT_DECKS;
    private List<Coords> coords_list;

    public List<Coords> getCoords_list() {
        return coords_list;
    }

    public Ship(@NotNull SizeDecks decks, @NotNull String str) throws BadFormatException {
        this.COUNT_DECKS = decks.ordinal() + 1;
        this.coords_list = new ArrayList<>(COUNT_DECKS);
        if (!checkStringAndFillCoords(str)) throw new BadFormatException("Неверный формат строки");

    }

    private boolean isValid() {
        if (!checkOneCell()) return false;
        for (int i = 0; i < COUNT_DECKS - 1; ++i) {
            for (int j = i; j < COUNT_DECKS; j++) {
                //if ()
            }
        }
        return true;
    }

    private boolean checkOneCell () {
        for (int i = 0; i < COUNT_DECKS - 1; ++i) {
            for (int j = i; j < COUNT_DECKS; j++) {

            }
        }
        return true;
    }

    // Проверка на соответствие формату (x1,y1;x2,y2 и тд)
    // chars[0] и chars[2] соответсвующие координаты
    private boolean checkStringAndFillCoords(String str) {
        str = str.replaceAll(" ", "").toUpperCase();
        String [] str_coords = str.split(";");
        if (str_coords.length != COUNT_DECKS) return false;
        for (String one_pair_coords : str_coords) {
            if (!isValidCoords(one_pair_coords)) return false;
        }
        return true;
    }

    private boolean isValidCoords(@NotNull String one_pair_coords) {
        String [] strings = one_pair_coords.split(",");
        char horizontal = strings[0].charAt(0);
        int vertical_number = Integer.parseInt(strings[1]);
        if (!FieldPlaying.horizontal_coords.contains(horizontal)) return false;
        if ( vertical_number < FieldPlaying.MIN_VERTICAL_NUMBER || vertical_number > FieldPlaying.MAX_VERTICAL_NUMBER) return false;
        coords_list.add(new Coords(horizontal, vertical_number));
        return true;
    }

    enum ShipType {
        Horizontal,
        Vertical;
    }
}
