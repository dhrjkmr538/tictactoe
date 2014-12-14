package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<String> positions= new ArrayList<String>(Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " "));
        Board board= new Board(System.out, positions);

        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        ValidInputGetter validInputGetter= new ValidInputGetter(board, bufferedReader);

        Player player1= new Player("X", board, validInputGetter);
        Player player2= new Player("0", board, validInputGetter);

        GameReferee game= new GameReferee(board, player1, player2);

        game.play();
    }
}