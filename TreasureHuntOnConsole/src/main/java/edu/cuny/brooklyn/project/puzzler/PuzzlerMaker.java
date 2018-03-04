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
		case PuzzlerSettings.MATH_PUZZLER_2://This is a Pythagorean theorem puzzle
			double num_a = 1 + rng.nextInt(10);
			double num_b = 1 + rng.nextInt(10);
			double num_c = ((Math.pow(num_a,2) + Math.pow(num_b,2)));
			num_c = Math.sqrt(num_c);
			num_c = (int) num_c;//Converts to int but still retains the x.0 formatting
			String message2 = "What is " + num_a + "^2 + "+ num_b + "^2 =\nPlease answer to the nearest whole number";
			String answer2 = Double.toString(num_c);
			LOGGER.debug("Made a math puzzler: message = " + message2 + " and answer = " + answer2);
			puzzler = new Puzzler(message2, answer2, type);
		default:
			LOGGER.error("Unsupported puzzler type = " + type);
			puzzler = null;
		}
		return puzzler;
	}
}
