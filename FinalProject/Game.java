package FinalProject;

import FinalProject.Exceptions.BadInputDataException;
import FinalProject.Players.Player;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    private final Player player1;
    private final Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        System.out.println("Игрок 1 расставляет корабли");
        player1.fillField();
        System.out.println("Корабли игрока 1 расположены\n");
        print_next_move();
        System.out.println("Игрок 2 расставляет корабли");
        player2.fillField();
        System.out.println("Корабли игрока 2 расположены\n");
        print_next_move();
    }

    private int first_move () {
        Random random = new Random();
        int first = random.nextInt(2) + 1; // Случайное число 1 или 2
        System.out.println("Определяется кто будет делать первый ход!");
        return first;
    }

    public void game_process () {
        int current_player_number = first_move();
        int i = 0;
        StatusGame status;
        while (true) {
            System.out.println("Ходит игрок номер " + current_player_number);
            do {
                FieldPlaying.doublePrint(player1.getField(), player2.getField());
                status = nextMove(current_player_number);
            } while (status == StatusGame.CURRENT_PLAYER_MOVE);
            if (status == StatusGame.END_GAME) break;
            current_player_number = current_player_number % 2 + 1;
        }
        player1.getField().setAllVisible(FieldPlaying.Visibility.VISIBLE);
        player2.getField().setAllVisible(FieldPlaying.Visibility.VISIBLE);
        FieldPlaying.doublePrint(player1.getField(), player2.getField());
        System.out.println("Игра окончена! Игрок " + current_player_number + " победил");
    }

    private Game.StatusGame nextMove (int current_player) {
        Game.StatusGame status;
        do {
            try {
                if (current_player == 1) {
                    status = player1.oneShot(player2);
                } else {
                    status = player2.oneShot(player1);
                }
            } catch (BadInputDataException e) {
                System.out.println(e.getMessage());
                status = StatusGame.ERROR_COORDS;
            }
        } while(status == StatusGame.ERROR_COORDS);
        return status;
    }

    private void print_next_move() {
        System.out.println("Для передачи хода нажмите Enter");
        Scanner scan = new Scanner(System.in, StandardCharsets.UTF_8);
        scan.nextLine();
    }

    public enum StatusGame {
        ERROR_COORDS,
        CURRENT_PLAYER_MOVE,
        NEXT_PLAYER_MOVE,
        END_GAME;
    }
}
