package com.thoughtworks.tictactoe;

import java.io.IOException;

// GameReferee coordinates the activities of the game
public class GameReferee {

    private Board board;
    private Player player1;
    private Player player2;


    public GameReferee(Board board, Player player1, Player player2) {
        this.board= board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() throws IOException {

        board.draw();

        Player currentPlayer= player1;

        while (!board.isGameOver()) {

            System.out.printf("Player %s: Please enter a number between 1 and 9 to indicate where you wish to move \n",
                    (currentPlayer.equals(player1) ? 1 : 2));

            currentPlayer.makeMove();
            board.draw();

            currentPlayer= (currentPlayer.equals(player1) ? player2 : player1);
        }

        System.out.println("Game is a draw");
        // needs a message for when game is actually one
        // “Player <#> Wins!”
    }

}