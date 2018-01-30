package pieces;

import java.util.ArrayList;

import game.Cell;
import game.Colour;
import game.Type;

public class Rook extends Piece {

	Type type;
	
	public Rook(Colour c) {
		super(c);
		this.type = Type.ROOK;
	}
	
	public Type getType() {
		return this.type;
	}

	@Override
	public ArrayList<Cell> validMoves(Cell[][] board, int x, int y) {
		
		possibleMoves.clear();
		
		//Sort out this method next
		
		return possibleMoves;
	}

}
