package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by varoske on 3/6/14.
 */
public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private ArrayList<String> positions;

    @Before
    public void setUp() {
        printStream= mock(PrintStream.class);
        positions= new ArrayList<String>(Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " "));
        board= new Board(printStream, positions);
    }

    @Test
    public void shouldDrawEmptyBoard() {

        String emptyBoard= " | | \n"
                         + "-----\n"
                         + " | | \n"
                         + "-----\n"
                         + " | | \n";

        board.draw();

        verify(printStream).println(emptyBoard);
    }

    @Test
    public void shouldMarkXWhenPlayerOneMoves() {
        String marker="X";

        board.mark(1, marker);

        assertEquals("X", positions.get(0));
    }

    @Test
    public void shouldMarkOWhenPlayerTwoMoves() {
        String marker="O";

        board.mark(1, marker);

        assertEquals("O", positions.get(0));
    }

    @Test
    public void shouldReturnTrueIfLocationIsAlreadyTaken() {
        int location=1;
        String marker="X";

        board.mark(location, marker);

        assertTrue(board.isPositionTaken(location));
    }

    @Test
    public void shouldReturnFalseIfLocationIsNotTaken() {
        int location=4;

        assertFalse(board.isPositionTaken(location));
    }

    @Test
    public void shouldReturnFalseWhenBoardIsNotFull() {
        board.draw();

        assertFalse(board.isFull());
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFull() {
        String marker= "X";

        for (int i = 1; i <= positions.size(); i++) {
            board.mark(i, marker);
        }

        assertTrue(board.isFull());
    }



}
