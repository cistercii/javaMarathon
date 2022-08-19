package SeaBattle.Players;

import SeaBattle.Exceptions.BadInputDataException;
import SeaBattle.FieldPlaying;
import SeaBattle.Game;

public abstract class Player {

    protected final FieldPlaying field = new FieldPlaying();

    abstract public void fillField();

    abstract public Game.StatusGame oneShot(Player opponent) throws BadInputDataException;

    public FieldPlaying getField() {
        return field;
    }
}
