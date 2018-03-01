package edu.cuny.brooklyn.project.score;

import edu.cuny.brooklyn.project.GameSettings;

public class Scorer {

	private int totalScore;
	private int roundScore;
	public Treasure treasures= new Treasure();

	public Scorer() {
		totalScore = 0;
		roundScore = 0;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public int getRoundScore() {
		return roundScore;
	}

	public void updateScore(int attempts) {
		roundScore =  GameSettings.MAX_SCORE - (attempts - 1) * GameSettings.SCORE_PENALTY+treasure.getTotalValue();//i added  the value of the treasure towards the players score
		System.out.println("this rounds score is "+ roundScore);// print rounds score
		totalScore += roundScore;
		System.out.println("your score for this game is  "+ totalScore);// print total score
	}

}
