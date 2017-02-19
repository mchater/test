package com.mchater.kata.marsrover.controller;

import com.mchater.kata.marsrover.constants.CommandConstant;
import com.mchater.kata.marsrover.constants.DirectionConstant;
import com.mchater.kata.marsrover.model.Grid;
import com.mchater.kata.marsrover.model.Rover;
import com.mchater.kata.marsrover.utilities.RoverUtil;

/**
 * The Class RoverController.java
 * 
 * This class aims to control a rover on predefined grid.
 * 
 * @author mchater
 * 
 */
public class RoverController {

	/** The rover. */
	private Rover rover;

	/** The grid. */
	private Grid grid;

	/**
	 * Move Rover according to the entered commands.
	 * 
	 * @param commands
	 *            A valid char sequence commands
	 */
	public void moveRover(String commands) {
		char[] array = commands.toCharArray();
		for (int i = 0; i < array.length; i++) {
			char command = array[i];
			moveTo(command);
		}
	}

	/**
	 * Move rover to a new position according to single command passed into
	 * parameter.
	 * 
	 * @param command
	 *            char to execute
	 * 
	 */
	private void moveTo(char command) {
		switch (command) {
		case CommandConstant.FORWARD:
			moveForward();
			break;
		case CommandConstant.BACKWARD:
			moveBackward();
			break;
		case CommandConstant.LEFT:
			turnLeft();
			break;
		case CommandConstant.RIGHT:
			turnRight();
			break;
		default:
			break;
		}
	}

	/**
	 * Turn the rover to the right
	 */
	private void turnRight() {
		rover.turnRight();
	}

	/**
	 * Turn the rover to the left
	 */
	private void turnLeft() {
		rover.turnLeft();
	}

	/**
	 * Move the rover backward.
	 */
	private void moveBackward() {
		Integer newPositionX = rover.getX();
		Integer newPositionY = rover.getY();
		switch (rover.getDirection()) {
		case DirectionConstant.NORTH:
			newPositionY--;
			break;
		case DirectionConstant.SOUTH:
			newPositionY++;
			break;
		case DirectionConstant.WEST:
			newPositionX++;
			break;
		case DirectionConstant.EAST:
			newPositionX--;
			break;
		default:
			break;
		}

		checkAndUpdatePositions(newPositionX, newPositionY);
	}

	/**
	 * First of all, check if rover must move from one edge to another After
	 * that, check if ther is an obstacle in the new position Obstacle detection
	 * before each move to a new square. If a given sequence of commands
	 * encounters an obstacle, the rover do not move to new positions and stops
	 * on last possible point and reports the obstacle.
	 * 
	 * @param x
	 * @param y
	 */
	private void checkAndUpdatePositions(Integer x, Integer y) {
		Integer newPositionX = simulateMoveFromOneEdgeToAnotherForX(x);
		Integer newPositionY = simulateMoveFromOneEdgeToAnotherForY(y);
		if (!grid.isObstacle(newPositionX, newPositionY)) {
			rover.move(newPositionX, newPositionY);
		} else {
			reportObstacle(newPositionX, newPositionY);
		}
	}

	/**
	 * Move from one edge to another for x position.
	 * 
	 * @param x
	 *            The x position
	 * 
	 * @return The new x position
	 */
	private Integer simulateMoveFromOneEdgeToAnotherForX(Integer x) {
		if (x < 0) {
			x = grid.getHeight() - 1;
		} else if (x >= grid.getHeight()) {
			x = 0;
		}
		return x;
	}

	/**
	 * Move from one edge to another for y position.
	 * 
	 * @param y
	 *            The y position
	 * 
	 * @return The new y position
	 */
	private Integer simulateMoveFromOneEdgeToAnotherForY(Integer y) {
		if (y < 0) {
			y = grid.getWidth() - 1;
		} else if (y >= grid.getWidth()) {
			y = 0;
		}
		return y;

	}

	/**
	 * Move the rover forward.
	 */
	private void moveForward() {
		Integer newPositionX = rover.getX();
		Integer newPositionY = rover.getY();
		switch (rover.getDirection()) {
		case DirectionConstant.NORTH:
			newPositionY++;
			break;
		case DirectionConstant.SOUTH:
			newPositionY--;
			break;
		case DirectionConstant.WEST:
			newPositionX--;
			break;
		case DirectionConstant.EAST:
			newPositionX++;
			break;
		default:
			break;
		}
		checkAndUpdatePositions(newPositionX, newPositionY);

	}

	/**
	 * Gets the rover.
	 * 
	 * @return the rover
	 */
	public Rover getRover() {
		return rover;
	}

	/**
	 * Sets the rover.
	 * 
	 * @param rover
	 *            the new rover
	 */
	public void setRover(Rover rover) {
		this.rover = rover;
	}

	/**
	 * Gets the grid.
	 * 
	 * @return the grid
	 */
	public Grid getGrid() {
		return grid;
	}

	public void bind(Grid grid) {
		this.grid = grid;
	}

	/**
	 * Report obstacle.
	 * 
	 * @param newPositionX
	 *            the new position X
	 * @param newPositionY
	 *            the new position Y
	 */
	private void reportObstacle(Integer newPositionX, Integer newPositionY) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("There is an obstacle in this position : (");
		stringBuilder.append(newPositionX);
		stringBuilder.append(",");
		stringBuilder.append(newPositionY);
		stringBuilder.append(")");
		RoverUtil.getPrinter().println(stringBuilder.toString());
	}
}
