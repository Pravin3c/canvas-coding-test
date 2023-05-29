package com.pravin.coding.canvas.shapes;

import java.util.Arrays;
import java.util.Objects;

import com.pravin.coding.canvas.coordinates.Coordinates;
import com.pravin.coding.canvas.utils.Validation;

public class Canvas {
    public static final char SPACE = ' ';
    private final char[] canvas;
    private final Coordinates size;

    public Canvas(Coordinates size) {
        this.size = size;
        canvas = new char[size.getX() * size.getY()];
        clearCanvas();
    }

    public Canvas(int x, int y) {
        this(new Coordinates(x, y));
    }

    /**
     * clear the canvas
     */
    public final void clearCanvas() {
        for (int i = 0; i < canvas.length; i++) {
            canvas[i] = SPACE;
        }
    }

    public Coordinates getSize() {
        return size;
    }

    private int at(Coordinates point) {
        return size.getX() * point.getY() + point.getX();
    }

    public char getPrintCharacter(Coordinates point) {
        Validation.validateInside(point, size);
        return canvas[at(point)];
    }

    public void setPrintCharacter(Coordinates point, char newPrintCharacter) {
        Validation.validateInside(point, size);
        canvas[at(point)] = newPrintCharacter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Canvas canvas1 = (Canvas) o;
        return Arrays.equals(canvas, canvas1.canvas) &&
                Objects.equals(size, canvas1.size);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(canvas);
        return result;
    }


    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (int j = 0; j < size.getY(); j++) {
            text.append(">").append(new String(canvas, size.getX() * j, size.getX())).append("<\r\n");
        }

        return "Canvas =" + size + "\r\n" +
                "\r\n" +
                text.toString() +
                "";
    }
}
