package neem.rover;

class Rover 
{
	int maxX;
	int maxY;
	int x;
	int y;
	char direction;
	String movement;
	
	public Rover(int worldX, int worldY, int startX, int startY, char startDirection, String movementString) 
	{
		maxX = worldX;
        maxY = worldY;		
        
		if (startX > maxX)
		{
			System.err.println("Initial coordinates outside of plateau on X axis");
			x = maxX;
		}
		else
		{
			x = startX;
		}
		
		if (startY > maxY)
		{
			System.err.println("Initial coordinates outside of plateau on Y axis");
			y = maxY;
		}
		else
		{
	        y = startY;
		}

        direction = startDirection;
        movement = movementString;
    }

	public int getX() 
	{
		return x;
	}
	
	public int getY() 
	{
		return y;
	}
	
	public char getDirection() 
	{
		return direction;
	}
	
	void moveRover()
	{
		/**
		 * moveRover function takes movement line, parses it into characters
		 * 'M', 'L', and 'R' call other functions to make the rover move
		 */
		char[] movementArray = movement.toCharArray();
		int size = movementArray.length;
		for(int i=0; i<size; i++)
		{
			char currentInstruction = movementArray[i];
			switch (currentInstruction)
			{
				case 'M': 
					moveForward();
					break;
				case 'L': 
					leftDirection();
					break;
				case 'R':
					rightDirection();
					break;
			
			}
		}
	}


	void moveForward() 
	{
		/**
		 * moveForward function is called when there is the command 'M'
		 * Depending on the direction, it moves the rover
		 * If the rover is on the edge of the plateau, it will not move, instead error message
		 */
		switch (direction)
		{
			case 'N':
				if (y < maxY)
				{
					y++;
					break;
				}
				else
				{
					System.err.println("Can't move off plateau, location is: " + x + ", " + y);
					break;
				}
			case 'E':
				if (x < maxX)
				{
					x++;
					break;
				}
				else
				{
					System.err.println("Can't move off plateau, location is: " + x + ", " + y);
					break;
				}
			case 'S':
				if (y > 0)
				{
					y--;
					break;
				}
				else
				{
					System.err.println("Can't move off plateau, location is: " + x + ", " + y);
					break;
				}
			case 'W':
				if (x > 0)
				{
					x--;
					break;
				}
				else
				{
					System.err.println("Can't move off plateau, location is: " + x + ", " + y);
					break;
				}
		}
	}

	void leftDirection() 
	{
		/**
		 * Changes the direction of the rover by moving it to the left
		 */
		switch (direction)
		{
			case 'N':
				direction = 'W';
				break;
			case 'E':
				direction = 'N';
				break;
			case 'S':
				direction = 'E';
				break;
			case 'W':
				direction = 'S';
				break;
		}
	}

	void rightDirection() 
	{
		/**
		 * Changes the direction of the rover by moving it to the right
		 */
		switch (direction)
		{
			case 'N':
				direction = 'E';
				break;
			case 'E':
				direction = 'S';
				break;
			case 'S':
				direction = 'W';
				break;
			case 'W':
				direction = 'N';
				break;
		}	
	}
	
	
}