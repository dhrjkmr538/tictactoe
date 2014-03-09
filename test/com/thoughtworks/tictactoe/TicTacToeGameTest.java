package com.thoughtworks.tictactoe;


import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by varoske on 3/6/14.
 */
public class TicTacToeGameTest {

    private Board board;
    private Player player;
    private TicTacToeGame game;
    private BufferedReader bufferedReader;


    @Before
    public void setUp() {
        bufferedReader= mock(BufferedReader.class);
        board= mock(Board.class);
        player= mock(Player.class);
        game= new TicTacToeGame(board, player);
    }


    @Test
    public void shouldDrawBoardAtLeastTwice() throws IOException {

        when(!board.isFull())
                .thenReturn(false)
                .thenReturn(true);

        when(bufferedReader.readLine())
                .thenReturn("1");

        when(board.isPositionTaken(1))
                .thenReturn(false);

        game.play();

        verify(board, atLeast(2)).draw();
    }

    @Test
    public void playerOneShouldMakeMove() throws IOException {

        when(!board.isFull())
                .thenReturn(false)
                .thenReturn(true);

        when(bufferedReader.readLine())
                .thenReturn("1");

        when(board.isPositionTaken(1))
                .thenReturn(false);

        game.play();

        verify(player, atLeastOnce()).makeMove(true, bufferedReader);

    }


    @Test
    public void boardShouldMarkItselfAfterPlayerDecision() throws IOException {

        when(!board.isFull())
                .thenReturn(false)
                .thenReturn(true);

        when(player.makeMove(true, bufferedReader))
                .thenReturn(1);

        when(board.isPositionTaken(1))
                .thenReturn(false);

        when(player.getPlayerMarker(true))
                .thenReturn("X");

        game.play();

        verify(board).mark(1, "X");
    }








}
