package SeaBattle.Players;

import SeaBattle.Game;

// TODO Потом нужно будет запилить, сейчас нету
public class AIPlayer extends Player {
    @Override
    public void fillField() {

    }

    @Override
    public Game.StatusGame oneShot(Player opponent) {
        return Game.StatusGame.END_GAME;
    }
}
