package game;

import java.util.LinkedList;
import java.util.List;

import pieces.*;

public class PieceSet {

	private List<Piece> pieces = new LinkedList<Piece>();
	
	public void validMoves() {}
	
	public PieceSet(Colour c) {
		
		Rook rook = new Rook(c);
		Rook rook2 = new Rook(c);
		Knight knight = new Knight(c);
		Knight knight2 = new Knight(c);
		Bishop bishop = new Bishop(c);
		Bishop bishop2 = new Bishop(c);
		King king = new King(c);
		Queen queen = new Queen(c);
		
		pieces.add(rook);
		pieces.add(knight);
		pieces.add(bishop);
		pieces.add(queen);
		pieces.add(king);
		pieces.add(bishop2);
		pieces.add(knight2);
		pieces.add(rook2);
		
		for(int i = 0; i < 8; i++) {
			Pawn pawn = new Pawn(c);
			pieces.add(pawn);	
		}//end for loop
	}//end constructor

	public Piece getPiece(int index) {
		return pieces.get(index);
	}
	
	/*public boolean movePiece(int index, Colour color) {
		if(pieces.get(index).getColour() != color) {
			return false;
		}
		
		return false;
	}*/
	
	public int getSize() {
		return this.pieces.size();
	}
		
}//end class
