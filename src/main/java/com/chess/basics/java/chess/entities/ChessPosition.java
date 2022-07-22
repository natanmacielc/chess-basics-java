package com.chess.basics.java.chess.entities;

import com.chess.basics.java.boardgame.entities.Position;
import com.chess.basics.java.chess.exceptions.ChessException;
import lombok.Getter;

@Getter
public class ChessPosition {

    private final Character column;

    private final Integer row;

    public ChessPosition(Character column, Integer row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
        }
        this.column = column;
        this.row = row;
    }

    protected Position toPosition() {
        return new Position(8 - row, column - 'a');
    }

    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString() {
        return String.format("%c %d", this.column, this.row);
    }
}
