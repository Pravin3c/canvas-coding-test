package com.pravin.coding.canvas.shapes;

import org.junit.Assert;
import org.junit.Test;
import com.pravin.coding.canvas.coordinates.Coordinates;
import com.pravin.coding.canvas.utils.CommonUtilTest;

public class RectangleTest {

	@Test
	public void shouldDrawRectangle() {
		Canvas c = new Canvas(10, 6);
		Rectangle rectangle = new Rectangle(new Coordinates(1, 2), new Coordinates(4, 5), 'X');
		rectangle.validate(c);
		rectangle.apply(c);

		Assert.assertEquals(CommonUtilTest
				.createCanvas("          ", "          ", " XXXX     ", " X  X     ", " X  X     ", " XXXX     ")
				.toString(), c.toString());
	}

}
