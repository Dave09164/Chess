package game;

import java.util.ArrayList;

import pieces.*;

public class Player {
	
	String playerName;
	ArrayList<Piece> ar = new ArrayList<Piece>();
	
	public Player(String pName, Colour c) {
		playerName = pName;
		ar.add(new Bishop(1,1,Colour.BLACK));
	}

}
