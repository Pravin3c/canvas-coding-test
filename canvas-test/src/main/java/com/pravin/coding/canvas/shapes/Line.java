package com.pravin.coding.canvas.shapes;


import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.pravin.coding.canvas.CanvasProcessor;
import com.pravin.coding.canvas.actions.Action;
import com.pravin.coding.canvas.coordinates.Coordinates;
import com.pravin.coding.canvas.utils.Validation;

public class Line implements Action {
    private final Coordinates c1;
    private final Coordinates c2;
    private final char lineCharacter;

    public Line(Coordinates c1, Coordinates c2, char lineCharacter) {
        this.c1 = c1;
        this.c2 = c2;
        this.lineCharacter = lineCharacter;
    }

    public void validate(Canvas canvas) {
        Validation.validateInside(c1, canvas.getSize());
        Validation.validateInside(c2, canvas.getSize());

        if ((c1.getX() != c2.getX())
                &&
                (c1.getY() != c2.getY())) {
            throw new IllegalArgumentException("Only horizontal or vertical lines are supported");
        }

    }

    public void apply(Canvas canvas) {
        Coordinates first = new Coordinates(Math.min(c1.getX(), c2.getX()), Math.min(c1.getY(), c2.getY()));
        Coordinates second = new Coordinates(Math.max(c1.getX(), c2.getX()), Math.max(c1.getY(), c2.getY()));

        for (int x = first.getX(); x <= second.getX(); x++) {
            for (int y = first.getY(); y <= second.getY(); y++) {
                canvas.setPrintCharacter(new Coordinates(x, y), lineCharacter);
            }
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .append("c1", c1)
                .append("c2", c2)
                .append("lineCharacter", lineCharacter)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return lineCharacter == line.lineCharacter &&
                Objects.equals(c1, line.c1) &&
                Objects.equals(c2, line.c2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(c1, c2, lineCharacter);
    }

    @Override
    public void execute(CanvasProcessor processor) {
    	processor.getShapeDrawer().addAction(this);
    }

	@Override
    public Type getType() {
        return Type.DRAW;
    }
}
