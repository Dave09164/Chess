package pieces;

import game.Cell;
import game.Colour;
import game.Type;

public class Knight extends Piece {

	Type type;
	
	public Knight(Colour c) {
		super(c);
		this.type = Type.KNIGHT;
	}
	
	public Type getType() {
		return this.type;
	}

	@Override
	public Cell[] validMoves(int x, int y) {
		// TODO Auto-generated method stub
		
		Cell[] moves = new Cell[3];
		return moves;
	}

	@Override
	public Cell[] drawPath() {
		/**
		 * A king can only move one space at a time, in any direction.
		 */
		Cell[] moves = new Cell[3];
		return moves;
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

	@Override
	public Boolean toBeCaptured() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
