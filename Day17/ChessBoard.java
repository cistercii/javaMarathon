package Day17;

public class ChessBoard {
    private static final int SIZE_BOARD = 8;

    private final ChessPiece [][] board;

    public ChessBoard(ChessPiece[][] board) {
        this.board = board;
    }

    public void print() {
        if (!checkSize()) {
            System.out.println("Недоступный размер поля");
            return;
        }
        for (int i = 0; i < SIZE_BOARD; i++) {
           for (int j = 0; j < SIZE_BOARD; j++) {
               System.out.print(board[i][j].getUnicode());
           }
           System.out.println("");
       }
    }

    private boolean checkSize() {
        if (board.length != SIZE_BOARD) return false;
        for (int i = 0; i < SIZE_BOARD; i++) {
            if (board[i].length != SIZE_BOARD) return false;
        }
        return true;
    }
}
