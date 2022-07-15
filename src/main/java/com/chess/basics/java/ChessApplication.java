package com.chess.basics.java;

import com.chess.basics.java.chess.entities.ChessMatch;
import com.chess.basics.java.chess.entities.ChessPiece;
import com.chess.basics.java.chess.entities.ChessPosition;
import com.chess.basics.java.chess.exceptions.ChessException;
import com.chess.basics.java.utils.UIUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChessApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                UIUtils.clearScreen();
                UIUtils.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UIUtils.readChessPosition(sc);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UIUtils.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }
            catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
