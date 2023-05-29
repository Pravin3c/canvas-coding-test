package com.pravin.coding.canvas.shapes.parser;

import com.pravin.coding.canvas.actions.Action;
import com.pravin.coding.canvas.actions.CreateCanvas;
import com.pravin.coding.canvas.coordinates.Coordinates;

public class CanvasParser extends AbstractParser {
	
	 /**
     * Constructor to set command and number of parameters required for canvas draw command
     */
    public CanvasParser() {
        super("C", 2);
    }

    @Override
    protected Action parseCommand(String command, int[] params) {
        return new CreateCanvas(new Coordinates(params[0], params[1]));
    }
}