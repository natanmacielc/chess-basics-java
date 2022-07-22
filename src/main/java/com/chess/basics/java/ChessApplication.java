package com.chess.basics.java;

import com.chess.basics.java.chess.entities.ChessMatch;
import com.chess.basics.java.chess.entities.ChessPiece;
import com.chess.basics.java.chess.entities.ChessPosition;
import com.chess.basics.java.chess.exceptions.ChessException;
import com.chess.basics.java.utils.UIUtils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ChessApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();


        while (!chessMatch.getCheckMate()) {
            try {
                UIUtils.clearScreen();
                UIUtils.printMatch(chessMatch, captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UIUtils.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UIUtils.clearScreen();
                UIUtils.printBoard(chessMatch.getPieces(), possibleMoves);
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UIUtils.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }

                if (chessMatch.getPromoted() != null) {
                    System.out.print("Enter piece for promotion (B/N/R/Q): ");
                    String type = sc.nextLine().toUpperCase();
                    while (!type.equals("B") && !type.equals("N") && !type.equals("R") & !type.equals("Q")) {
                        System.out.print("Invalid value! Enter piece for promotion (B/N/R/Q): ");
                        type = sc.nextLine().toUpperCase();
                    }
                    chessMatch.replacePromotedPiece(type);
                }
            }

            catch (ChessException | InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UIUtils.clearScreen();
        UIUtils.printMatch(chessMatch, captured);
    }
}
