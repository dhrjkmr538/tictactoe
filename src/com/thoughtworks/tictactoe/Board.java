package com.thoughtworks.tictactoe;

import java.io.PrintStream;

/**
 * Created by varoske on 3/6/14.
 */
public class Board {

    private final String separator= "--------";

    private final PrintStream printStream;
    private String[] locations;

    public Board(PrintStream printStream) {

        this.printStream= printStream;

        locations= new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
    }

    public void drawBoard() {

        String board= "";

        for (int i = 0; i < locations.length; i++) {
            board += locations[i];

            if ((i+1) % 3 == 0) {
                board+= "\n";

                if (i != locations.length - 1) {
                    board+= separator + "\n";
                }

            } else {
                board+= "|";
            }

        }

        printStream.println(board);

    }

    public String makeMove(int location, String marker) {

        locations[location - 1]= marker;
        return locations[location - 1];
    }


    public boolean isLocationTaken (int location) {

        boolean isTaken= false;

        if (locations[location -1].equals("X") || locations[location -1].equals("O")) {

            isTaken= true;
        }

        return isTaken;
    }

    public boolean isFull() {

        boolean isFull= true;

        for (int i = 0; i < locations.length; i++) {
            if (locations[i].equals(" ")) {
                isFull= false;
            }

        }
        return isFull;
    }
}
