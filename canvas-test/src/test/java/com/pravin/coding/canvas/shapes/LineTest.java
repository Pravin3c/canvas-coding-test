package com.pravin.coding.canvas.shapes;

import org.junit.Assert;
import org.junit.Test;

import com.pravin.coding.canvas.coordinates.Coordinates;
import com.pravin.coding.canvas.utils.CommonUtilTest;

public class LineTest {

	private Canvas canvas;
	private Line line;

	@Test
	public void shouldDrawHorizontalLine() {
		givenCanvas();
		Line line = new Line(new Coordinates(1, 2), new Coordinates(3, 2), 'x');
		line.apply(canvas);
		Assert.assertEquals(CommonUtilTest.createCanvas("     ", "     ", " xxx ").toString(), canvas.toString());

	}

	@Test
	public void shouldDrawVerticalLine() {
		givenCanvas();
		line = new Line(new Coordinates(1, 0), new Coordinates(1, 2), 'x');
		whenApplyAction();
		Assert.assertEquals(CommonUtilTest.createCanvas(" x   ", " x   ", " x   ").toString(), canvas.toString());

	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotDrawLineOutOfBorderY() {
		givenCanvas();
		Line line = new Line(new Coordinates(1, 4), new Coordinates(2, 4), 'x');
		line.validate(canvas);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotDrawLineOutOfBorderX() {
		givenCanvas();
		Line line = new Line(new Coordinates(2, 1), new Coordinates(10, 1), 'x');
		line.validate(canvas);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotDrawInclined() {
		givenCanvas();
		Line line = new Line(new Coordinates(1, 1), new Coordinates(2, 2), 'x');
		line.validate(canvas);
	}

	private void givenCanvas() {
		canvas = new Canvas(5, 3);
	}

	private void whenApplyAction() {
		line.validate(canvas);
		line.apply(canvas);
	}

}
