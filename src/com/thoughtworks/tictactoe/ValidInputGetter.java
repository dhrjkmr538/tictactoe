package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;

public class ValidInputGetter {

    private Board board;
    private BufferedReader bufferedReader;

    public ValidInputGetter(Board board, BufferedReader bufferedReader) {
        this.board = board;
        this.bufferedReader = bufferedReader;
    }

    // might want to put in numeric validation later
    public int getValidInput() throws IOException {

        int position= Integer.parseInt(bufferedReader.readLine());

        while (board.isPositionTaken(position)) {
            System.out.println("Location already taken, try again");
            position= Integer.parseInt(bufferedReader.readLine());
        }

        return position;
    }

}