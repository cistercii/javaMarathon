package SeaBattle.Ship;

import SeaBattle.Coords;
import SeaBattle.Exceptions.BadCoordsException;
import SeaBattle.Exceptions.BadFormatException;
import SeaBattle.Exceptions.BadInputDataException;
import SeaBattle.FieldPlaying;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ship {

    private final SizeDecks size_decks;
    private List<Coords> coords_list;
    private final ShipType type;
    private int intact_decks;

    public Ship(@NotNull SizeDecks decks, @NotNull String str) throws BadInputDataException {
        this.size_decks = decks;
        this.intact_decks = decks.getSize();
        this.coords_list = new ArrayList<>(size_decks.getSize());
        if (!checkStringAndFillCoords(str)) throw new BadFormatException();
        this.type = definitionShipType();
        if (!isValid()) throw new BadCoordsException.BadShipCoords();
    }

    // Проверка на соответствие формату (x1,y1;x2,y2;... и тд)
    private boolean checkStringAndFillCoords(String str) throws BadInputDataException {
        String [] str_coords = str.split(";");
        if (str_coords.length != size_decks.getSize()) return false;
        for (String one_pair_coords : str_coords) {
            coords_list.add(new Coords(one_pair_coords));
        }
        return true;
    }

    private ShipType definitionShipType() {
        if (size_decks == SizeDecks.ONE_DECK) return ShipType.NONE;
        boolean isHorizontal = false;
        boolean isVertical = false;

        for (int i = 0; i < coords_list.size() - 1; ++i) {
            for (int j = i + 1; j < coords_list.size(); j++) {
                if (coords_list.get(i).getHorizontal() == coords_list.get(j).getHorizontal()) isVertical = true;
                else if (coords_list.get(i).getVertical() == coords_list.get(j).getVertical()) isHorizontal = true;
                else return ShipType.NONE;
                if (isHorizontal && isVertical) return ShipType.NONE;
            }
        }
        return isHorizontal ? ShipType.HORIZONTAL : ShipType.VERTICAL;
    }

    private boolean isValid() {
        if (size_decks == SizeDecks.ONE_DECK) return true;

        if (type == ShipType.NONE) return false;

        Comparator<Coords> comparator = type == ShipType.HORIZONTAL ? Comparator.comparingInt(Coords::getHorizontal) :
                                                                      Comparator.comparingInt(Coords::getVertical);
        coords_list = coords_list.stream().sorted(comparator).collect(Collectors.toList());
        return isContinuity();
    }

    private boolean isContinuity() {
        return type == ShipType.HORIZONTAL ? isHorizontalContinuity() : isVerticalContinuity();
    }
    // Проверяем чтобы координаты были соседними по горизонтали
    private boolean isHorizontalContinuity() {
        for (int i = 0; i < coords_list.size() - 1; i++) {
            int index1 = FieldPlaying.horizontal_coords.indexOf(coords_list.get(i).getHorizontal());
            int index2 = FieldPlaying.horizontal_coords.indexOf(coords_list.get(i + 1).getHorizontal());
            if (index1 != index2 - 1) return false;
        }
        return true;
    }
    private boolean isVerticalContinuity() {
        for (int i = 0; i < coords_list.size() - 1; i++) {
            if (coords_list.get(i).getVertical() != coords_list.get(i + 1).getVertical() - 1) return false;
        }
        return true;
    }

    public ShipType getType() {
        return type;
    }

    public List<Coords> getCoords_list() {
        return coords_list;
    }

    public int getIntact_decks() {
        return intact_decks;
    }

    public void hit() {
        intact_decks--;
    }
}
