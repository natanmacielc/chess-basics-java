package com.chess.basics.java.boardgame.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public abstract class Piece {

    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() {
        return board;
    }

    public abstract Boolean[][] possibleMoves();

    public Boolean possibleMoves(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public Boolean isThereAnyPossibleMove() {
        Boolean[][] mat = possibleMoves();
        for (Integer i=0; i<mat.length; i++) {
            for (int j=0; j< mat.length; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
