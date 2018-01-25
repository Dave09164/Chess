package game;

public class Player {
	
	String playerName;
	
    //Constructor for Player object
	public Player(String playerName) {
		this.playerName = playerName;
	}
	
	/**
	 * Getting the name variable of the player object
	 * @return Name of player instance
	 */
	public String getName() {
		return this.playerName;
	}
}
