package com.pravin.coding.canvas.shapes.parser;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pravin.coding.canvas.actions.Action;
import com.pravin.coding.canvas.actions.ErrorAction;
import com.pravin.coding.canvas.coordinates.Coordinates;

public abstract class AbstractParser implements ActionParser {
	
	public static final Coordinates OFFSET = new Coordinates(-1, -1);
    private static final Logger log = LogManager.getLogger(AbstractParser.class);
    private final String command;
    private final int paramCount;
    
	public AbstractParser(String command, int paramCount) {
		super();
		this.command = command;
		this.paramCount = paramCount;
	}
	
	/**
	 * parse each parser for input command 
	 */
    public Action parseEachParser(String inputCommand) {
        if (StringUtils.isBlank(inputCommand)) {
            log.debug("command is blank");
            return null;
        }
        String[] splitCommand = StringUtils.split(inputCommand, " ");
        if (!command.equals(splitCommand[0])) {
            return null;
        }
        if (splitCommand.length != paramCount + 1) {
            log.error("Command {} - wrong params", inputCommand);
            return new ErrorAction("Expected " + paramCount + " params for command " + command + " but got " + (splitCommand.length - 1));
        }

        return parseCommand(splitCommand);
    }
    
    /**
     * parse each parser for input command 
     * 
     * @param splitCommand
     * @return
     */
    protected Action parseCommand(String[] splitCommand) {
        try {
            int[] params = Arrays.stream(splitCommand).skip(1).mapToInt(Integer::valueOf).toArray();

            return parseCommand(splitCommand[0], params);
            
        } catch (NumberFormatException e) {
            log.error("Bad number format", e);
            return new ErrorAction("Cannot parse int value: " + e.getMessage());
        }

    }
    
    protected abstract Action parseCommand(String command, int[] params);

}
