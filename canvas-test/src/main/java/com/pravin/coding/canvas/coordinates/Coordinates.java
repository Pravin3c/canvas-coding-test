package com.pravin.coding.canvas.coordinates;

import java.util.Objects;
import java.util.function.BiConsumer;



public class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates coordinates  = (Coordinates) o;
        return x == coordinates.x &&
                y == coordinates.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return x + "x" + y;
    }

    public boolean lessThan(Coordinates dimensions) {
        return x < dimensions.x && y < dimensions.y;
    }

    /**
     * process every dot, starting from 0-0 over every column and then over every row to the x, y
     *
     * @param consumer
     */
    public void forEachDot(BiConsumer<Integer, Integer> consumer) {
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                consumer.accept(i, j);
            }
        }
    }

    public Coordinates shift(int x, int y) {
        return new Coordinates(this.x + x, this.y + y);
    }

    public Coordinates shift(Coordinates offset) {
        return new Coordinates(this.x + offset.x, this.y + offset.y);
    }
}
