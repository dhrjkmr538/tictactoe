package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
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

    @Before
    public void setUp() {
        printStream= mock(PrintStream.class);
        board= new Board(printStream);
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
        int location=1;
        String marker="X";

        String updatedBoard = "X| | \n"
                            + "-----\n"
                            + " | | \n"
                            + "-----\n"
                            + " | | \n";

        board.mark(location, marker);
        board.draw();

        verify(printStream).println(updatedBoard);
    }

    @Test
    public void shouldMarkOWhenPlayerTwoMoves() {
        int location=1;
        String marker="O";

        String updatedBoard = "O| | \n"
                            + "-----\n"
                            + " | | \n"
                            + "-----\n"
                            + " | | \n";

        board.mark(location, marker);
        board.draw();

        verify(printStream).println(updatedBoard);
    }

    @Test
    public void shouldReturnTrueIfLocationIsAlreadyTaken() {
        int location=3;
        String marker="X";

        board.mark(location, marker);

        assertTrue(board.isLocationTaken(location));
    }

    @Test
    public void shouldReturnFalseIfLocationIsNotTaken() {
        int location=4;

        assertFalse(board.isLocationTaken(location));
    }

    @Test
    public void shouldReturnFalseWhenBoardIsNotFull() {
        board.draw();

        assertFalse(board.isFull());
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFull() {
        String marker= "X";

        board.mark(1, marker);
        board.mark(2, marker);
        board.mark(3, marker);
        board.mark(4, marker);
        board.mark(5, marker);
        board.mark(6, marker);
        board.mark(7, marker);
        board.mark(8, marker);
        board.mark(9, marker);

        assertTrue(board.isFull());
    }



}
