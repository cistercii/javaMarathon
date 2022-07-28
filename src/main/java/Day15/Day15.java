package Day15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.jar.Attributes;

public class Day15 {

    public static void solution() throws NumberFormatException{
        final String inputFilename  = "Day15/shoes.csv";
        final String outputFilename = "Day15/missing_shoes.txt";
        File file = new File(inputFilename);
        List<Shoe> outOfStock = new ArrayList<>();
        try (Scanner scan = new Scanner(file)){
            scan.nextLine();
            while (scan.hasNextLine()) {
                String current_string = scan.nextLine();
                String [] str = current_string.split(";");
                Shoe shoe = new Shoe(
                        str[NameColumn.NAME.ordinal()].trim(),
                        Integer.parseInt(str[NameColumn.SIZE.ordinal()].trim()),
                        Integer.parseInt(str[NameColumn.COUNT.ordinal()].trim()));
                if (shoe.getCount() == 0) {
                    outOfStock.add(shoe);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (Writer writer = new FileWriter(new File(outputFilename))) {
            for (Shoe shoe : outOfStock) {
                writer.write(shoe.getName() + ", " + shoe.getSize() + ", " + shoe.getCount() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    enum NameColumn {
        NAME, SIZE, COUNT
    }
}
