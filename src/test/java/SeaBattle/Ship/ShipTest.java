package SeaBattle.Ship;

import SeaBattle.Coords;
import SeaBattle.Exceptions.BadCoordsException;
import SeaBattle.Exceptions.BadFormatException;
import SeaBattle.Exceptions.BadInputDataException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ShipTest {

    @Test(expected = BadFormatException.class)
    public void constructorShouldSkipWrongCountDecks() throws BadInputDataException {
        Ship testShip = new Ship(SizeDecks.TWO_DECKS, "А,1;А,2;А,3");
    }

    @Test
    public void testCorrectTypeDefinition() throws BadInputDataException {
        Ship horizontalShip = new Ship(SizeDecks.THREE_DECKS, "В,5;Г,5;Д,5");
        Assert.assertEquals(ShipType.HORIZONTAL, horizontalShip.getType());

        Ship verticalShip = new Ship(SizeDecks.THREE_DECKS, "И,3;И,4;И,5");
        Assert.assertEquals(ShipType.VERTICAL, verticalShip.getType());
    }

    @Test(expected = BadCoordsException.BadShipCoords.class)
    public void constructorShouldSkipInvalidVerticalCoords() throws BadInputDataException {
        Ship testShip = new Ship(SizeDecks.THREE_DECKS, "Е,2;Е,3;Е,5");
    }

    @Test(expected = BadCoordsException.BadShipCoords.class)
    public void constructorShouldSkipInvalidHprizontalCoords() throws BadInputDataException {
        Ship testShip = new Ship(SizeDecks.THREE_DECKS, "Е,2;Ж,2;И,2");
    }

    @Test
    public void constructorShouldCorrectlyWorkingWithWrongOrder() throws BadInputDataException {
        Ship testShip = new Ship(SizeDecks.THREE_DECKS, "Б,1;Б,3;Б,2");
        List<Coords> correctList = List.of(new Coords("Б,1"), new Coords("Б,2"), new Coords("Б,3"));
        Assert.assertEquals(correctList, testShip.getCoords_list());
    }
}