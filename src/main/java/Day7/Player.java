package Day7;

import java.util.Random;

public class Player {
    private int stamina;

    static private final int MAX_STAMINA = 100;
    static private final int MIN_STAMINA = 0;
    static private final int MAX_PLAYERS = 6;
    static private int countPlayers = 0;

    public static int getCountPlayers() {
        return countPlayers;
    }

    public Player() {
        if (countPlayers >= MAX_PLAYERS) {
            this.stamina = 0;
            return;
        }
        Random rand = new Random();
        final int MIN_START_STAMINA = 90;
        this.stamina = MIN_START_STAMINA + rand.nextInt(11);
        countPlayers++;
    }

    public int getStamina() {
        return stamina;
    }

    public boolean run() {
        this.stamina--;
        if (this.stamina == 0) {
            System.out.println("Игрок уходит с поля");
            countPlayers--;
            return false;
        }
        return true;
    }

    public static void info() {
        if (countPlayers < 6) {
            System.out.println("Команды неполные. На поле еще есть " + (MAX_PLAYERS - countPlayers) + " мест");
        } else {
            System.out.println("На поле нет свободных мест");
        }
    }
}
