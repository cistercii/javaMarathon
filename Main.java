import FinalProject.FieldPlaying;
import FinalProject.Game;
import FinalProject.Players.HumanPlayer;
import FinalProject.Players.Player;
import FinalProject.Ship.SizeDecks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main (String [] args) throws IOException {
        Player player1 = new HumanPlayer();
        Player player2 = new HumanPlayer();
        Game game = new Game(player1, player2);
        game.start();
        game.game_process();
    }
}
