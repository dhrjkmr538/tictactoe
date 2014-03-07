package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by varoske on 3/6/14.
 */
public class TicTacToeGame {

    private Board board;
    private PrintStream printStream;

    private final String playerOneMarker= "X";
    private final String playerTwoMarker= "O";
    private boolean isPlayerOneTurn= true;


    public TicTacToeGame(Board board, PrintStream printStream) {
        this.board= board;
        this.printStream= printStream;
    }

    public static void main(String[] args) throws IOException {

        TicTacToeGame game= new TicTacToeGame(new Board(System.out), System.out);
        game.playGame();
    }

    public void playGame() throws IOException {

        BufferedReader bufferedReader=  new BufferedReader(new InputStreamReader(System.in));

        // setup
        board.drawBoard();

        // player one turn
        int location1= promptMove(bufferedReader);

        while (board.isLocationTaken(location1)) {

            printStream.println("Location already taken, try again");
            location1= promptMove(bufferedReader);
        }

        board.makeMove(location1, playerOneMarker);

        board.drawBoard();

        // player two turn
        isPlayerOneTurn= false;
        int location2= promptMove(bufferedReader);

        while (board.isLocationTaken(location2)) {

            printStream.println("Location already taken, try again");
            location2= promptMove(bufferedReader);
        }

        board.makeMove(location2, playerTwoMarker);

        board.drawBoard();


    }





    public int promptMove(BufferedReader bufferedReader) throws IOException {

        int player= (isPlayerOneTurn ? 1 : 2);

        System.out.printf("Player %d: Please enter a number between 1 and 9 to indicate where you wish to move \n",
                player);

        return Integer.parseInt(bufferedReader.readLine());

    }






}
