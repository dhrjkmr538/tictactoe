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

    @Test
    public void shouldReturnTrueWhenThreeInARowHorizontally() {

        board.mark(1, "X");
        board.mark(2, "X");
        board.mark(3, "X");

        assertTrue(board.isThreeInARow());
    }

    @Test
    public void shouldReturnFalseWhenNotThreeInARowHorizontally() {

        board.mark(1, "X");
        board.mark(2, "X");
        board.mark(4, "X");

        assertFalse(board.isThreeInARow());
    }

    @Test
    public void shouldReturnTrueWhenThreeInARowVertically() {

        board.mark(1, "X");
        board.mark(4, "X");
        board.mark(7, "X");

        assertTrue(board.isThreeInARow());
    }

    @Test
    public void shouldReturnTrueWhenThreeInARowDiagonally() {

        board.mark(3, "X");
        board.mark(5, "X");
        board.mark(7, "X");

        assertTrue(board.isThreeInARow());
    }

    @Test
    public void shouldKnowWhenGameIsWon() {
        board.mark(3, "X");
        board.mark(5, "X");
        board.mark(7, "X");

        assertTrue(board.isGameOver());
    }

    @Test
    public void shouldKnowWhenGameIsTie() {
        board.mark(1, "X");
        board.mark(2, "O");
        board.mark(3, "X");
        board.mark(4, "O");
        board.mark(5, "X");
        board.mark(6, "O");
        board.mark(7, "X");
        board.mark(8, "O");
        board.mark(9, "X");

        assertTrue(board.isGameOver());
    }

    @Test
    public void shouldKnowWhenGameIsNotOver() {

        board.mark(3, "X");
        board.mark(5, "X");
        board.mark(4, "X");

        assertFalse(board.isGameOver());
    }

}