package SeaBattle;

import SeaBattle.Exceptions.BadCoordsException;
import SeaBattle.Exceptions.BadInputDataException;
import SeaBattle.Ship.Ship;
import SeaBattle.Ship.SizeDecks;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Optional;

public class FieldPlayingTest {

    static FieldPlaying field;

    @BeforeClass
    public static void addField() {
        field = new FieldPlaying();
    }

    @Test(expected = BadCoordsException.class)
    public void testAddingShipToInvalidCells() throws BadInputDataException {
        field.addShip(SizeDecks.ONE_DECK, "Б, 9");
        field.addShip(SizeDecks.ONE_DECK, "А, 10");
    }

    @Test
    public void findShot() throws BadInputDataException {
        field.addShip(SizeDecks.TWO_DECKS, "Г,5;Г,6");

        Optional<Ship> test = field.findShot(new Coords("Г,5"));
        Assert.assertTrue(test.isPresent());

        test = field.findShot(new Coords("В,5"));
        Assert.assertTrue(test.isEmpty());
    }
}