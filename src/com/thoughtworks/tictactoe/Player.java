package com.thoughtworks.tictactoe;

import java.io.IOException;

public class Player {

    private String marker;
    private Board board;
    private ValidInputGetter validInputGetter;

    public Player(String marker, Board board, ValidInputGetter validInputGetter) {
        this.marker= marker;
        this.board = board;
        this.validInputGetter = validInputGetter;
    }

    public void makeMove() throws IOException {
        int position= validInputGetter.getValidInput();
        board.mark(position, marker);
    }

}