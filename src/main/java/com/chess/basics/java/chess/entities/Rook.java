package com.chess.basics.java.chess.entities;

import com.chess.basics.java.boardgame.entities.Board;
import com.chess.basics.java.chess.enums.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }
}
