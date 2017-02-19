package com.mchater.kata.marsrover.model;

/**
 * Class Square.java
 * 
 * @author mchater
 */
public class Square {

	/** The x. */
	private int x;

	/** The y. */
	private int y;

	/** The isObstacle. */
	private boolean isObstacle = false;

	public Square(int x, int y) {

	}

	/**
	 * Getter to x.
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Setter for x.
	 * 
	 * @param x
	 *            x to define
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Getter to y.
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Setter for y.
	 * 
	 * @param y
	 *            y to define
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Getter to isObstacle.
	 * 
	 * @return isObstacle
	 */
	public boolean isObstacle() {
		return isObstacle;
	}

	/**
	 * Setter for isObstacle.
	 * 
	 * @param isObstacle
	 *            isObstacle to define
	 */
	public void setObstacle(boolean isObstacle) {
		this.isObstacle = isObstacle;
	}
}
