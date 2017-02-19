package com.mchater.kata.marsrover.controller;

import org.junit.Test;

import com.mchater.kata.marsrover.constants.DirectionConstant;
import com.mchater.kata.marsrover.model.Grid;
import com.mchater.kata.marsrover.model.Obstacle;
import com.mchater.kata.marsrover.model.Rover;

import junit.framework.Assert;

public class RoverControllerTest {

	@Test
	public void testmoveRover() {
		Rover rover = new Rover(0, 0, DirectionConstant.NORTH);
		Grid grid = new Grid(5, 5, new Obstacle(0, 1), new Obstacle(1, 3));
		rover.getController().bind(grid);
		rover.getController().moveRover("flbr");
		Assert.assertEquals(rover.getX(), Integer.valueOf(1));
		Assert.assertEquals(rover.getY(), Integer.valueOf(0));
		Assert.assertEquals(rover.getDirection(), DirectionConstant.NORTH);
		rover.getController().moveRover("rrf");
		Assert.assertEquals(rover.getX(), Integer.valueOf(1));
		Assert.assertEquals(rover.getY(), Integer.valueOf(4));
		Assert.assertEquals(rover.getDirection(), DirectionConstant.SOUTH);
		rover.getController().moveRover("f");
		Assert.assertEquals(rover.getX(), Integer.valueOf(1));
		Assert.assertEquals(rover.getY(), Integer.valueOf(4));
		Assert.assertEquals(rover.getDirection(), DirectionConstant.SOUTH);
		rover.getController().moveRover("rffl");
		Assert.assertEquals(rover.getX(), Integer.valueOf(4));
		Assert.assertEquals(rover.getY(), Integer.valueOf(4));
		Assert.assertEquals(rover.getDirection(), DirectionConstant.SOUTH);


	}

}
