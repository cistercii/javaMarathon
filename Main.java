import FinalProject.BadFormatException;
import FinalProject.FieldPlaying;
import FinalProject.Ship.SizeDecks;

import java.io.FileNotFoundException;

public class Main {
    public static void main (String [] args) throws FileNotFoundException {
        FieldPlaying field1 = new FieldPlaying();
        FieldPlaying field2 = new FieldPlaying();
        String test = "А,10;А,10;В,1";
        do {
            try {
                field1.addShip(SizeDecks.ThreeDecks, test);
            } catch (BadFormatException e) {
                System.out.println("Недопустимый формат");
            }
            break;
        } while (true);
        FieldPlaying.doublePrint(field1, field2);
    }
}
