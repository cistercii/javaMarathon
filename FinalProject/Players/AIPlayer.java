package FinalProject.Players;

import FinalProject.Status_game;

// TODO Потом нужно будет запилить, сейчас нету
public class AIPlayer extends Player {
    @Override
    public void fillYourselfField() {

    }

    @Override
    public Status_game oneShot(Player opponent) {
        return Status_game.END_GAME;
    }
}
