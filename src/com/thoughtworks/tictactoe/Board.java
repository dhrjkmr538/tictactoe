package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;

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

    //@TODO: refactor
    public boolean isThreeInARow() {
        String first = "";
        String second = "";
        String third = "";

        // Horizontal Check
        for (int i = 0; i < positions.size(); i=i+3) {
            first= positions.get(i);
            second= positions.get(i + 1);
            third= positions.get(i + 2);

            if (first.equals(second) && first.equals(third) && !first.equals(" ")) {
                return true;
            }
        }

        // Vertical Check
        for (int i = 0; i < positions.size() / 3; i++) {
            first= positions.get(i);
            second= positions.get(i + 3);
            third= positions.get(i + 6);

            if (first.equals(second) && first.equals(third) && !first.equals(" ")) {
                return true;
            }

        }

        // Diagonal Check
        first= positions.get(0);
        second= positions.get(4);
        third= positions.get(8);

        if (first.equals(second) && first.equals(third) && !first.equals(" ")) {
            return true;
        }

        first= positions.get(2);
        third= positions.get(6);

        if (first.equals(second) && first.equals(third) && !first.equals(" ")) {
            return true;
        }


        // None of the checks worked
        return false;
    }

    public boolean isGameOver() {
        return isThreeInARow() || isFull();
    }

}