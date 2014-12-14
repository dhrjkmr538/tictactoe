package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ValidInputGetterTest {

    private ValidInputGetter validInputGetter;
    private Board board;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() {
        board= mock(Board.class);
        bufferedReader= mock(BufferedReader.class);
        validInputGetter= new ValidInputGetter(board, bufferedReader);
    }

    @Test
    public void shouldGetValidInputWhenCondition() throws IOException {
        when(bufferedReader.readLine())
                .thenReturn("1");

        assertEquals(1, validInputGetter.getValidInput());
    }

    @Test
    public void shouldKeepAskingUntilInputIsValid() throws IOException {

        when(board.isPositionTaken(1))
                .thenReturn(true);

        when(bufferedReader.readLine())
                .thenReturn("1")
                .thenReturn("2");

        int actual= validInputGetter.getValidInput();

        assertThat(actual, is(2));
    }

}