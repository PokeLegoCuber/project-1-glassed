package edu.cuny.brooklyn.project.frame;

import java.util.Random;

import edu.cuny.brooklyn.project.GameSettings;

public class TreasureClue {
	private static Random rng = new Random();
	
	public static String getClue(int xPos, int yPos, int size, int attempts) {
		int clueError = attempts * GameSettings.DEFAULT_CLUE_ERROR_INCREMENT;
		int xOffset = rng.nextInt(clueError);
		int yOffset = rng.nextInt(clueError);
		int x = xPos + xOffset;
		int y = yPos + yOffset;
		
		return "A treasure of size " + size + " is near (" + x + "," + y + ").";
	}
}
