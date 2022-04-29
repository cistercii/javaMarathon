package Day17;

public enum ChessPiece {
    KingWhite("Белый король", '\u265A', 100.0f),
    QueenWhite("Белый ферзь", '\u265B', 9.0f),
    RookWhite("Белая ладья", '\u265C', 5.0f),
    BishopWhite("Белый слон", '\u265D', 3.5f),
    KnightWhite("Белый конь", '\u265E', 3.0f),
    PawnWhite("Белая пешка", '\u265F', 1.0f),
    KingBlack("Черный король", '\u2654', 100.0f),
    QueenBlack("Черный ферзь", '\u2655', 9.0f),
    RookBlack("Черная ладья", '\u2656', 5.0f),
    BishopBlack("Черный слон", '\u2657', 3.5f),
    KnightBlack("Черный конь", '\u2658', 3.0f),
    PawnBlack("Черная пешка", '\u2659', 1.0f),
    Empty("Пустое поле", '_', -1.0f);

    private final String name;
    private final char unicode;
    private final float value;

    ChessPiece(String name, char unicode, float value) {
        this.name = name;
        this.unicode = unicode;
        this.value = value;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", unicode=" + unicode;
    }

    public char getUnicode() {
        return unicode;
    }
}
