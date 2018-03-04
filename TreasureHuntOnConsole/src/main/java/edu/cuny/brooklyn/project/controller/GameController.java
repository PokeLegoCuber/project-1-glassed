package edu.cuny.brooklyn.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.cuny.brooklyn.project.GameSettings;
import edu.cuny.brooklyn.project.frame.Coordinates;
import edu.cuny.brooklyn.project.frame.GameFrame;
import edu.cuny.brooklyn.project.frame.TreasureClue;
import edu.cuny.brooklyn.project.puzzler.Puzzler;
import edu.cuny.brooklyn.project.puzzler.PuzzlerMaker;
import edu.cuny.brooklyn.project.score.Scorer;

public class GameController {
	private final static Logger LOGGER = LoggerFactory.getLogger(GameController.class);
	
	GameFrame gameFrame;
	Scorer scorer = new Scorer();
	PuzzlerMaker puzzlerMaker = new PuzzlerMaker();
	
	public GameController() {
		scorer = new Scorer(GameSettings.starting_level);
		puzzlerMaker = new PuzzlerMaker();
	}
	
	public void runTheGame() {
		boolean toExit = true;
		gameFrame = new GameFrame();
		scorer.newRound();
		
		gameFrame.getScoreWindow().paintScore(scorer);
		gameFrame.updateDisplayScoreWindow();
		
		do {
			gameFrame.getTreasureField().placeTreasure();
			int attempts = solvePuzzler();
			
			String clue = TreasureClue.getClue(gameFrame.getTreasureField().getTreasureXCenter(),
					gameFrame.getTreasureField().getTreasureYCenter(),
					gameFrame.getTreasureField().getTreasureSize(),
					attempts);
			attempts = locateTreasure(clue);
			
			scorer.updateScore(attempts);
			gameFrame.getScoreWindow().paintScore(scorer);
			gameFrame.updateDisplayScoreWindow();
			LOGGER.debug("RoundScore = " + scorer.getRoundScore() + " TotalScore = " + scorer.getTotalScore());
			
			toExit = delcareEndOfRun();
		} while (!toExit);
	}
	
	private int solvePuzzler() {
		int attempts = 0;
		String answer = "";
		Puzzler puzzler = puzzlerMaker.make(scorer.getLevel());
		do {
			gameFrame.getIoWindow().paintPuzzler(puzzler.getMessage());
			gameFrame.updateDisplayIoWindow();
			
			gameFrame.display();
			answer = gameFrame.getIoWindow().answerPuzzler();
			attempts ++;
		} while (!puzzler.isCorrect(answer));
		
		LOGGER.debug("User solved the puzzler in " + attempts + " steps.");

		return attempts;
	}
	
	private int locateTreasure(String clue) {
		int attempts = 0;
		Coordinates coordinates;
		do {
			gameFrame.getIoWindow().paintClue(clue);
			gameFrame.updateDisplayIoWindow();
			gameFrame.display();
			coordinates = gameFrame.getIoWindow().locateTreasure();
			attempts ++;
		} while (!gameFrame.getTreasureField().foundTreasure(coordinates.getX(), coordinates.getY()));
		
		LOGGER.debug("User located the treasure in" + attempts + " attempts.");
		return attempts;
	}
	
	private boolean delcareEndOfRun() {
		// TODO: allow users to enter y or n. If yes, return false
		gameFrame.getTreasureField().showTreasure(); // paint the treasure
		gameFrame.updateDisplayTreasureField();
		gameFrame.getIoWindow().paintCongratulatoryMessage();
		gameFrame.updateDisplayIoWindow();
		gameFrame.display();
		
		return true;
	}
}
