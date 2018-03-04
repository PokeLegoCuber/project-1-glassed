/**
 * The start-up code for the 1st class project of a sequence 5 projects in CISC 3120 
 * Sections MW2 and MW8 CUNY Brooklyn College. The project should result a simple 
 * text-based game application. 
 * 
 * Spring 2018 
 */

package edu.cuny.brooklyn.project;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import edu.cuny.brooklyn.project.controller.GameController;

public class TreasureHuntConsoleApp {
	private final static Logger LOGGER = LoggerFactory.getLogger(TreasureHuntConsoleApp.class);
	
	public static void main(String[] args) 
	{
		argparse(args);
		Scanner input= new Scanner(System.in);
		boolean continueplay=true;
		//Game Round & Input Validation - ACK added validated continue playing loop
		while(continueplay)
		{
	
			LOGGER.info("TreasureHuntConsoleApp started.");
		
			GameController controller = new GameController();
			controller.runTheGame();
			System.out.println("Continue Playing Y, N?:");
			String choice=input.next();
			while(!(choice.toUpperCase().equals("Y") || choice.toUpperCase().equals("N")))
			{
				System.out.println("Wrong Choice! Re-enter choice (Y or N):");
				System.out.println("Continue Playing (Y or N)?:");
				choice=input.next();
			};
			if(!choice.toUpperCase().equals("Y"))
			{
				continueplay=false;
				System.out.println("Exiting Game...");
			}
		}
		input.close();
		LOGGER.info("TreasureHuntConsoleApp exits.");
	}
	
	public static void argparse(String[] args)
	{
		CommandLineParser parser = new DefaultParser();

		Options options = new Options();

		options.addOption("h", "help", false, "print this message");
		options.addOption(
				Option.
				builder("x").
				longOpt("window-width").
				desc("screen width for the game").
				hasArg().
				argName("WIDTH").
				build());
		options.addOption(
				Option.
				builder("y").
				longOpt("window-height").
				desc("screen height for the game").
				hasArg().
				argName("HEIGHT").
				build());
		options.addOption(
				Option.
				builder("l").
				longOpt("level").
				desc("game start at level LEVEL").
				hasArg().
				argName("LEVEL").
				build());
		try {
			CommandLine line = parser.parse(options, args);

			if (line.hasOption("help")) {
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp("TreasureHunt", options);
				System.exit(0);
			} else if (line.hasOption("window-width")) {
				int width = Integer.parseInt(line.getOptionValue("window-width"));
				if(width >= 30){
					GameSettings.field_width = width;
					GameSettings.io_win_width = width;
					GameSettings.default_score_window_width = width;
				} else {
					System.out.println("Error, the width of the window should at least 30");
					System.exit(0);
				}
			} else if (line.hasOption("window-height")) {
				int height = Integer.parseInt(line.getOptionValue("window-height"));
				
				if(height >= 12){
					GameSettings.field_height = height;
				} else {
					System.out.println("Error, the height of the window must be at least 12.");
					System.exit(0);
				}
			} else if (line.hasOption("level")) {
				// TODO
				;
			}
		} catch (ParseException exp) {
			System.out.println("Unexpected exception:" + exp.getMessage());
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("TreasureHunt", options);
			System.exit(0);
		}
	}
}
//  check the size of the window (height and width) fixed by Junquan
