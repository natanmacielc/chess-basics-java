package com.chess.basics.java.chess.entities;

import com.chess.basics.java.boardgame.entities.Board;
import com.chess.basics.java.boardgame.entities.Position;
import com.chess.basics.java.chess.enums.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        this.initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i<board.getRows(); i++) {
            for (int j=0; j<board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void placeNewPiece(Character column, Integer row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup() {
        this.placeNewPiece('b', 6, new Rook(board, Color.WHITE));
        this.placeNewPiece('e', 8, new King(board, Color.WHITE));
        this.placeNewPiece('e', 1, new King(board, Color.WHITE));
    }
}
