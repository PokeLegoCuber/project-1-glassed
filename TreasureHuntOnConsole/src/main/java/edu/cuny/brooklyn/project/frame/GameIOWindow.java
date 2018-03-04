package edu.cuny.brooklyn.project.frame;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.cuny.brooklyn.project.GameSettings;

public class GameIOWindow {
	private final static Logger LOGGER = LoggerFactory.getLogger(GameIOWindow.class);
	private Scanner scanner;
	
	private int height;
	private int width;
	private char[][] window;
	
	public GameIOWindow() {
		height = GameSettings.io_win_height;
		width = GameSettings.io_win_width;
		window = new char[height][width];
		
		clear();
		
		scanner = new Scanner(System.in);
	}
	
	

	public String answerPuzzler() {
		String answer = "";
		//Input Validation - validated for -ve numbers could have try catch for strings
		do {
			answer = scanner.nextLine();
			if(Double.parseDouble(answer)<0)
				System.out.println("Re-enter number:");
				
			
		} while (answer.isEmpty()||(Double.parseDouble(answer)<0));
		LOGGER.debug("User entered " + answer);
		return answer;
	}
	
	public Coordinates locateTreasure() {
		scanner.useDelimiter("(,)|(\\s+)");
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		LOGGER.debug("User entered " + x + "," + y);
		return new Coordinates(x, y);
	}
	

	public char getChar(int x, int y) {
		return window[y][x];
	}

	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	


	public void paintClue(String clue) {
		clear();
		
		int xPos = 1;
		int yPos = 1;
		
		for (int i=0; i<clue.length() && (xPos+i) < width; i++) {
			window[yPos][xPos+i] = clue.charAt(i);
		}
		yPos ++;
		for (int i=0; i<"Where is the treasure? enter x,y:".length(); i++) {
			window[yPos][xPos+i] = "Where is the treasure? enter x,y:".charAt(i);
		}
	}



	public void paintCongratulatoryMessage() {
		clear();
		
		int xPos = 1;
		int yPos = 1;
		
		for (int i=0; i<"Congraulations. You found the treasure".length(); i++) {
			window[yPos][xPos+i] = "Congraulations. You found the treasure".charAt(i);
		}
		yPos ++;
		
	} 

	public void paintPuzzler(String msg) {
		clear();
		
		int xPos = 1;
		int yPos = 1;
		
		for (int i = 0; i < msg.length() && (xPos+i) < width; i++) {
			window[yPos][xPos+i] = msg.charAt(i);
		}
		yPos ++;
		for (int i = 0; i < "Your Answer:".length(); i++) {
			window[yPos][xPos+i] = "Your Answer:".charAt(i);
		}
	}
	
	private void clear() {
		for (int i=0; i<window.length; i++) {
			for (int j=0; j<window[i].length; j++) {
				window[i][j] = GameSettings.DISPLAY_BLANK;;
			}
		}
	}


}
