package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class GameRefereeTest {

    private Board board;
    private Player player1;
    private Player player2;
    private GameReferee game;

    @Before
    public void setUp() {
        board= mock(Board.class);
        player1= mock(Player.class);
        player2= mock(Player.class);
        game= new GameReferee(board, player1, player2);
    }

    @Test
    public void playerOneShouldMakeMoveAtLeastOnce() throws IOException {

        when(!board.isGameOver())
                .thenReturn(false)
                .thenReturn(true);

        game.play();

        verify(player1, atLeastOnce()).makeMove();
    }

    @Test
    public void playerTwoShouldMakeMoveAtLeastOnce() throws IOException {

        when(!board.isGameOver())
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(true);

        game.play();

        verify(player2, atLeastOnce()).makeMove();
    }

    @Test
    public void shouldInvokeDrawEmptyBoardAtStart() throws IOException {

        when(!board.isGameOver())
                .thenReturn(false)
                .thenReturn(true);

        game.play();

        verify(board, atLeast(2)).draw();
    }

}