package SeaBattle.Players;

import SeaBattle.Exceptions.BadInputDataException;
import SeaBattle.FieldPlaying;
import SeaBattle.Game;
import SeaBattle.Ship.SizeDecks;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class HumanPlayerTest {

    static Player testPlayer = new HumanPlayer();

    @BeforeClass
    public static void createFieldPlaying() throws BadInputDataException {
        FieldPlaying field = testPlayer.getField();
        field.addShip(SizeDecks.FOUR_DECKS, "А,1;А,2;А,3;А,4");
        field.addShip(SizeDecks.TWO_DECKS, "В,1;В,2");
    }

    @Test
    public void testMiss() throws Exception {
        String string = "А,6";
        InputStream is = new ByteArrayInputStream(string.getBytes());
        System.setIn(is);

        Game.StatusGame status = testPlayer.oneShot(testPlayer);
        Assert.assertEquals(Game.StatusGame.NEXT_PLAYER_MOVE, status);
    }

    @Test
    public void testHit() throws BadInputDataException {
        String string = "А,3";

        InputStream is = new ByteArrayInputStream(string.getBytes());
        System.setIn(is);

        Game.StatusGame status = testPlayer.oneShot(testPlayer);
        Assert.assertEquals(Game.StatusGame.CURRENT_PLAYER_MOVE, status);
    }

    @Test
    public void testDestructionShip() throws BadInputDataException {
        String string = "В,1";
        InputStream is = new ByteArrayInputStream(string.getBytes());
        System.setIn(is);
        testPlayer.oneShot(testPlayer);

        string = "В,2";
        is = new ByteArrayInputStream(string.getBytes());
        System.setIn(is);

        Game.StatusGame status = testPlayer.oneShot(testPlayer);
        Assert.assertEquals(Game.StatusGame.CURRENT_PLAYER_MOVE, status);
    }
}