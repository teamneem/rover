package neem.rover;

import static org.junit.Assert.*;

import neem.rover.Rover;

import org.junit.Test;

public class roverTest {


	Rover marsrover = new Rover(10, 10, 5, 5, 'N', "MLMRMLRM");
	Rover marsrover2 = new Rover(10, 10, 15, 15, 'E', "MLRMLRMRMM");
	Rover marsrover3 = new Rover(5, 5, 0, 0, 'W', "MLRLRM");
	Rover marsrover4 = new Rover(5, 5, 2, 2, 'N', "MLMRMR");
	Rover marsrover5 = new Rover(5, 5, 2, 2, 'N', "MLMRMR");
	Rover marsrover6 = new Rover(10, 10, 5, 5, 'N', "MLMRMLRM");
	Rover marsrover7 = new Rover(10, 10, 15, 15, 'E', "MLRMLRMRMM");

	@Test
	public final void testGetX() {
		assertEquals("X position", 5, marsrover.getX());
		//Tests to make sure that too large of an X input gets reset to maxX value
		assertEquals("X position", 10, marsrover2.getX());
	}

	@Test
	public final void testGetY() {
		assertEquals("Y position", 5, marsrover.getY());
		//Tests to make sure that too large of an Y input gets reset to maxY value
		assertEquals("Y position", 10, marsrover2.getY());
	}

	@Test
	public final void testGetDirection() {
		assertEquals("Direction", 'N', marsrover.getDirection());
		assertEquals("Direction", 'E', marsrover2.getDirection());
	}

	@Test
	public final void testMoveRover() {
		marsrover.moveRover();
		assertEquals("Move rover", 8, marsrover.getY());
		assertEquals("Move rover", 4, marsrover.getX());
		assertEquals("Move rover", 'N', marsrover.getDirection());
		
		marsrover2.moveRover();
		assertEquals("Move rover", 8, marsrover2.getY());
		assertEquals("Move rover", 10, marsrover2.getX());
		assertEquals("Move rover", 'S', marsrover2.getDirection());
		
		marsrover3.moveRover();
		assertEquals("Move rover", 0, marsrover3.getY());
		assertEquals("Move rover", 0, marsrover3.getX());
		assertEquals("Move rover", 'W', marsrover3.getDirection());
		
		//Manually moving one rover
		marsrover4.moveForward();
		marsrover4.leftDirection();
		marsrover4.moveForward();
		marsrover4.rightDirection();
		marsrover4.moveForward();
		marsrover4.rightDirection();	
		
		//Using class to move identical rover
		marsrover5.moveRover();
		
		//Asserting that manually moving rover and using moveRover class have identical results
		assertEquals("Move rover", 4, marsrover4.getY());
		assertEquals("Move rover", 1, marsrover4.getX());
		assertEquals("Move rover", 'E', marsrover4.getDirection());
		assertEquals("Move rover", marsrover5.getY(), marsrover4.getY());
		assertEquals("Move rover", marsrover5.getX(), marsrover4.getX());
		assertEquals("Move rover", marsrover5.getDirection(), marsrover4.getDirection());
	}

	@Test
	public final void testMoveForward() {
		marsrover6.moveForward();
		assertEquals("Move Forward", 6, marsrover6.getY());
		assertEquals("Move Forward", 5, marsrover6.getX());
		
		//Checks to make sure that moving forward when it moves the rover out of bounds does not work
		marsrover7.moveForward();
		assertEquals("Move Forward", 10, marsrover7.getY());
		assertEquals("Move Forward", 10, marsrover7.getX());
		
		//Checks to make sure that moving forward when it moves the rover out of bounds does not work
		marsrover7.direction = 'N';
		marsrover7.moveForward();
		assertEquals("Move Forward", 10, marsrover7.getY());
		assertEquals("Move Forward", 10, marsrover7.getX());
		
		
		//Checks to make sure that moving forward when it moves the rover out of bounds does not work
		marsrover3.moveForward();
		assertEquals("Move Forward", 0, marsrover3.getY());
		assertEquals("Move Forward", 0, marsrover3.getX());
		
		//Checks to make sure that moving forward when it moves the rover out of bounds does not work
		marsrover3.direction = 'S';
		marsrover3.moveForward();
		assertEquals("Move Forward", 0, marsrover3.getY());
		assertEquals("Move Forward", 0, marsrover3.getX());
	}

	@Test
	public final void testLeftDirection() {
		marsrover.direction =  'N';
		marsrover.leftDirection();
		assertEquals("Left direction", 'W', marsrover.getDirection());
		
		marsrover.direction =  'E';
		marsrover.leftDirection();
		assertEquals("Left direction", 'N', marsrover.getDirection());
		
		marsrover.direction =  'S';
		marsrover.leftDirection();
		assertEquals("Left direction", 'E', marsrover.getDirection());
		
		marsrover.direction =  'W';
		marsrover.leftDirection();
		assertEquals("Left direction", 'S', marsrover.getDirection());
	}

	@Test
	public final void testRightDirection() {
		marsrover.direction =  'N';
		marsrover.rightDirection();
		assertEquals("Right direction", 'E', marsrover.getDirection());
		
		marsrover.direction =  'E';
		marsrover.rightDirection();
		assertEquals("Right direction", 'S', marsrover.getDirection());
		
		marsrover.direction =  'S';
		marsrover.rightDirection();
		assertEquals("Right direction", 'W', marsrover.getDirection());
		
		marsrover.direction =  'W';
		marsrover.rightDirection();
		assertEquals("Right direction", 'N', marsrover.getDirection());
	}


}
