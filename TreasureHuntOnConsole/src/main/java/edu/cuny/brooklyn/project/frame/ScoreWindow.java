package edu.cuny.brooklyn.project.frame;

import edu.cuny.brooklyn.project.GameSettings;

public class ScoreWindow {
	private int width;
	private int height;
	private char[][] window;

	public ScoreWindow() {
		height = GameSettings.default_score_window_height;
		width = GameSettings.default_score_window_width;
		window = new char[height][width];
	}
	
	public void paintScore(int round, int roundscore, int totalscore) {
		clear();
		String scoreString = 
				"[round " + round + "] " +
				"[level " + new Integer((round - 1) / 3 + 1) + "] " +
				" Round Score: " + roundscore + 
				" Total Score: " + totalscore;
		for (int i = 0; i < scoreString.length() && i < width; i++) {
			window[0][i] = scoreString.charAt(i);
		}
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
	
	private void clear() {
		for (int i=0; i<window.length; i++) {
			for (int j=0; j<window[i].length; j++) {
				window[i][j] = GameSettings.DISPLAY_BLANK;;
			}
		}
	}

}
