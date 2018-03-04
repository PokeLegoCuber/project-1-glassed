package edu.cuny.brooklyn.project.score;

import edu.cuny.brooklyn.project.GameSettings;
import edu.cuny.brooklyn.project.treasure.Treasure;

public class Scorer {

	private int totalScore;
	private int roundScore;
	private int round;
	public Treasure treasures= new Treasure();

	public Scorer() {
		totalScore = 0;
		roundScore = 0;
		round = 0;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public int getRoundScore() {
		return roundScore;
	}

	public int getRound() {
		return round;
	}
	
	public int getLevel() {
		return (round - 1) / 3 + 1;
	}
	
	public void newRound() {
		roundScore = 0;
		round += 1;
	}
	
	public void updateScore(int attempts) {
		roundScore =  GameSettings.MAX_SCORE - (attempts - 1) * GameSettings.SCORE_PENALTY+treasures.getTotalValue();//i added  the value of the treasure towards the players score
		System.out.println("this rounds score is "+ roundScore);// print rounds score
		totalScore += roundScore;
		System.out.println("your score for this game is  "+ totalScore);// print total score
	}

}
