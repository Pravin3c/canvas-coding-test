package com.pravin.coding.canvas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pravin.coding.canvas.input.ConsoleInputCommand;
import com.pravin.coding.canvas.output.ConsoleOutputDisplay;

/**
 * Main class for canvas program
 * 
 * @author pravin
 *
 */
public class CanvasMain {

	private static final Logger log = LogManager.getLogger(CanvasMain.class);

	public static void main(String[] args) {

		try {

			runApplication();

		} catch (Exception exp) {
			log.error(exp);
		}

	}

	/**
	 * run the main application
	 */
	private static void runApplication() {
		
		ConsoleOutputDisplay consoleOutputImpl = new ConsoleOutputDisplay();
		ConsoleInputCommand consoleInputCommand = new ConsoleInputCommand();
		CanvasProcessor processor = new CanvasProcessor();
		processor.init(consoleInputCommand, consoleOutputImpl);
		processor.run();
	}

}
