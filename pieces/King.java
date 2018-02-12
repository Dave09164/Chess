package pieces;

import java.util.ArrayList;

import game.*;

public class King extends Piece {

	Type type;
	
	public King(Colour c) {
		super(c);
		this.type = Type.KING;
	}
	
	public Type getType() {
		return this.type;
	}

	@Override
	public ArrayList<Cell> validMoves(Cell[][] board, int x, int y) {
		
		possibleMoves.clear();
		
		//King moves one space in any direction
		//Also Must check if kings is in check after every move from all pieces.
		
		return possibleMoves;
	}
}
