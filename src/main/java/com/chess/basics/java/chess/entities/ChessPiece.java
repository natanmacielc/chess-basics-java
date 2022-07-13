package com.chess.basics.java.chess.entities;

import com.chess.basics.java.boardgame.entities.Board;
import com.chess.basics.java.boardgame.entities.Piece;
import com.chess.basics.java.chess.enums.Color;
import lombok.Getter;


@Getter
public class ChessPiece extends Piece {

    private final Color color;

    public ChessPiece(Board bosard, Color color) {
        super(board);
        this.color = color;
    }
}
