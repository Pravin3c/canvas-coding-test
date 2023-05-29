package com.pravin.coding.canvas.shapes.parser;

import com.pravin.coding.canvas.actions.Action;
import com.pravin.coding.canvas.shapes.Quit;

public class QuitParser extends AbstractParser {
	
	 /**
     * Constructor to set command and number of parameters required for Quit command
     */
    public QuitParser() {
        super("Q", 0);
    }

	@Override
	protected Action parseCommand(String command, int[] params) {
		return new Quit();
	}
}
