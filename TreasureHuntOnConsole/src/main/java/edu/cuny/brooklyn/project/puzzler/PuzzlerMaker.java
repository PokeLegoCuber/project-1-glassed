package edu.cuny.brooklyn.project.puzzler;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PuzzlerMaker {
	private final static Logger LOGGER = LoggerFactory.getLogger(PuzzlerMaker.class);
	private Random rng;
	
	public PuzzlerMaker() {
		rng = new Random();
	}
	

	public Puzzler make(int level) {
		int type = level - 1;
		LOGGER.debug("Puzzler type = " + type);
		Puzzler puzzler;
		String message, answer;
		switch(type) {
		case PuzzlerSettings.MATH_PUZZLER: 
			int num = 2 + rng.nextInt(10);
			message = "Sqrt(" + num + ") = ?";
			answer = Double.toString(Math.sqrt(num));
			LOGGER.debug("Made a math puzzler: message = " + message + " and answer = " + answer);
			puzzler = new Puzzler(message, answer, type);
			break;
		case PuzzlerSettings.MATH_PUZZLER_2://This is a Pythagorean theorem puzzle
			double num_a = 1 + rng.nextInt(10);
			double num_b = 1 + rng.nextInt(10);
			double num_c = ((Math.pow(num_a,2) + Math.pow(num_b,2)));
			num_c = Math.sqrt(num_c);
			num_c = (int) num_c;//Converts to int but still retains the x.0 formatting
			message = "Sqrt(" + num_a + "^2 + "+ num_b + "^2) = ?";
			message += " (Please answer to the nearest whole number)";
			answer = Double.toString(num_c);
			LOGGER.debug("Made a math puzzler: message = " + message + " and answer = " + answer);
			puzzler = new Puzzler(message, answer, type);
			break;
		default:
			LOGGER.error("Unsupported puzzler type = " + type);
			// HACK
			puzzler = null;
			System.out.println("you won!");
			System.exit(0);

		}
		return puzzler;
	}
}
