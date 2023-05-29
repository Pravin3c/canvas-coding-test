package com.pravin.coding.canvas.shapes.parser;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pravin.coding.canvas.actions.Action;
import com.pravin.coding.canvas.actions.ErrorAction;
import com.pravin.coding.canvas.shapes.Quit;


public class QuitParserTest {


    @Test
    public void shouldParseQuit() {
        Action action = new QuitParser().parseEachParser("Q");
        assertTrue(Quit.class.isAssignableFrom(action.getClass()));
    }

    @Test
    public void shouldNotAllowParams() {
        Action action = new QuitParser().parseEachParser("Q q");
        assertTrue(ErrorAction.class.isAssignableFrom(action.getClass()));
    }

    @Test
    public void shouldNotParseNotQuit() {
        Action action = new QuitParser().parseEachParser("A");
        assertNull(action);
    }

    @Test
    public void shouldNotParseEmpty() {
        assertNull(new QuitParser().parseEachParser(""));

    }

    @Test
    public void shouldNotParseNull() {
        assertNull(new QuitParser().parseEachParser(null));
    }


}
