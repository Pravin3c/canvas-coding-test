package com.pravin.coding.canvas.utils;

import com.pravin.coding.canvas.coordinates.Coordinates;
import com.pravin.coding.canvas.shapes.Canvas;

public class CommonUtilTest {
	
	public static Canvas createCanvas(String... lines) {
        Canvas canvas = new Canvas(lines[0].length(), lines.length);
        canvas.getSize().forEachDot(
                (i, j) -> canvas.setPrintCharacter(new Coordinates(i, j),
                        lines[j].charAt(i))
        );
        return canvas;
    }

}
