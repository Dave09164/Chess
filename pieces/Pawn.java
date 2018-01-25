package pieces;

import game.Colour;
import game.Type;

public class Pawn extends Piece {

	Type type;
	
	public Pawn(Colour c) {
		super(c);
		this.type = Type.PAWN;
	}
	
	public Type getType() {
		return this.type;
	}
	
	@Override
	public Colour getColour() {
		return this.colour;
	}


	@Override
	public boolean isValidMove(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int[][] drawPath() {
		/**
		 * A king can only move one space at a time, in any direction.
		 */
		return null;
	}
	
	public void setColour(Colour newColour) {
		super.setColour(newColour);
	}
	
	public void captured() {
		/**
		 * This is when another piece takes this piece.
		 * Should be stored away in case pawn instance brings it back.
		 */
	}
	
	public void hasCaptured(Piece isCaptured) {
		/**
		 * This is when this piece has captured another piece.
		 * Should definitely think about changing the names of these methods.
		 */
		
		
	}
	
	
	
}
