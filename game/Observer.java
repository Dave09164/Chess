package game;

import java.util.ArrayList;

public class Observer {

	public static void main(String[] args) {
		

	}
	
	public ArrayList<Cell> getAttackedRanks(Board b, Colour c) {
		
		ArrayList<Cell> attackedRanks = new ArrayList<Cell>();
		ArrayList<Cell> emenyPieces = b.getAllColourPieces(c);
		
		for(Cell enemy : emenyPieces) {
			
			attackedRanks.addAll(enemy.getValidMoves(b));
		}
		
		return attackedRanks;
	}

}
