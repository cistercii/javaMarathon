package FinalProject;

import FinalProject.Exceptions.BadCoordsException;
import FinalProject.Exceptions.BadFormatException;
import FinalProject.Exceptions.BadInputDataException;
import FinalProject.Ship.Ship;
import FinalProject.Ship.ShipType;
import FinalProject.Ship.SizeDecks;
import org.jetbrains.annotations.NotNull;

import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FieldPlaying {

    private static final int SIZE_FIELD = 10;
    private static final int MAX_VERTICAL_INDEX = 9;
    private static final int MIN_VERTICAL_INDEX = 0;
    private static final int COUNT_SHIP = 10;
    public int counter_ships = 0;

    private static final FieldPlaying empty_field = new FieldPlaying();

    public static FieldPlaying getEmpty() {
        return empty_field;
    }

    public static List<Character> horizontal_coords =
            new ArrayList<>(Arrays.asList('А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'К'));

    private final Symbol [][] field = new Symbol [SIZE_FIELD][SIZE_FIELD];

    private final List<Ship> ships = new ArrayList<>(COUNT_SHIP);

    public FieldPlaying() {
        for (int i = 0; i < SIZE_FIELD; i++) {
            for (int j = 0; j < SIZE_FIELD; j++) {
                field[i][j] = Symbol.EmptyField;
            }
        }
    }

    public void addSymbol (Coords coords, Symbol symbol) {
        int horizontal_index = horizontal_coords.indexOf(coords.getHorizontal());
        if (horizontal_index == -1) {
            return;
        }
        field[coords.getVertical() - 1][horizontal_index] = symbol;
    }

    public void addShip (SizeDecks numberDecks, String str_coords) throws BadInputDataException {
        Ship ship = new Ship(numberDecks, str_coords);
        for(Coords coords : ship.getCoords_list()) {
            int horizontal_crd = horizontal_coords.indexOf(coords.getHorizontal()); // Правильность координаты проверена ранее
            if (field[coords.getVertical() - 1][horizontal_crd]
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
        if (field[index1][index2] != Symbol.EmptyField) return;
        field[index1][index2] = Symbol.UnavailableField;
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
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    public static void doublePrint(FieldPlaying field1, FieldPlaying field2) {
        final String space = "     ";
        System.out.print("   ");
        printHorizontalCoords();
        System.out.print(space); // Пропуск между полями
        System.out.print("   ");
        printHorizontalCoords();
        System.out.println();
        for (int i = 0; i < SIZE_FIELD; i++) {
            String add_space = (i == SIZE_FIELD - 1) ? " " : "  "; // Для ровного отображения координат по вертикали
            System.out.print((i + 1) + add_space);
            field1.printRow(i);
            System.out.print(space);
            System.out.print((i + 1) + add_space);
            field2.printRow(i);
            System.out.println();
        }
    }

    private void printRow(int i) {
        for (int j = 0; j < SIZE_FIELD; j++) {
            //PrintStream printStream = new PrintStream(System.out, true, StandardCharsets.UTF_8);
            //printStream.print(field[i][j] + " ");
            System.out.print(field[i][j] + " ");
        }
    }

    static void  printHorizontalCoords () {
        for (char coords : horizontal_coords) {
            //PrintStream printStream = new PrintStream(System.out, true, Charset.defaultCharset());
            //printStream.print(coords + "  ");
            System.out.print(coords + "  ");
        }
    }



}
