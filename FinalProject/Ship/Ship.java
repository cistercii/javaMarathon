package FinalProject.Ship;

import FinalProject.Coords;
import FinalProject.Exceptions.BadCoordsException;
import FinalProject.Exceptions.BadFormatException;
import FinalProject.Exceptions.BadInputDataException;
import FinalProject.FieldPlaying;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ship {

    private final SizeDecks size_decks;
    private List<Coords> coords_list;
    private final ShipType type;
    private int intact_decks;

    public List<Coords> getCoords_list() {
        return coords_list;
    }

    public Ship(@NotNull SizeDecks decks, @NotNull String str) throws BadInputDataException {
        this.size_decks = decks;
        this.intact_decks = decks.getSize();
        this.coords_list = new ArrayList<>(size_decks.getSize());
        if (!checkStringAndFillCoords(str)) throw new BadFormatException();
        this.type = definitionShipType();
        if (!isValid()) throw new BadCoordsException();
    }

    private boolean isValid() {
        if (size_decks == SizeDecks.OneDeck) return true;

        if (type == ShipType.None) return false;

        Comparator<Coords> comparator = type == ShipType.Horizontal ? Comparator.comparingInt(Coords::getHorizontal) :
                                                                      Comparator.comparingInt(Coords::getVertical);
        coords_list = coords_list.stream().sorted(comparator).collect(Collectors.toList());
        return isContinuity();
    }

    private ShipType definitionShipType() {
        if (size_decks == SizeDecks.OneDeck) return ShipType.None;
        boolean isHorizontal = false;
        boolean isVertical = false;
        
        for (int i = 0; i < coords_list.size() - 1; ++i) {
            for (int j = i + 1; j < coords_list.size(); j++) {
                if (coords_list.get(i).getHorizontal() == coords_list.get(j).getHorizontal()) isVertical = true;
                else if (coords_list.get(i).getVertical() == coords_list.get(j).getVertical()) isHorizontal = true;
                else return ShipType.None;
                if (isHorizontal && isVertical) return ShipType.None;
            }
        }
        return isHorizontal ? ShipType.Horizontal : ShipType.Vertical;
    }
    private boolean isContinuity() {
        return type == ShipType.Horizontal ? isHorizontalContinuity() : isVerticalContinuity();
    }
    // ?????????????????? ?????????? ???????????????????? ???????? ?????????????????? ???? ??????????????????????
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

    // ???????????????? ???? ???????????????????????? ?????????????? (x1,y1;x2,y2;... ?? ????)
    private boolean checkStringAndFillCoords(String str) throws BadInputDataException {
        str = str.replaceAll(" ", "").toUpperCase();
        String [] str_coords = str.split(";");
        if (str_coords.length != size_decks.getSize()) return false;
        for (String one_pair_coords : str_coords) {
            coords_list.add(new Coords(one_pair_coords));
        }
        return true;
    }

    public ShipType getType() {
        return type;
    }

    public int getIntact_decks() {
        return intact_decks;
    }

    public void hit() {
        intact_decks--;
    }
}
