package neem.rover;

import java.io.*;
import java.util.Scanner;

public class roverIO 
{
	/**
	 * Takes in user supplied data file, computes and then outputs rover location
	 * @throws FileNotFoundException 
	 */
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		/**Takes in file name from user, opens file if it exists
		 * If file does not exist, FileNotFoundException occurs
		 * Assumes that the file is properly formatted (first line being world size,
		 * second line being rover initial coordinates, third line being movement, etc.)
		 */
		Scanner userFile = new Scanner(System.in);
		System.out.print( "Enter the filename: " );
		String fileName = userFile.nextLine();
		File file = new File( fileName );

		if ( file.exists() )  
		{
			Scanner inFile = new Scanner( file );
			/**
			 * Takes in first line from the file and parses it into the max X and max Y 
			 * coordinate for the plateau
			 */
			String worldSize = inFile.nextLine();
			String[] sizes = worldSize.split("\\s+");
			int maxX = Integer.parseInt(sizes[0]);
			int maxY = Integer.parseInt(sizes[1]);			

			// hasNext allows us to read the next line of the file until we hit end of file
			while ( inFile.hasNext() )
			{	
				/**
				 * Takes in two lines from the file
				 * initialLine = initial coordinates and the direction of the rover
				 * movementLine = how the rover is supposed to move
				 */
				String initialLine = inFile.nextLine();
				String movementLine = inFile.nextLine();
				
				/**
				 * Splits the initial line into the initial X and Y coordinates and the
				 * initial direction of the rover
				 */
				String[] initSplit = initialLine.split("\\s+");
				int initX = Integer.parseInt(initSplit[0]);
				int initY = Integer.parseInt(initSplit[1]);
				
				/**
				 * If the initial rover coordinates are outside of the world, throw error
				 * Reset initial coordinates to be at the boundary (maxX or maxY)
				 */
				
				char initDirection = initSplit[2].charAt(0);

				/**
				 * Takes the data and inputs it into the rover class to compute end location
				 */
				Rover marsrover = new Rover(maxX, maxY, initX, initY, initDirection, movementLine);
				marsrover.moveRover();
				/**
				 * Prints out the end location for each rover
				 */
				System.out.println(marsrover.getX() + " " + marsrover.getY() + " " 
						+ marsrover.getDirection());
			}

	    inFile.close();
		}

	}

}
