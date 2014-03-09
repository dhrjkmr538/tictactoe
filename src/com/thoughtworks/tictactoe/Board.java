package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by varoske on 3/6/14.
 */
public class Board {

    private final String separator= "-----";

    private final PrintStream printStream;
    private ArrayList<String> positions;

    public Board(PrintStream printStream, ArrayList<String> positions) {

        this.printStream= printStream;
        this.positions = positions;
    }

    public void draw() {

        String newBoard = positions.get(0) + "|" + positions.get(1) + "|" + positions.get(2) + "\n"
                          + separator + "\n"
                          + positions.get(3) + "|" + positions.get(4) + "|" + positions.get(5) + "\n"
                          + separator + "\n"
                          + positions.get(6) + "|" + positions.get(7) + "|" + positions.get(8) + "\n";

        printStream.println(newBoard);
    }


    public void mark(int position, String marker) {
        positions.set(position - 1, marker);
    }

    public boolean isPositionTaken(int position) {
        return !(positions.get(position - 1).equals(" "));
    }

    public boolean isFull() {
        return (!positions.contains(" "));
    }


}
