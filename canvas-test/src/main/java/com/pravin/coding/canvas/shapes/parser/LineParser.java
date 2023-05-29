package com.pravin.coding.canvas.shapes.parser;

import com.pravin.coding.canvas.actions.Action;
import com.pravin.coding.canvas.coordinates.Coordinates;
import com.pravin.coding.canvas.shapes.Line;

public class LineParser extends AbstractParser {

    private static final char lineCharacter = 'x';

    /**
     * Constructor to set command and number of parameters required for Line command
     */
    public LineParser() {
        super("L", 4);
    }

    @Override
    protected Action parseCommand(String command, int[] params) {
        return new Line(new Coordinates(params[0], params[1]).shift(OFFSET), new Coordinates(params[2], params[3]).shift(OFFSET), lineCharacter);
    }
}
