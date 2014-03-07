package com.thoughtworks.tictactoe;


import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by varoske on 3/6/14.
 */
public class TicTacToeGameTest {

    private PrintStream printStream;
    private Board board;
    private TicTacToeGame game;
    private String[] locations= new String[9];
    private BufferedReader bufferedReader;


    @Before
    public void setUp() {
        printStream= mock(PrintStream.class);
        board= mock(Board.class);
        game= new TicTacToeGame(board, printStream);
        bufferedReader= mock(BufferedReader.class);
    }



    @Test
    public void promptMoveShouldParseStringInputToInteger() throws IOException {

        when(bufferedReader.readLine()).thenReturn("1");

        int selectedLocation= game.promptMove(bufferedReader);

        assertEquals(1, selectedLocation);
    }



    /** Not sure how to test this exactly */
//    @Test
//    public void playGameShouldCallDrawBoard() throws IOException {
//        game.playGame();
//
//        verify(board).drawBoard();
//    }

    /** Not sure how to test this exactly */
//    @Test
//    public void playGameShouldCallMakeMove() throws IOException {
//        String marker= "X";
//
//        when(bufferedReader.readLine()).thenReturn("1");
//
//        game.playGame();
//        int location= game.promptMove(bufferedReader);
//
//
//        //when(board.isLocationTaken(location)).thenReturn(false);
//
//        verify(board).makeMove(location, marker);

//    }


    /** Can't test properly until multiple turns can be implemented? */
//    @Test
//    public void shouldDisplayMessageIfLocationIsAlreadyTaken() throws IOException {
//
//        String message= "Location already taken, try again";
//        int location=1;
//        String marker="X";
//
//        when(bufferedReader.readLine()).thenReturn("1");
//
//        game.playGame();
//
//
//
//        verify(printStream).println(message);
//    }




}
