package com.mchater.kata.marsrover.model;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class GridTest {

	@Test
	public void testIsObstacle() {
		Map<String, Square> squares = new HashMap<String, Square>();
		int width = 3;
		int height = 3;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Square square = new Square(i, j);
				squares.put(i + ":" + j, square);
			}
		}
		squares.get(0 + ":" + 1).setObstacle(true);
		Assert.assertTrue(squares.get(0 + ":" + 1).isObstacle());
		Assert.assertFalse(squares.get(2 + ":" + 1).isObstacle());
	}

}
