package com.chess.basics.java;

import com.chess.basics.java.chess.entities.ChessMatch;

public class ChessApplication {

    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}
