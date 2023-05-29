package com.pravin.coding.canvas.shapes;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;
import com.pravin.coding.canvas.coordinates.Coordinates;
import com.pravin.coding.canvas.utils.CommonUtilTest;

public class CanvasTest {

    @Test
    public void testPoint() {
        Canvas c = new Canvas(4, 3);
        c.setPrintCharacter(new Coordinates(1, 2), 'X');
        Canvas expected = CommonUtilTest.createCanvas(
                "    ",
                "    ",
                " X  ");
        assertEquals(expected.toString(), c.toString());
    }

    @Test
    public void testPoint2() {
        Canvas c = new Canvas(3, 5);
        c.setPrintCharacter(new Coordinates(1, 2), 'X');
        Canvas expected = CommonUtilTest.createCanvas(
                "   ",
                "   ",
                " X ",
                "   ",
                "   ");
        assertEquals(expected, c);
    }

    @Test
    public void testClear() {
        Canvas c = CommonUtilTest.createCanvas(
                "X  ",
                " X ",
                "   ");

        c.clearCanvas();

        Assert.assertEquals(CommonUtilTest.createCanvas(
                "   ",
                "   ",
                "   "), c);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotSetPointAtBorder() {
        Canvas c = new Canvas(3, 3);
        c.setPrintCharacter(new Coordinates(3, 0), 'X');
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNegativeArgs() {
        Canvas c = new Canvas(3, 3);
        c.setPrintCharacter(new Coordinates(-1, 0), 'X');
    }


}
