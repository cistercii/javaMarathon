package FinalProject;

import FinalProject.Exceptions.BadCoordsException;
import FinalProject.Exceptions.BadInputDataException;
import FinalProject.Ship.Ship;
import FinalProject.Ship.SizeDecks;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
            if (field[coords.getVertical() - 1][horizontal_crd].getSymbol()
                    .equals(Symbol.UnavailableField)) throw new BadCoordsException();
            addSymbol(coords, Symbol.Ship);
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
        if (field[index1][index2].getSymbol() == Symbol.UnavailableField) {
            field[index1][index2].setVisibility(Visibility.VISIBLE);
            return;
        }
        if (field[index1][index2].getSymbol() != Symbol.EmptyField) return;
        field[index1][index2].setSymbol(Symbol.UnavailableField);
    }

    public Ship findShot(Coords coords_shot) {
        List<Ship> target_ships = ships.stream()
                .filter(x -> x.getCoords_list().contains(coords_shot))
                .collect(Collectors.toList());
        return (target_ships.size() != 0) ? target_ships.get(0) : null;
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
            String add_space = (i == SIZE_FIELD - 1) ? " " : "  ";
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
            if (field[i][j].getVisibility() == Visibility.INVISIBLE) System.out.print(Symbol.EmptyField + " ");
            else System.out.print(field[i][j] + " ");
        }
    }

    static void  printHorizontalCoords () {
        for (char coords : horizontal_coords) {
            // За символами Юникода пробелы, для правильного отображения на любой ОС
            System.out.print(coords + "\u2002\u2004");
        }
    }

    public static enum Symbol {

        EmptyField("\u2B1C"),       // Пустое поле
        UnavailableField("\u2B1B"), // Недоступное поле
        Ship("\u26F5"),              // Корабль
        Hit("\uD83D\uDD25"),         // Попадание
        Miss("\u274C");             // Промах

        private final String unicode;

        private Symbol(String unicode) {
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
            this.symbol = Symbol.EmptyField;
            this.visibility = Visibility.INVISIBLE;
        }

        public Cell(Symbol symbol) {
            this.symbol = symbol;
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

