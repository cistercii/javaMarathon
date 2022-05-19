package FinalProject;

import FinalProject.Exceptions.BadInputDataException;
import FinalProject.Players.Player;

import java.io.IOException;
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
        player1.fillYourselfField();
        FieldPlaying.doublePrint(player1.getYourself_field(), player1.getOpponent_field());
        System.out.println("Корабли игрока 1 расположены\n");
        print_next_move();
        System.out.println("Игрок 2 расставляет корабли");
        player2.fillYourselfField();
        FieldPlaying.doublePrint(player2.getYourself_field(), player2.getOpponent_field());
        System.out.println("Корабли игрока 2 расположены\n");
        print_next_move();
    }

    private void sleep (long sec) {
        try {
            TimeUnit.SECONDS.sleep(sec); // Ждем секунду для эффекта
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private int first_move () {
        Random random = new Random();
        int first = random.nextInt(2) + 1; // Случайное число 1 или 2
        System.out.println("Определяется кто будет делать первый ход!");
        sleep(1);
        System.out.println("Ходить первым будет игрок под номером " + first);
        sleep(1);
        return first;
    }

    public void game_process () throws IOException {
        FieldPlaying.doublePrint(FieldPlaying.getEmpty(), FieldPlaying.getEmpty());
        int current_player_number = first_move();
        int i = 0;
        Status_game status = Status_game.NEXT_PLAYER_MOVE;
        while (true) {
            Player current = current_player_number == 1 ? player1 : player2;
            System.out.println("Ходит игрок номер " + current_player_number);
            print_next_move();
            shift_console();
            do {
                FieldPlaying.doublePrint(current.getYourself_field(), current.getOpponent_field());
                status = nextMove(current_player_number);
            } while (status == Status_game.CURRENT_PLAYER_MOVE);
            if (status == Status_game.END_GAME) break;
            FieldPlaying.doublePrint(current.getYourself_field(), current.getOpponent_field());
            print_next_move();
            FieldPlaying.doublePrint(FieldPlaying.getEmpty(), FieldPlaying.getEmpty());
            current_player_number = current_player_number % 2 + 1;
        }
        FieldPlaying.doublePrint(player1.getYourself_field(), player2.getYourself_field());
        System.out.println("Игра окончена! Игрок " + current_player_number + " победил");
    }

    private Status_game nextMove (int current_player) {
        Status_game status;
        do {
            try {
                if (current_player == 1) {
                    status = player1.oneShot(player2);
                } else {
                    status = player2.oneShot(player1);
                }
            } catch (BadInputDataException e) {
                System.out.println(e.getMessage());
                status = Status_game.ERROR_COORDS;
            }
            break;
        } while(status == Status_game.ERROR_COORDS);
        return status;
    }

    private void print_next_move() {
        System.out.println("Для передачи хода нажмите Enter");
        Scanner scan = new Scanner(System.in, StandardCharsets.UTF_8);
        scan.nextLine();
    }

    private void shift_console() {
        System.out.println("\n\n");
        System.out.flush();
    }
}
