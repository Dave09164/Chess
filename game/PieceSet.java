package game;

import java.util.List;

import pieces.*;

public class PieceSet {

	Colour colour;
	List<Piece> pieces;
	
	
	public PieceSet(Colour c) {
		colour = c;
		
		Rook rook = new Rook(c);
		Rook rook2 = new Rook(c);
		Knight knight = new Knight(c);
		Knight knight2 = new Knight(c);
		Bishop bishop = new Bishop(c);
		Bishop bishop2 = new Bishop(c);
		King king = new King(c);
		Queen queen = new Queen(c);
		
		for(int i = 0; i < 8; i++) {
			Pawn pawn = new Pawn(c);
			pieces.add(pawn);
		}
		
		pieces.add(rook);
		pieces.add(knight);
		pieces.add(bishop);
		pieces.add(king);
		pieces.add(queen);
		pieces.add(rook2);
		pieces.add(knight2);
		pieces.add(bishop2);
		
	}

}
