import SeaBattle.Game;
import SeaBattle.Players.HumanPlayer;
import SeaBattle.Players.Player;

import java.io.IOException;

public class Main {
    public static void main (String [] args) throws IOException {
        Player player1 = new HumanPlayer();
        Player player2 = new HumanPlayer();
        Game game = new Game(player1, player2);
        game.start();
        game.gameProcess();
    }
}
