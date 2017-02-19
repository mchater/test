package com.mchater.kata.marsrover.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Class Grid.java
 * 
 * @author mchater
 *
 */
public class Grid {

	/** The width. */
	private Integer width;

	/** The height. */
	private Integer height;

	/** The squares. */
	Map<String, Square> squares = new HashMap<String, Square>();

	/** The obstacles. */
	private List<Obstacle> obstacles = new ArrayList<Obstacle>();

	/**
	 * Instantiates a new Grid.
	 * 
	 * @param x
	 *            the width
	 * @param y
	 *            the height
	 * @param obstacles
	 *            the obstacles
	 */
	public Grid(Integer width, Integer height, Obstacle... obstacles) {
		this.width = width;
		this.height = height;
		initSquares(width, height);
		addObstacles(obstacles);
	}

	/**
	 * add obstacles
	 * 
	 * @param obstacles
	 */
	private void addObstacles(Obstacle... obstacles) {
		for (int i = 0; i < obstacles.length; i++) {
			Obstacle obstacle = obstacles[i];
			if (obstacle.getX() < width || obstacle.getY() > height) {
				squares.get(obstacle.getX() + ":" + obstacle.getY()).setObstacle(true);
			}
		}
	}

	/**
	 * init the squares with the width and the height of the grid
	 * 
	 * @param width
	 *            The width of the grid
	 * @param height
	 *            The height of the grid
	 */
	private void initSquares(Integer width, Integer height) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Square square = new Square(i, j);
				squares.put(i + ":" + j, square);
			}
		}
	}

	/**
	 * Getter to obstacles.
	 * 
	 * @return obstacles
	 */
	public List<Obstacle> getObstacles() {
		return obstacles;
	}

	/**
	 * 
	 * @param x
	 *            The x position
	 * @param y
	 *            The x position
	 * @return
	 *         <p>
	 *         True, if there is an obstacle in this position False, otherwise.
	 */
	public boolean isObstacle(int x, int y) {
		return squares.get(x + ":" + y).isObstacle();
	}

	/**
	 * Getter to width.
	 * 
	 * @return width
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * Setter for width.
	 * 
	 * @param width
	 *            width to define
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * Getter to height.
	 * 
	 * @return height
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * Setter for height.
	 * 
	 * @param height
	 *            height to define
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}
}
