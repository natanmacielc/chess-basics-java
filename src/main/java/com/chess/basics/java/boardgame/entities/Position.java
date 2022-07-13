package com.chess.basics.java.boardgame.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {

    private Integer row;

    private Integer column;


    @Override
    public String toString() {
        return String.format("%d, %d", this.column, this.row);
    }
}
