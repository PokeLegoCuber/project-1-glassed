package edu.cuny.brooklyn.project.frame;

import java.util.Random;

import edu.cuny.brooklyn.project.GameSettings;

public class TreasureClue {
	private static Random rng = new Random();
	
	public static String getClue(int xPos, int yPos, int size, int attempts) {
		ScoreWindow scoreWind = new ScoreWindow();
		int height = scoreWind.getHeight();
		int width = scoreWind.getWidth();
		String xClue = "";
		String yClue = "";
		if(xPos <= width/2) {
			xClue = "Left";
		}
		else if(xPos > width/2) {
			xClue = "Right";
		}
		if(yPos <= height/2) {
			yClue = "Bottom";
		}
		else if(yPos > height/2) {
			yClue = "Top";
		}
		int clueError = attempts * GameSettings.DEFAULT_CLUE_ERROR_INCREMENT;
		int xOffset = rng.nextInt(clueError);
		int yOffset = rng.nextInt(clueError);
		int x = xPos + xOffset;
		int y = yPos + yOffset;
		
		return "The treasure is on the "+ yClue + " " + xClue + " near (" + x + "," + y + ")";
	}
}
//Exercise 3.1 Hareem Bokhari
//using scorewindow get height and width of screen
//if x value lies less than width/2 then clue will be to the left
//if x value is greater than width/2 then clue will be to the right
//if y value is greater than height/2 than clue will be top
//if y value is less than height/2 than clue will be bottom