package com.pravin.coding.canvas.output;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pravin.coding.canvas.actions.Action;
import com.pravin.coding.canvas.coordinates.Coordinates;
import com.pravin.coding.canvas.shapes.Canvas;
import com.pravin.coding.canvas.shapes.Line;
import com.pravin.coding.canvas.shapes.Rectangle;
import com.pravin.coding.canvas.shapes.parser.AbstractParser;
import com.pravin.coding.canvas.utils.ShapeDrawer;


public class ConsoleOutputImplTest {

    private  ConsoleOutputDisplay consoleOutputImpl = new ConsoleOutputDisplay();
    private ShapeDrawer shapeDrawer = new ShapeDrawer(new Canvas(20, 4));


    @Test
    public void consoleDisplayTest() {

    	assertOutputDisplay("----------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------");

        withCommand(new Line(new Coordinates(1, 2).shift(AbstractParser.OFFSET), new Coordinates(6, 2).shift(AbstractParser.OFFSET), 'x'));
        assertOutputDisplay(
                "----------------------\n" +
                        "|                    |\n" +
                        "|xxxxxx              |\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "----------------------");

        withCommand(new Line(new Coordinates(6, 3).shift(AbstractParser.OFFSET), new Coordinates(6, 4).shift(AbstractParser.OFFSET), 'x'));
        assertOutputDisplay(
                "----------------------\n" +
                        "|                    |\n" +
                        "|xxxxxx              |\n" +
                        "|     x              |\n" +
                        "|     x              |\n" +
                        "----------------------");

        withCommand(new Rectangle(new Coordinates(14, 1).shift(AbstractParser.OFFSET), new Coordinates(18, 3).shift(AbstractParser.OFFSET), 'x'));
        assertOutputDisplay(
                "----------------------\n" +
                        "|             xxxxx  |\n" +
                        "|xxxxxx       x   x  |\n" +
                        "|     x       xxxxx  |\n" +
                        "|     x              |\n" +
                        "----------------------");
                        
    }

    private void withCommand(Action action) {
    	shapeDrawer.addAction(action);
    }

    private void assertOutputDisplay(String expected) {
    	
    	consoleOutputImpl.printOutput(shapeDrawer);
        String actual = consoleOutputImpl.getString();
     
        assertEquals(expected, actual.replace("\r\n", "\n"));
    }

}