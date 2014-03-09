package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by varoske on 3/6/14.
 */
public class Board {

    private final String separator= "-----";

    private final PrintStream printStream;
    private ArrayList<String> locations;

    public Board(PrintStream printStream) {

        this.printStream= printStream;
        locations = new ArrayList<String>(Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " "));
    }

    public void draw() {

        String newBoard = locations.get(0) + "|" + locations.get(1) + "|" + locations.get(2) + "\n"
                          + separator + "\n"
                          + locations.get(3) + "|" + locations.get(4) + "|" + locations.get(5) + "\n"
                          + separator + "\n"
                          + locations.get(6) + "|" + locations.get(7) + "|" + locations.get(8) + "\n";

        printStream.println(newBoard);
    }


    public void mark(int location, String marker) {
        locations.set(location - 1, marker);
    }

    public boolean isLocationTaken (int location) {
        return !(locations.get(location - 1).equals(" "));
    }

    public boolean isFull() {
        return (!locations.contains(" "));
    }


}
