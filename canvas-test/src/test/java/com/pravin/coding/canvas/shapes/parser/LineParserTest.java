package com.pravin.coding.canvas.shapes.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Test;

import com.pravin.coding.canvas.actions.Action;
import com.pravin.coding.canvas.actions.ErrorAction;
import com.pravin.coding.canvas.coordinates.Coordinates;
import com.pravin.coding.canvas.shapes.Line;

public class LineParserTest {

	@Test
	public void shouldParseLine() {
		Action action = new LineParser().parseEachParser("L 1 2 3 4");
		Assert.assertEquals(new Line(new Coordinates(0, 1), new Coordinates(2, 3), 'x'), action);

	}

	@Test
	public void shouldNotParseLineIfNotLine() {
		Action action = new LineParser().parseEachParser("A 1 2 c");
		assertNull(action);

	}

	@Test
	public void shouldParseLineWithErrorIfParamWrong() {
		Action action = new LineParser().parseEachParser("L 1 2 one two");
		Assert.assertEquals(new ErrorAction("Cannot parse int value: For input string: \"one\""), action);

	}

	@Test
	public void shouldParseLineWithErrorIfNotEnoughParams() {
		Action action = new LineParser().parseEachParser("L 1");
		assertEquals(new ErrorAction("Expected 4 params for command L but got 1"), action);
	}

	@Test
	public void shouldParseLineWithErrorIfParamsNotSplitted() {
		Action action = new LineParser().parseEachParser("L 1234");
		assertEquals(new ErrorAction("Expected 4 params for command L but got 1"), action);
	}

	@Test
	public void shouldNotParseEmpty() {
		assertNull(new LineParser().parseEachParser(""));

	}

	@Test
	public void shouldNotParseNull() {
		assertNull(new LineParser().parseEachParser(null));
	}

}
