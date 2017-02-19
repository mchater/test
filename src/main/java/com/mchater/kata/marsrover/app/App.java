package com.mchater.kata.marsrover.app;

import static com.mchater.kata.marsrover.utilities.RoverUtil.prompForDirection;
import static com.mchater.kata.marsrover.utilities.RoverUtil.promptForCommands;
import static com.mchater.kata.marsrover.utilities.RoverUtil.promptForInteger;

import java.util.Scanner;

import com.mchater.kata.marsrover.model.Grid;
import com.mchater.kata.marsrover.model.Obstacle;
import com.mchater.kata.marsrover.model.Rover;
import com.mchater.kata.marsrover.utilities.RoverUtil;

/**
 * Class App.java This class is main class for Mars rover program.
 * 
 * @author mchater
 */
public class App {

	/**
	 * main method for mars rover program that prompt for suitable arguments in
	 * order to start running rover.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Integer x, y, gridWidth, gridHeight, xObstacle, yObstacle;
		String commands;
		char direction;
		Scanner scanner = new Scanner(System.in);
		x = promptForInteger(scanner, "x");
		y = promptForInteger(scanner, "y");
		direction = prompForDirection(scanner);
		gridWidth = promptForInteger(scanner, "grid width");
		gridHeight = promptForInteger(scanner, "grid height");
		xObstacle = promptForInteger(scanner, "x for obstacle");
		yObstacle = promptForInteger(scanner, "y for obstacle");
		commands = promptForCommands(scanner);
		Rover rover = new Rover(x, y, direction);
		Grid grid = new Grid(gridWidth, gridHeight,new Obstacle(xObstacle, yObstacle));
		rover.getController().bind(grid);
		rover.run(commands);
		RoverUtil.getPrinter().println("Rover is in x position: " + rover.getX());
		RoverUtil.getPrinter().println("Rover is in y position: " + rover.getY());
		RoverUtil.getPrinter().println("and rover is oriented to: " + rover.getDirection());
		scanner.close();
	}

}
