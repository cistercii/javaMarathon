package FinalProject.Players;

import FinalProject.Exceptions.BadInputDataException;
import FinalProject.FieldPlaying;
import FinalProject.Game;

public abstract class Player {

    protected final FieldPlaying yourself_field = new FieldPlaying();
    protected final FieldPlaying opponent_field = new FieldPlaying();

    abstract public void fillYourselfField();

    abstract public Game.StatusGame oneShot(Player opponent) throws BadInputDataException;

    public FieldPlaying getYourself_field() {
        return yourself_field;
    }

    public FieldPlaying getOpponent_field() {
        return opponent_field;
    }
}
