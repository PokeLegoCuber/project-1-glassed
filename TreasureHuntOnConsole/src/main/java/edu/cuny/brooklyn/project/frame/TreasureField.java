package edu.cuny.brooklyn.project.frame;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.cuny.brooklyn.project.GameSettings;
import edu.cuny.brooklyn.project.treasure.Treasure;

public class TreasureField {
	private final static Logger LOGGER = LoggerFactory.getLogger(TreasureField.class);
	
	private int fieldWidth;
	private int fieldHeight;
	private char[][] field;
	
	private Treasure treasure;
	private int xCenter;
	private int yCenter;
	
	private Random rng;
	
	public TreasureField() {
		fieldWidth = GameSettings.FIELD_WIDTH;
		fieldHeight = GameSettings.FIELD_HEIGHT;
		field = new char[fieldHeight][fieldWidth];
		
		clear();	
		
		treasure = null;
		rng = new Random();
	}
	

	public boolean foundTreasure(int x, int y) {
		LOGGER.debug("User's guess (x, y) = (" + x + ", " + y + ")");
		LOGGER.debug("Treasure at (xLeft, yTop) -- (xRight, yBottom) = ("
				+ xCenter + ", " + yCenter + ") -- (" 
				+ (xCenter + treasure.getSize()) + ", " + (yCenter + treasure.getSize()) + ")");
		return (x >= xCenter) && (x <= xCenter + treasure.getSize()) 
			&& (y >= yCenter) && (y <= yCenter + treasure.getSize());
	}



	public char getCharAt(int x, int y) {
		return field[y][x];
	}
	
	public int getFieldWidth() {
		return fieldWidth;
	}
	
	public int getFieldHeight() {
		return fieldHeight;
	}
	
	public int getTreasureXCenter() {
		return xCenter;
	}

	public int getTreasureXLeft() {
		return xCenter - treasure.getSize() / 2;
	}
	
	public int getTreasureYCenter() {
		return yCenter;
	}
	
	public int getTreasureYTop() {
		return yCenter - treasure.getSize() / 2;
	}
	
	public int getTreasureSize() {
		return treasure.getSize();
	}


	public void placeTreasure() {
		treasure = new Treasure();
		int availableWidth = fieldWidth - treasure.getSize();
		int availableHeight = fieldHeight - treasure.getSize();
		xCenter = rng.nextInt(availableWidth) + treasure.getSize() / 2;
		yCenter = rng.nextInt(availableHeight) + treasure.getSize() / 2;
		LOGGER.debug(String.format("Made a treasure at (xpos, ypos) = (%d, %d)", xCenter, yCenter));
	}


	public void showTreasure() {
		clear();
		int xPos = getTreasureXLeft();
		int yPos = getTreasureYTop();
		for (int i=0; i<treasure.getSize(); i++) {
			for (int j=0; j<treasure.getSize(); j++) {
				int value = treasure.getValueAt(j, i);
				char c = '+';
				if (value >=0 && value <= 9) {
					c = (char)((int)'0' + value);
				} else if (value <= 0) {
					c = '-';
				}
				LOGGER.debug("Field Size (height, width) = (" + fieldHeight + ", " + fieldWidth + ")");
				LOGGER.debug("Treasure Position (xPos, yPos) = (" + xCenter + ", " + yCenter + ")");
				LOGGER.debug("Treasure Size = " + treasure.getSize());
				LOGGER.debug("Treasure Cell at (x, y) = (" + (xCenter + j) + ", " + (yCenter + i) + ")");
				field[yPos + i][xPos + j] = c;
			}
		}
	}

	private void clear() {
		for (int i=0; i<field.length; i++) {
			for (int j=0; j<field[i].length; j++) {
				field[i][j] = GameSettings.FIELD_EMPTY;
			}
		}
	}

}
