package com.pravin.coding.canvas;

import java.util.Arrays;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pravin.coding.canvas.actions.Action;
import com.pravin.coding.canvas.actions.ErrorAction;
import com.pravin.coding.canvas.input.ConsoleInputCommand;
import com.pravin.coding.canvas.output.ConsoleOutputDisplay;
import com.pravin.coding.canvas.shapes.parser.CanvasParser;
import com.pravin.coding.canvas.shapes.parser.LineParser;
import com.pravin.coding.canvas.shapes.parser.Parser;
import com.pravin.coding.canvas.shapes.parser.QuitParser;
import com.pravin.coding.canvas.shapes.parser.RectangleParser;
import com.pravin.coding.canvas.utils.ShapeDrawer;

public class CanvasProcessor {

	private static final Logger log = LogManager.getLogger(CanvasProcessor.class);

	private ConsoleInputCommand consoleInputCommand;
	private Parser parser;
	private ConsoleOutputDisplay consoleOutputDisplay;
	private ShapeDrawer shapeDrawer;
	private boolean isCompleted = false;
	private boolean initialized = false;

	/**
	 * initialize the Processor with ConsoleOutput and ConsoleInputCommand
	 * 
	 * @param consoleInputCommand
	 * @param consoleOutputImpl
	 */
	public void init(ConsoleInputCommand consoleInputCommand, ConsoleOutputDisplay consoleOutputDisplay) {
		this.consoleInputCommand = consoleInputCommand;
		this.parser = createParser();
		this.consoleOutputDisplay = consoleOutputDisplay;
		isCompleted = false;
		initialized = true;
	}

	/**
	 * process the request via input command entered from console
	 */
	public void run() {

		if (!initialized) {
			log.error("ActionsProcessor is not initialized");
			throw new IllegalStateException("Init application first!");
		}

		while (!isCompleted) {
			Optional<String> command = consoleInputCommand.getNextCommand();
			if (!command.isPresent()) {
				log.error("No new commands, exiting");
				break;
			} else {
				process(command.get());
			}
		}
	}

	/**
	 * process the request via input command entered from console
	 * 
	 * @param command
	 */
	private void process(String command) {
		log.info("entered command {}", command);
		Action action = parser.parse(command);

		if (action.getType() == Action.Type.DRAW && shapeDrawer == null) {
			log.error("Canvas is not initialized");
			new ErrorAction("Canvas is not initialized").execute(this);
		} else {
			log.info("executing command {} as {}", command, action);
			try {
				action.execute(this);
			} catch (Exception e) {
				log.error("executing command {} as ", command, action);
				new ErrorAction("Error while executing command: " + command + " " + e.getMessage()).execute(this);
			}

		}
		if (shapeDrawer != null && !isCompleted) {
			consoleOutputDisplay.printOutput(shapeDrawer);
		}
	}

	/**
	 * quit the program/application is Q is entered from console input
	 */
	public void quit() {
		log.error("Quit");
		isCompleted = true;
	}

	public ShapeDrawer getShapeDrawer() {
		return shapeDrawer;
	}

	/**
	 * set the ShapeDrawer object
	 * 
	 * @param shapeDrawer
	 */
	public void setDrawer(ShapeDrawer shapeDrawer) {
		log.error("ShapeDrawer set");
		this.shapeDrawer = shapeDrawer;
	}

	/**
	 * create a list of parser(line, rectangle, canvas, quit)
	 * 
	 * @return
	 */
	private Parser createParser() {
		return new Parser(Arrays.asList(new LineParser(), new RectangleParser(), new QuitParser(), new CanvasParser()));
	}

	public Parser getParser() {
		return parser;
	}

}
