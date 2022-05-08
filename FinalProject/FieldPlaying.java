package FinalProject;

import FinalProject.Ship.Ship;
import FinalProject.Ship.SizeDecks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FieldPlaying {

    private static final int SIZE_FIELD = 10;
    public static final int MAX_VERTICAL_NUMBER = 10;
    public static final int MIN_VERTICAL_NUMBER = 1;

    public static List<Character> horizontal_coords =
            new ArrayList<>(Arrays.asList('А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'К'));

    String [][] field = new String[SIZE_FIELD][SIZE_FIELD];

    public FieldPlaying() {
        for (int i = 0; i < SIZE_FIELD; i++) {
            for (int j = 0; j < SIZE_FIELD; j++) {
                field[i][j] = Symbol.EmptyField.toString() + ' ';
            }
        }
    }

    public boolean addSymbol (char horizontal, int vertical, Symbol symbol) {
        int horizontal_index = horizontal_coords.indexOf(horizontal);
        if (horizontal_index == -1 || vertical > MAX_VERTICAL_NUMBER || vertical < MIN_VERTICAL_NUMBER) {
            System.out.println("Еrror");
            return false;
        }
        field[vertical - 1][horizontal_index] = symbol.toString() + " ";
        return true;
    }

    public void addShip (SizeDecks numberDecks, String str_coords) throws BadFormatException {
        Ship ship = new Ship(numberDecks, str_coords);
        for(Coords coords : ship.getCoords_list()) {
            addSymbol(coords.getHorizontal(), coords.getVertical(), Symbol.Ship);
        }
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
            System.out.print(field[i][j]);
        }
    }

    static void  printHorizontalCoords () {
        for (char coords : horizontal_coords) {
            System.out.print(coords + "  ");
        }
    }

    enum ShipType {
        NoType,
        Horizontal,
        Vertical
    }

}
