package edu.cuny.brooklyn.project.frame;

import edu.cuny.brooklyn.project.GameSettings;

public class ScoreWindow {
	private int width;
	private int height;
	private char[][] window;

	public ScoreWindow() {
		height = GameSettings.default_score_window_height;
		width = GameSettings.default_score_window_width;
		window = new char[width][height];
	}
	
	public char getCharAt(int x, int y) {
		return window[y][x];
	}


	public int getHeight() {
		return height;
	}	
	

	public int getWidth() {
		return width;
	}

}
