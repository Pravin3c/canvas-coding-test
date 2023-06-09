package com.pravin.coding.canvas.shapes.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Test;

import com.pravin.coding.canvas.actions.Action;
import com.pravin.coding.canvas.actions.ErrorAction;
import com.pravin.coding.canvas.coordinates.Coordinates;
import com.pravin.coding.canvas.shapes.Rectangle;

public class RectangleParserTest {

	@Test
	public void shouldParseRectangle() {
		Action action = new RectangleParser().parseEachParser("R 1 2 3 4");
		Assert.assertEquals(new Rectangle(new Coordinates(0, 1), new Coordinates(2, 3), 'x'), action);

	}

	@Test
	public void shouldNotParseRectangleIfNotRectangle() {
		Action action = new RectangleParser().parseEachParser("A 1 2 c");
		assertNull(action);

	}

	@Test
	public void shouldParseRectangleWithErrorIfParamWrong() {
		Action action = new RectangleParser().parseEachParser("R 1 2 one two");
		Assert.assertEquals(new ErrorAction("Cannot parse int value: For input string: \"one\""), action);

	}

	@Test
	public void shouldParseRectangleWithErrorIfNotEnoughParams() {
		Action action = new RectangleParser().parseEachParser("R 1");
		assertEquals(new ErrorAction("Expected 4 params for command R but got 1"), action);
	}

	@Test
	public void shouldParseRectangleWithErrorIfParamsNotSplitted() {
		Action action = new RectangleParser().parseEachParser("R 1234");
		assertEquals(new ErrorAction("Expected 4 params for command R but got 1"), action);
	}

	@Test
	public void shouldNotParseEmpty() {
		assertNull(new RectangleParser().parseEachParser(""));

	}

	@Test
	public void shouldNotParseNull() {
		assertNull(new RectangleParser().parseEachParser(null));
	}

}
