package game;

import java.util.ArrayList;

import pieces.*;

public class Player {
	
	String playerName;
	Colour colour;
	ArrayList<Piece> ar = new ArrayList<Piece>();
	
    //Constructor for Player object
	public Player(String playerName, Colour c) {
		this.playerName = playerName;
		this.colour = c;
		initPieces();
		
	}
	
	/**
	 * Initialising the players pieces to the correct amount
	 */
	public void initPieces() {
		
		ar.add(new Rook(0,0,this.colour));
		ar.add(new Rook(0,7,this.colour));
		ar.add(new Knight(0,1,this.colour));
		ar.add(new Knight(0,6,this.colour));
		ar.add(new Bishop(0,2,this.colour));
		ar.add(new Bishop(0,5,this.colour));
		ar.add(new King(0,3,this.colour));
		ar.add(new Queen(0,4,this.colour));
		
		for(int i = 0; i < 8; i++) {
			ar.add(new Pawn(1,i,this.colour));
		}
		
		
		
		
	}
	
}
