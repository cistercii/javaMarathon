package FinalProject.Players;

import FinalProject.Exceptions.BadInputDataException;
import FinalProject.FieldPlaying;
import FinalProject.Game;

public abstract class Player {

    protected final FieldPlaying field = new FieldPlaying();

    abstract public void fillField();

    abstract public Game.StatusGame oneShot(Player opponent) throws BadInputDataException;

    public FieldPlaying getField() {
        return field;
    }
}
