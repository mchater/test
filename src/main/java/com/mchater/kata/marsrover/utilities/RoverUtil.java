package com.mchater.kata.marsrover.utilities;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * RoverUtil.java
 * 
 * Utility class that defines several static methods that are useful for running
 * mars rover program
 * 
 * @author mchater
 *
 */
public final class RoverUtil {

	private RoverUtil() {

	}

	/**
	 * Prompt from a scanner for a valid commands.
	 * 
	 * Commands should match regular expression [l|r|f|b]* format.
	 * <p>
	 * 'l': for left
	 * </p>
	 * 
	 * <p>
	 * 'r': for right
	 * </p>
	 * 
	 * 
	 * <p>
	 * 'f': for forward
	 * </p>
	 * 
	 * 
	 * <p>
	 * 'b': for backward
	 * </p>
	 * 
	 * @param scanner
	 *            scanner used to gather user input.
	 * @return A valid char sequence for commands.
	 */
	public static String promptForCommands(Scanner scanner) {
		String commands;
		System.out.println("Enter commands characters");
		commands = scanner.nextLine();

		while (!checkCommand(commands)) {
			System.out.println(
					"Commands entered are wrong ! commands characters should only contains l,r,b or f: (Eg: lrfbllrrffff)");
			commands = scanner.nextLine();
		}
		return commands;
	}

	/**
	 * Prompt from a scanner for a valid integer.
	 * 
	 * @param scanner
	 *            scanner used to gather user input.
	 * @param Parameter
	 *            name
	 * @return A valid integer.
	 */
	public static Integer promptForInteger(Scanner scanner, String param) {
		String x;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Enter initial ");
		stringBuilder.append(param);
		String firstMessage = stringBuilder.toString();
		System.out.println(firstMessage);
		x = scanner.nextLine();
		stringBuilder = new StringBuilder();
		stringBuilder.append("Enter initial ");
		stringBuilder.append(param);
		String errorMessage = stringBuilder.toString();
		while (!isInteger(x)) {
			System.out.println(errorMessage);
			x = scanner.nextLine();
		}
		return Integer.parseInt(x);
	}

	/**
	 * Check if string passed into parameter is a valid Integer or not.
	 * 
	 * @param parameter
	 *            to parse
	 * @return
	 *         <p>
	 *         True, if input is a valid integer
	 *         </p>
	 *         False, otherwise.
	 */
	public static boolean isInteger(String parameter) {
		String regex = "\\d+";
		Pattern.compile(regex);
		return Pattern.matches(regex, parameter);
	}

	/**
	 * Check if commands passed into parameter is a valid command or not.
	 * 
	 * @param commands
	 *            to check
	 * @return
	 *         <p>
	 *         True, if input is a valid char sequence of commands. Valid
	 *         commands should match [l|r|f|b]* regular expression.
	 *         </p>
	 *         False, otherwise.
	 */
	public static boolean checkCommand(String commands) {
		commands = commands.toLowerCase();
		String regex = "[l|r|b|f]*";
		Pattern.compile(regex);
		return Pattern.matches(regex, commands);
	}

	/**
	 * Prompt for direction.
	 * 
	 * @param scanner
	 * @return A valid direction.
	 */
	public static char prompForDirection(Scanner scanner) {
		String direction;
		System.out.println("Enter initial direction:  ");
		direction = scanner.nextLine();
		while (!isDirection(direction)) {
			System.out.println("Initial direction is wrong. It should be either N,S,E or W  ");
			direction = scanner.nextLine();
		}
		return direction.toUpperCase().charAt(0);
	}

	/**
	 * Check that string passed into parameter is a valid direction
	 * 
	 * @return
	 *         <p>
	 *         True, if input is a valid direction.
	 *         </p>
	 *         False, otherwise.
	 *
	 */
	public static boolean isDirection(String direction) {
		String regex = "[N|S|E|W]";
		Pattern.compile(regex);
		return Pattern.matches(regex, direction.toUpperCase());
	}

	public static PrintStream getPrinter() {
		return System.out;
	}

	public static void print(String message) {
		getPrinter().println(message);
	}
}
