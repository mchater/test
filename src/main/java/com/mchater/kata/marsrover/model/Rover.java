package com.mchater.kata.marsrover.model;

import com.mchater.kata.marsrover.constants.DirectionConstant;
import com.mchater.kata.marsrover.controller.RoverController;

/**
 * The Class Rover.
 * 
 * @author mchater
 * 
 */
public class Rover {

	/** The x. */
	private Integer x;

	/** The y. */
	private Integer y;

	/** The direction. */
	private char direction;

	/** The controller. */
	private RoverController controller;

	/**
	 * Instantiates a new rover.
	 */
	public Rover() {
	}

	/**
	 * Instantiates a new rover.
	 * 
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param direction
	 *            the direction
	 */
	public Rover(Integer x, Integer y, char direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	/**
	 * Move the rover to the new position.
	 * 
	 */
	public void move(Integer newPositionX, Integer newPositionY) {
		x = newPositionX;
		y = newPositionY;
	}

	/**
	 * Turn the Rover to the left
	 */
	public void turnLeft() {
		switch (direction) {
		case DirectionConstant.NORTH:
			direction = DirectionConstant.WEST;
			break;
		case DirectionConstant.SOUTH:
			direction = DirectionConstant.EAST;
			break;
		case DirectionConstant.WEST:
			direction = DirectionConstant.SOUTH;
			break;
		case DirectionConstant.EAST:
			direction = DirectionConstant.NORTH;
			break;
		default:
			break;
		}
	}

	/**
	 * Turn the rover to the right
	 */
	public void turnRight() {
		switch (direction) {
		case DirectionConstant.NORTH:
			direction = DirectionConstant.EAST;
			break;
		case DirectionConstant.SOUTH:
			direction = DirectionConstant.WEST;
			break;
		case DirectionConstant.WEST:
			direction = DirectionConstant.NORTH;
			break;
		case DirectionConstant.EAST:
			direction = DirectionConstant.SOUTH;
			break;
		default:
			break;
		}

	}

	/**
	 * Get the controller
	 * 
	 * @return controller
	 */
	public RoverController getController() {
		if (controller == null) {
			controller = new RoverController();
			controller.setRover(this);
		}
		return controller;
	}

	/**
	 * run the rover
	 * 
	 * @param commands
	 */
	public void run(String commands) {
		if (controller != null) {
			controller.moveRover(commands);
		}
	}

	/**
	 * Gets the x.
	 * 
	 * @return the x
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * Sets the x.
	 * 
	 * @param x
	 *            the new x
	 */
	public void setX(Integer x) {
		this.x = x;
	}

	/**
	 * Gets the y.
	 * 
	 * @return the y
	 */
	public Integer getY() {
		return y;
	}

	/**
	 * Sets the y.
	 * 
	 * @param y
	 *            the new y
	 */
	public void setY(Integer y) {
		this.y = y;
	}

	/**
	 * Gets the direction.
	 * 
	 * @return the direction
	 */
	public char getDirection() {
		return direction;
	}

	/**
	 * Sets the direction.
	 * 
	 * @param direction
	 *            the new direction
	 */
	public void setDirection(char direction) {
		this.direction = direction;
	}

}
