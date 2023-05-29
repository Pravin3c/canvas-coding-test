package com.pravin.coding.canvas.output;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pravin.coding.canvas.coordinates.Coordinates;
import com.pravin.coding.canvas.shapes.Canvas;
import com.pravin.coding.canvas.utils.ShapeDrawer;

public class ConsoleOutputDisplay {
	
	private static final Logger log = LogManager.getLogger(ConsoleOutputDisplay.class);

	private StringBuilder builder = new StringBuilder();

	public ConsoleOutputDisplay() {

	}

	/**
	 * print the required object canvas/line/rectangle to console
	 * @param drawer
	 */
	public void printOutput(ShapeDrawer drawer) {
		builder = new StringBuilder();
		builder.setLength(0);
		Canvas canvas = drawer.getCanvas();
		Coordinates size = canvas.getSize();
		
		size.shift(2, 2).forEachDot((i, j) -> {
			builder.append(getCharAt(i, j, canvas));
			if (i == size.getX() + 1 && j != size.getY() + 1) {
				builder.append(System.lineSeparator());
			}
		});

		log.debug("New Canvas Image: {} {}", System.lineSeparator(), builder.toString());
		System.out.println(builder.toString());

	}

	private char getCharAt(int i, int j, Canvas canvas) {
		if (j == 0 || j == canvas.getSize().getY() + 1) {
			return '-';
		}
		if (i == 0 || i == canvas.getSize().getX() + 1) {
			return '|';
		}
		return canvas.getPrintCharacter(new Coordinates(i - 1, j - 1));
	}
	
	public String getString() {
        return builder.toString();
    }

}
