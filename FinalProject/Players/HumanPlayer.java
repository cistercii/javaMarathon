package FinalProject.Players;

import FinalProject.Coords;
import FinalProject.Exceptions.BadInputDataException;
import FinalProject.FieldPlaying;
import FinalProject.Game;
import FinalProject.Ship.Ship;
import FinalProject.Ship.SizeDecks;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HumanPlayer extends Player {
    @Override
    public void fillYourselfField() {
        Scanner scan = new Scanner(System.in);
        for (SizeDecks ship_group : SizeDecks.values()) { // По кол-ву палуб
            for (int i = 0; i < ship_group.getCount_ships(); i++) { // По кол-ву кораблей
                do {
                    getYourself_field().print();
                    System.out.println("Введите координаты корабля (формат x1,y1;...): " + ship_group.getName());
                    String str = scan.next();
                    try {
                        getYourself_field().addShip(ship_group, str);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
            }
        }
    }

    @Override
    public Game.StatusGame oneShot(@NotNull Player opponent) throws BadInputDataException {
        System.out.println("Ввведите координаты стрельбы (формат: x,y)");
        Scanner scan = new Scanner(System.in, StandardCharsets.UTF_8);
        Coords shot = new Coords(scan.next());
        Ship ship = opponent.yourself_field.findShot(shot);
        if (ship == null) {
            opponent_field.addSymbol(shot, FieldPlaying.Symbol.Miss);
            opponent.yourself_field.addSymbol(shot, FieldPlaying.Symbol.Miss);
        } else {
            ship.hit();
            opponent_field.addSymbol(shot, FieldPlaying.Symbol.Hit);
            opponent.yourself_field.addSymbol(shot, FieldPlaying.Symbol.Hit);
            System.out.println("Попадание!");
            if (ship.getIntact_decks() == 0) {
                System.out.println("Корабль потоплен!");
                opponent_field.addUnavailable(ship);
                return opponent.yourself_field.eraseShip(ship) ? Game.StatusGame.END_GAME : Game.StatusGame.CURRENT_PLAYER_MOVE;
            } else {
                return Game.StatusGame.CURRENT_PLAYER_MOVE;
            }
        }
        System.out.println("Промах!");
        return Game.StatusGame.NEXT_PLAYER_MOVE;
    }
}
