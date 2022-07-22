package com.chess.basics.java.chess.entities;

import com.chess.basics.java.boardgame.entities.Board;
import com.chess.basics.java.boardgame.entities.Piece;
import com.chess.basics.java.boardgame.entities.Position;
import com.chess.basics.java.chess.enums.Color;
import lombok.Getter;


@Getter
public abstract class ChessPiece extends Piece {

    private final Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    protected void increaseMoveCount() {
        moveCount++;
    }

    protected void decreaseMoveCount() {
        moveCount--;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p.getColor() != color;
    }
}
