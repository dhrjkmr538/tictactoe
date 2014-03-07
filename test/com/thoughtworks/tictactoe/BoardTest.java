package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

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

    @Before
    public void setUp() {
        printStream= mock(PrintStream.class);
        board= new Board(printStream);
    }

    @Test
    public void shouldDrawBoardOnConsole() {

        String emptyRow= " | | ";
        String separator= "--------";
        String row= emptyRow + "\n" + separator + "\n";

        board.drawBoard();

        verify(printStream).println(row + row + emptyRow + "\n");

    }


    @Test
    public void shouldDrawXWhenPlayerOneMoves() {
        int location=1;
        String marker="X";
        String result= board.makeMove(location, marker);

        assertEquals("X", result);
    }

    @Test
    public void shouldDrawOWhenPlayerTwoMoves() {
        int location=2;
        String marker="O";
        String result= board.makeMove(location, marker);

        assertEquals("O", result);

    }

    @Test
    public void shouldReturnTrueIfLocationIsAlreadyTaken() {
        int location=3;
        String marker="X";

        board.makeMove(location, marker);

        assertEquals(true, board.isLocationTaken(location));
    }

    @Test
    public void shouldReturnFalseIfLocationIsNotTaken() {
        int location=4;
        String marker="X";

        assertEquals(false, board.isLocationTaken(location));
    }

    @Test
    public void shouldReturnFalseWhenBoardIsNotFull() {

        board.drawBoard();

        assertFalse(board.isFull());
    }

    @Test
    public void shouldReturnFalseWhenBoardIsFull() {

        String[] locations= new String[9];
        String marker= "X";

        for (int loc = 0; loc < locations.length; loc++) {
             board.makeMove(loc + 1, marker);
        }

        assertTrue(board.isFull());
    }

    @Test
    public void shouldPrintMessageToConsoleWhenBoardIsFull() {

    }

//    @Test
//    public void shouldDisplayMessageIfLocationIsAlreadyTaken() {
//
//        String message= "Location already taken, try again";
//        int location=1;
//        String marker="X";
//
//        board.makeMove(location,marker);
//        board.makeMove(location,marker);
//
//
//        verify(printStream).println(message);
//    }



}
