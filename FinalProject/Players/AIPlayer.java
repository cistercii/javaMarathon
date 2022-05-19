package FinalProject.Players;

import FinalProject.StatusGame;

// TODO Потом нужно будет запилить, сейчас нету
public class AIPlayer extends Player {
    @Override
    public void fillYourselfField() {

    }

    @Override
    public StatusGame oneShot(Player opponent) {
        return StatusGame.END_GAME;
    }
}
