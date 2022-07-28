package Day7;

import Day6.Airplane;
import static Day6.Airplane.compareAirplanes;

public class Day7 {

    public static void solution_1() {
        Airplane air1 = new Airplane("Boeing", 2000,100.0, 1000.0);
        Airplane air2 = new Airplane("Sukhoi", 2005, 120.0, 1500.0);
        Airplane.compareAirplanes(air1, air2);
    }

    public static void solution_2() {
        Player player1 = new Player();
        Player.info();
        Player player2 = new Player();
        Player player3 = new Player();
        Player.info();
        Player player4 = new Player();
        Player player5 = new Player();
        Player player6 = new Player();
        Player.info();
        Player player7 = new Player();
        System.out.println("Всего сейчас играет: " + Player.getCountPlayers());
        while (player1.run());
        Player.info();
    }

}
