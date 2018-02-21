package edu.cuny.brooklyn.project.puzzler;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.cuny.brooklyn.project.GameSettings;

public class PuzzlerMaker {
	private final static Logger LOGGER = LoggerFactory.getLogger(PuzzlerMaker.class);
	private Random rng;
	private int numTypesOfPuzzler;
	
	public PuzzlerMaker() {
		rng = new Random();
		numTypesOfPuzzler = GameSettings.NUM_TYPES_OF_PUZZLERS;
	}
	

	public Puzzler make() {
		int type = rng.nextInt(numTypesOfPuzzler);
		LOGGER.debug("Puzzler type = " + type);
		Puzzler puzzler;
		switch(type) {
		case PuzzlerSettings.MATH_PUZZLER: 
			int num = 2 + rng.nextInt(10);
			String message = "Sqrt(" + num + ") = ?";
			String answer = Double.toString(Math.sqrt(num));
			LOGGER.debug("Made a math puzzler: message = " + message + " and answer = " + answer);
			puzzler = new Puzzler(message, answer, type);
			break;
		default:
			LOGGER.error("Unsupported puzzler type = " + type);
			puzzler = null;
		}
		return puzzler;
	}
}
