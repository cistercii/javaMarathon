package FinalProject;

public enum Symbol {

    EmptyField("\u2B1C"),       // Пустое поле
    UnavailableField("\u25A1 "), // Недоступное поле
    Ship("\u26F5"),              // Корабль
    Hit("\uD83D\uDD25"),         // Попадание
    Miss("\u274C");             // Промах

    private final String unicode;

    private Symbol(String unicode) {
        this.unicode = unicode;
    }

    @Override
    public String toString() {
        return this.unicode;
    }
}
