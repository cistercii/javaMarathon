package Day17;

import java.util.ArrayList;
import java.util.List;

public class Day17 {
    public static void solution_1() {
        List<ChessPiece> list = new ArrayList<>();
        list.add(ChessPiece.PawnWhite);
        list.add(ChessPiece.PawnWhite);
        list.add(ChessPiece.PawnWhite);
        list.add(ChessPiece.PawnWhite);
        list.add(ChessPiece.RookBlack);
        list.add(ChessPiece.RookBlack);
        list.add(ChessPiece.RookBlack);
        list.add(ChessPiece.RookBlack);

        list.forEach(x -> System.out.print(x.getUnicode() + " "));
    }

    public static void solution_2() {
        ChessPiece [][] pieces =
                {
                        {ChessPiece.RookBlack, ChessPiece.Empty, ChessPiece.Empty, ChessPiece.Empty, ChessPiece.Empty, ChessPiece.RookBlack, ChessPiece.KingBlack, ChessPiece.Empty},
                        {ChessPiece.Empty, ChessPiece.RookWhite, ChessPiece.Empty, ChessPiece.Empty, ChessPiece.PawnBlack, ChessPiece.PawnBlack, ChessPiece.Empty, ChessPiece.PawnBlack},
                        {ChessPiece.PawnBlack, ChessPiece.Empty, ChessPiece.KnightBlack, ChessPiece.Empty, ChessPiece.Empty, ChessPiece.Empty, ChessPiece.PawnBlack, ChessPiece.Empty},
                        {ChessPiece.QueenBlack, ChessPiece.Empty, ChessPiece.Empty, ChessPiece.BishopWhite, ChessPiece.Empty, ChessPiece.Empty, ChessPiece.Empty, ChessPiece.Empty},
                        {ChessPiece.Empty, ChessPiece.Empty, ChessPiece.Empty, ChessPiece.BishopBlack, ChessPiece.PawnWhite, ChessPiece.Empty, ChessPiece.Empty, ChessPiece.Empty},
                        {ChessPiece.Empty, ChessPiece.Empty, ChessPiece.Empty, ChessPiece.Empty, ChessPiece.BishopWhite, ChessPiece.PawnWhite, ChessPiece.Empty, ChessPiece.Empty},
                        {ChessPiece.PawnWhite, ChessPiece.Empty, ChessPiece.Empty, ChessPiece.QueenWhite, ChessPiece.Empty, ChessPiece.PawnWhite, ChessPiece.Empty, ChessPiece.PawnWhite},
                        {ChessPiece.Empty, ChessPiece.Empty, ChessPiece.Empty, ChessPiece.Empty, ChessPiece.Empty, ChessPiece.RookWhite, ChessPiece.KingWhite, ChessPiece.Empty}
                };
        ChessBoard board = new ChessBoard(pieces);
        board.print();
    }
}
