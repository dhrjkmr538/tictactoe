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
        board= new Board(printStream);
        game= new TicTacToeGame(board);
        bufferedReader= mock(BufferedReader.class);
    }



    @Test
    public void promptMoveShouldParseStringInputToInteger() throws IOException {

        when(bufferedReader.readLine()).thenReturn("1");

        int selectedLocation= game.promptMove(bufferedReader);

        assertEquals(1, selectedLocation);
    }

/* test:
  - playGame calls drawBoard
    - playGame calls makeMove
*/
//    @Test
//    public void makePlayerOneMoveShouldDrawXWhenLocationZeroSelected() {
//        int location=1;
//
//        String result= board.makeMove(location, "X");
//
//        assertEquals("X", result);
//    }

//    @Test
//    public void makePlayerTwoMoveShouldDrawOWhenLocationOneSelected() {
//
//        String result= game.makePlayerTwoMove(2);
//
//        assertEquals("O", result);
//
//    }

//    @Test
//    public void displayTryAgainWhenLocationAlreadyTaken() {
//
//        locations[0]= "X";
//
//
//
//        assertEquals(true, game.isLocationTaken(1, printStream));
//
//    }




}
