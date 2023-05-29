package com.pravin.coding.canvas.shapes.parser;

import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Test;

import com.pravin.coding.canvas.actions.Action;
import com.pravin.coding.canvas.actions.ErrorAction;

public class CreateCanvasParserTest {


	@Test
	public void shouldNotAllowNoParams() {
		Action action = new CanvasParser().parseEachParser("C 10");
		Assert.assertEquals(new ErrorAction("Expected 2 params for command C but got 1"), action);
	}

	@Test
	public void shouldNotParseNotCanvas() {
		Action action = new CanvasParser().parseEachParser("A");
		assertNull(action);
	}

	@Test
	public void shouldNotParseEmpty() {
		assertNull(new CanvasParser().parseEachParser(""));

	}

	@Test
	public void shouldNotParseNull() {
		assertNull(new CanvasParser().parseEachParser(null));
	}

}
