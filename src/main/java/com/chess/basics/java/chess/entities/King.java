package com.chess.basics.java.chess.entities;

import com.chess.basics.java.boardgame.entities.Board;
import com.chess.basics.java.chess.enums.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public Boolean[][] possibleMoves() {
        Boolean[][] mat = new Boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }
}
