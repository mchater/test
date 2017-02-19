package com.mchater.kata.marsrover.model;

/**
 * 
 * Class Obstacle.java
 * 
 * @author mchater
 *
 */
public class Obstacle {

	/** The x. */
	private Integer x;

	/** The y. */
	private Integer y;

	public Obstacle() {
	}

	/**
	 * Instantiates a new Obstacle.
	 */
	public Obstacle(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Getter for x.
	 * 
	 * @return x
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * Setter for x.
	 * 
	 * @param x
	 *            x to define.
	 */
	public void setX(Integer x) {
		this.x = x;
	}

	/**
	 * Getter to y.
	 * 
	 * @return y
	 */
	public Integer getY() {
		return y;
	}

	/**
	 * Setter for y.
	 * 
	 * @param y
	 *            y to define
	 */
	public void setY(Integer y) {
		this.y = y;
	}
}
