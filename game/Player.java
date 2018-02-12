package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Player {
	
	private String playerName;
	private Colour c;
	
    //Constructor for Player object
	public Player(String playerName, Colour c) {
		this.playerName = playerName;
		this.c = c;
	}
	
	/**
	 * Getting the name variable of the player object
	 * @return Name of player instance
	 */
	public String getName() {
		return this.playerName;
	}
	
	public Colour getColour() {
		return this.c;
	}
	
	
	//saving and updating player stats feature
	@SuppressWarnings("unused")
	public void playerStats(String Player) {
		
		ObjectInputStream obIn;
		
		try {
		
			File gameData = new File(System.getProperty("user.dir") + File.separator + "gameData.dat");
			obIn = new ObjectInputStream(new FileInputStream(gameData));
			
		} catch(FileNotFoundException ioe) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
