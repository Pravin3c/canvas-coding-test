package com.pravin.coding.canvas.shapes;


import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.pravin.coding.canvas.CanvasProcessor;
import com.pravin.coding.canvas.actions.Action;
import com.pravin.coding.canvas.actions.Action.Type;
import com.pravin.coding.canvas.coordinates.Coordinates;

public class Rectangle implements Action {

    private final List<Line> lines;
    private final Coordinates c1;
    private final Coordinates c2;
    private final char rectCharacter;

    public Rectangle(Coordinates c1, Coordinates c2, char rectCharacter) {
        this.c1 = c1;
        this.c2 = c2;
        this.rectCharacter = rectCharacter;

        Coordinates v3 = new Coordinates(c1.getX(), c2.getY());
        Coordinates v4 = new Coordinates(c2.getX(), c1.getY());

        lines = Arrays.asList(
                new Line(c1, v3, rectCharacter),
                new Line(c1, v4, rectCharacter),
                new Line(c2, v3, rectCharacter),
                new Line(c2, v4, rectCharacter)
        );
    }

    @Override
    public void validate(Canvas canvas) {
        lines.forEach(l -> l.validate(canvas));
    }

    @Override
    public void apply(Canvas canvas) {
        lines.forEach(l -> l.apply(canvas));
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .append("lines", lines)
                .append("c1", c1)
                .append("c2", c2)
                .append("rectCharacter", rectCharacter)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return rectCharacter == rectangle.rectCharacter &&
                Objects.equals(lines, rectangle.lines) &&
                Objects.equals(c1, rectangle.c1) &&
                Objects.equals(c2, rectangle.c2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lines, c1, c2, rectCharacter);
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
