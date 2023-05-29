package com.pravin.coding.canvas.input;

import java.util.Optional;
import java.util.Scanner;

public class ConsoleInputCommand {

	public static final String ENTER_COMMAND = "enter command : ";
	private final Scanner scanner;

	public ConsoleInputCommand() {
		scanner = new Scanner(System.in);
	}

	/**
	 * takes the input from console 
	 * @return Optional<String>
	 */
	public Optional<String> getNextCommand() {
		System.out.println("");
		System.out.print(ENTER_COMMAND);
		Optional<String> readCommand = Optional.ofNullable(scanner.nextLine());
		return readCommand;
	}
}
