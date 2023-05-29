package com.pravin.coding.canvas.utils;

import com.pravin.coding.canvas.coordinates.Coordinates;

public final class Validation {
    private Validation() {
    }

    /**
     * validates the coordinates before printing it to console
     * @param point
     * @param border
     */
    public static void validateInside(Coordinates point, Coordinates border) {
        validatePositive(border);
        validateNonNegative(point);

        if (!point.lessThan(border)) {
            throw new IllegalArgumentException("Out of range: " + point + " should be less than " + border);
        }
    }

    public static void validateNonNegative(Coordinates point) {
        if (point.getX() < 0 || point.getY() < 0) {
            throw new IllegalArgumentException("Dimensions cannot be negative, got " + point);
        }
    }

    /**
     * 
     * @param point
     */
    public static void validatePositive(Coordinates point) {
        if (!isPositive(point)) {
            throw new IllegalArgumentException("Dimensions cannot be negative or zero, got " + point);
        }
    }

    public static boolean isPositive(Coordinates point) {
        return point.getX() > 0 && point.getY() > 0;
    }

    public static boolean isNegative(Coordinates point) {
        return point.getX() < 0 || point.getY() < 0;
    }
}

