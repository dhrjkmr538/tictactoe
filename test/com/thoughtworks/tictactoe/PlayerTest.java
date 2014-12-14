package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class PlayerTest {

    private String marker;
    private Board board;
    private ValidInputGetter validInputGetter;
    private Player player;

    @Before
    public void setUp() {
        marker= "X";
        board= mock(Board.class);
        validInputGetter= mock(ValidInputGetter.class);
        player= new Player(marker, board, validInputGetter);
    }

    @Test
    public void shouldGetValidInput() throws IOException {

        player.makeMove();

        verify(validInputGetter).getValidInput();
    }

    @Test
    public void makeMoveShouldMarkBoard() throws IOException {

        when(validInputGetter.getValidInput())
                .thenReturn(1);

        player.makeMove();

        verify(board).mark(1, marker);
    }

}