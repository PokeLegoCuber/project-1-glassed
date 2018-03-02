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

import edu.cuny.brooklyn.project.controller.GameController;

public class TreasureHuntConsoleApp {
	private final static Logger LOGGER = LoggerFactory.getLogger(TreasureHuntConsoleApp.class);
	
	public static void main(String[] args) 
	{
		
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
}
