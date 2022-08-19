package SeaBattle;

import SeaBattle.Exceptions.BadCoordsException;
import SeaBattle.Exceptions.BadInputDataException;
import SeaBattle.Ship.Ship;
import SeaBattle.Ship.SizeDecks;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FieldPlaying {

    private static final int SIZE_FIELD = 10;
    private static final int MAX_VERTICAL_INDEX = 9;
    private static final int MIN_VERTICAL_INDEX = 0;
    private static final int COUNT_SHIP = 10;
    public int counter_ships = 0;

    public static List<Character> horizontal_coords =
            new ArrayList<>(Arrays.asList('А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'К'));

    private final Cell [][] field = new Cell [SIZE_FIELD][SIZE_FIELD];

    private final List<Ship> ships = new ArrayList<>(COUNT_SHIP);

    public FieldPlaying () {
        for (int i = 0; i < SIZE_FIELD; ++i) {
            for (int j = 0; j < SIZE_FIELD; ++j) {
                field[i][j] = new Cell();
            }
        }
    }

    public void setAllVisible(Visibility visibility) {
        for (var field_mas : field) {
            for (var field : field_mas) {
                field.setVisibility(visibility);
            }
        }
    }

    public void addSymbol (Coords coords, Symbol symbol) {
        int horizontal_index = horizontal_coords.indexOf(coords.getHorizontal());
        if (horizontal_index == -1) {
            return;
        }
        field[coords.getVertical() - 1][horizontal_index].setSymbol(symbol);
        field[coords.getVertical() - 1][horizontal_index].setVisibility(Visibility.VISIBLE);
    }

    public void addShip (SizeDecks numberDecks, String str_coords) throws BadInputDataException {
        Ship ship = new Ship(numberDecks, str_coords);
        for(Coords coords : ship.getCoords_list()) {
            int horizontal_crd = horizontal_coords.indexOf(coords.getHorizontal()); // Правильность координаты проверена ранее
            Symbol symbol = field[coords.getVertical() - 1][horizontal_crd].getSymbol();
            if (!symbol.equals(Symbol.EMPTY_FIELD)) {
                throw new BadCoordsException();
            }
            addSymbol(coords, Symbol.SHIP);
        }
        ships.add(counter_ships++, ship);
        addUnavailable(ship);
    }

    public void addUnavailable(@NotNull Ship ship) {
        ship.getCoords_list().forEach(this::addUnavailableField);
    }

    private void addUnavailableField(@NotNull Coords coords) {
        addSymbolsUnavailable(coords.getVertical() - 2, horizontal_coords.indexOf(coords.getHorizontal()) - 1);
        addSymbolsUnavailable(coords.getVertical() - 1, horizontal_coords.indexOf(coords.getHorizontal()) - 1);
        addSymbolsUnavailable(coords.getVertical(), horizontal_coords.indexOf(coords.getHorizontal()) - 1);
        addSymbolsUnavailable(coords.getVertical(), horizontal_coords.indexOf(coords.getHorizontal()));
        addSymbolsUnavailable(coords.getVertical() - 2, horizontal_coords.indexOf(coords.getHorizontal()));
        addSymbolsUnavailable(coords.getVertical() - 2, horizontal_coords.indexOf(coords.getHorizontal()) + 1);
        addSymbolsUnavailable(coords.getVertical() - 1, horizontal_coords.indexOf(coords.getHorizontal()) + 1);
        addSymbolsUnavailable(coords.getVertical(), horizontal_coords.indexOf(coords.getHorizontal()) + 1);
    }

    private void addSymbolsUnavailable(int index1, int index2) {
        if (index1 < MIN_VERTICAL_INDEX || index1 > MAX_VERTICAL_INDEX ||
                index2 < MIN_VERTICAL_INDEX || index2 > MAX_VERTICAL_INDEX) {
            return;
        }
        if (field[index1][index2].getSymbol() == Symbol.UNAVAILABLE_FIELD) {
            field[index1][index2].setVisibility(Visibility.VISIBLE);
            return;
        }
        if (field[index1][index2].getSymbol() != Symbol.EMPTY_FIELD) return;
        field[index1][index2].setSymbol(Symbol.UNAVAILABLE_FIELD);
    }

    public Optional<Ship> findShot(Coords coords_shot) {
        return  ships.stream()
                .filter(x -> x.getCoords_list()
                .contains(coords_shot))
                .findAny();
    }

    public boolean eraseShip(Ship ship) {
        ships.remove(ship);
        return ships.isEmpty();
    }

    public void print() {
        System.out.print("   ");
        printHorizontalCoords();
        System.out.println();
        for (int i = 0; i < SIZE_FIELD; i++) {
            String add_space = (i == SIZE_FIELD - 1) ? " " : "  "; // Для ровного отображения координат по вертикали
            System.out.print((i + 1) + add_space);
            for (int j = 0; j < SIZE_FIELD; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void doublePrint(FieldPlaying field1, FieldPlaying field2) {
        final String space = "   ";
        System.out.print(space);
        printHorizontalCoords();
        System.out.print(space + space); // Пропуск между полями
        printHorizontalCoords();
        System.out.println();
        for (int i = 0; i < SIZE_FIELD; i++) {
            String add_space = (i == SIZE_FIELD - 1) ? " " : "  "; // Для ровного отображения координат по вертикали
            System.out.print((i + 1) + add_space);
            field1.printRow(i);
            System.out.print(space); // Пропуск между полями
            System.out.print((i + 1) + add_space);
            field2.printRow(i);
            System.out.println();
        }
    }

    private void printRow(int i) {
        for (int j = 0; j < SIZE_FIELD; j++) {
            if (field[i][j].getVisibility() == Visibility.INVISIBLE) System.out.print(Symbol.EMPTY_FIELD + " ");
            else System.out.print(field[i][j] + " ");
        }
    }

    static void  printHorizontalCoords () {
        for (char coords : horizontal_coords) {
            // За символами Юникода пробелы, для правильного отображения на любой ОС
            System.out.print(coords + "\u2002\u2004");
        }
    }

    public enum Symbol {

        EMPTY_FIELD("\u2B1C"),       // Пустое поле
        UNAVAILABLE_FIELD("\u2B1B"), // Недоступное поле
        SHIP("\u26F5"),              // Корабль
        HIT("\uD83D\uDD25"),         // Попадание
        MISS("\u274C");             // Промах

        private final String unicode;

        Symbol(String unicode) {
            this.unicode = unicode;
        }

        @Override
        public String toString() {
            return this.unicode;
        }
    }

    private static class Cell {
        Symbol symbol;
        Visibility visibility;

        public Cell() {
            this.symbol = Symbol.EMPTY_FIELD;
            this.visibility = Visibility.INVISIBLE;
        }

        public Symbol getSymbol() {
            return symbol;
        }

        public void setSymbol(Symbol symbol) {
            this.symbol = symbol;
        }

        public Visibility getVisibility() {
            return visibility;
        }

        public void setVisibility(Visibility visibility) {
            this.visibility = visibility;
        }

        @Override
        public String toString() {
            return symbol.toString();
        }
    }

    public enum Visibility {
        VISIBLE,
        INVISIBLE
    }

}

