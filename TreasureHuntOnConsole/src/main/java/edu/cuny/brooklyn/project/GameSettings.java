package edu.cuny.brooklyn.project;

public class GameSettings {
	// default frame size
	final static int FRAME_WIDTH = 80;
	final static int FRAME_HEIGHT = 25;
	
	// default treasure field size
	public static int field_width = 70;
	public static int field_height = 15;
	
	// default user I/O field size
	public static int io_win_width = 70;
	public static int io_win_height = 3;
	
	public final static int FIELD_EMPTY = 0;
	
	public final static int DISPLAY_BLANK =0;
	
	// default treasure set up
	public final static int DEFAULT_TREASURE_SIZE = 10;
	public final static int DEFAULT_TREASURE_VALUE = 1;
	
	// number of types of puzzlers
	public final static int NUM_TYPES_OF_PUZZLERS = 2;//Changed from 1 to 2
	
	// score window
	public static int default_score_window_height = 1;
	public static int default_score_window_width = 70;
	
	// clue error
	public static final int DEFAULT_CLUE_ERROR_INCREMENT = 2;
	
	// score computation
	public static final int MAX_SCORE = 100;
	public static final int SCORE_PENALTY = 10;
}
