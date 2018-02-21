package edu.cuny.brooklyn.project.puzzler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Puzzler {
	private final static Logger LOGGER = LoggerFactory.getLogger(Puzzler.class);
	
	private String message;
	private String answer;
	private int type;
	
	public Puzzler(String message, String answer, int type) {
		this.message = message;
		this.answer = answer;
		this.type = type;
	}
	
	public boolean isCorrect(String enteredAnswer) {
		switch (type) {
		case PuzzlerSettings.MATH_PUZZLER: 
			double entered = Double.parseDouble(enteredAnswer);
			double expected = Double.parseDouble(answer);
			if (Math.abs((entered - expected) / expected) < 0.05) {
				LOGGER.debug("Correct answer");
				return true;
			} else {
				LOGGER.debug("Incorrect answer");
				return false;
			}
		default:
			LOGGER.error("Unsupported puzzler type = " + type);
			return false;
		}
	}
	
	public String getMessage() {
		return message;
	}
}
