package FinalProject.Players;

import FinalProject.Coords;
import FinalProject.Exceptions.BadCoordsException;
import FinalProject.FieldPlaying;
import FinalProject.Game;
import FinalProject.Ship.Ship;
import FinalProject.Ship.SizeDecks;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.Scanner;

public class HumanPlayer extends Player {
    @Override
    public void fillField() {
        Scanner scan = new Scanner(System.in);
        for (SizeDecks ship_group : SizeDecks.values()) { // По кол-ву палуб
            for (int i = 0; i < ship_group.getCount_ships(); i++) { // По кол-ву кораблей
                do {
                    getField().print();
                    System.out.println("Введите координаты корабля (формат А,1;А,2...): " + ship_group.getName());
                    String str = scan.next();
                    try {
                        getField().addShip(ship_group, str);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
            }
        }
        getField().print();
        getField().setAllVisible(FieldPlaying.Visibility.INVISIBLE);
    }

    @Override
    public Game.StatusGame oneShot(@NotNull Player opponent) throws BadCoordsException {
        System.out.println("Ввведите координаты стрельбы (формат: А,1)");
        Scanner scan = new Scanner(System.in, StandardCharsets.UTF_8);
        Coords shot = new Coords(scan.next());
        Optional<Ship> ship = opponent.field.findShot(shot);
        if (ship.isEmpty()) {
            opponent.field.addSymbol(shot, FieldPlaying.Symbol.MISS);
        } else {
            ship.get().hit();
            opponent.field.addSymbol(shot, FieldPlaying.Symbol.HIT);
            System.out.println("Попадание!");
            if (ship.get().getIntact_decks() == 0) {
                System.out.println("Корабль потоплен!");
                opponent.getField().addUnavailable(ship.get());
                return opponent.field.eraseShip(ship.get()) ? Game.StatusGame.END_GAME : Game.StatusGame.CURRENT_PLAYER_MOVE;
            } else {
                return Game.StatusGame.CURRENT_PLAYER_MOVE;
            }
        }
        System.out.println("Промах!");
        return Game.StatusGame.NEXT_PLAYER_MOVE;
    }
}
