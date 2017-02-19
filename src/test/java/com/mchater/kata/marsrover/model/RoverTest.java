package com.mchater.kata.marsrover.model;

import org.junit.Test;

import com.mchater.kata.marsrover.constants.DirectionConstant;

import junit.framework.Assert;

public class RoverTest {

	@Test
	public void testMove() {
		Integer newPositionX = 3;
		Integer newPositionY = 2;
		Rover rover = new Rover(2, 2, DirectionConstant.EAST);
		rover.move(newPositionX, newPositionY);
		Assert.assertEquals(rover.getX(), Integer.valueOf(3));
		Assert.assertEquals(rover.getY(), Integer.valueOf(2));
		Assert.assertEquals(rover.getDirection(), DirectionConstant.EAST);
	}

	@Test
	public void testTurnLeft() {
		Rover rover = new Rover(3, 2, DirectionConstant.EAST);
		rover.turnLeft();
		Assert.assertEquals(rover.getDirection(), DirectionConstant.NORTH);
		rover.turnLeft();
		Assert.assertEquals(rover.getDirection(), DirectionConstant.WEST);
		rover.turnLeft();
		Assert.assertEquals(rover.getDirection(), DirectionConstant.SOUTH);
		rover.turnLeft();
		Assert.assertEquals(rover.getDirection(), DirectionConstant.EAST);
	}

	@Test
	public void testTurnRight() {
		Rover rover = new Rover(2, 2, DirectionConstant.NORTH);
		rover.turnRight();
		Assert.assertEquals(rover.getDirection(), DirectionConstant.EAST);
		rover.turnRight();
		Assert.assertEquals(rover.getDirection(), DirectionConstant.SOUTH);
		rover.turnRight();
		Assert.assertEquals(rover.getDirection(), DirectionConstant.WEST);
		rover.turnRight();
		Assert.assertEquals(rover.getDirection(), DirectionConstant.NORTH);
	}

}
