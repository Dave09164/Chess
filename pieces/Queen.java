package pieces;

import java.util.ArrayList;

import game.*;

public class Queen extends Piece {

		Type type;
		
		public Queen(Colour c) {
			super(c);
			this.type = Type.QUEEN;
		}
		
		public Type getType() {
			return this.type;
		}

		@Override
		public ArrayList<Cell> validMoves(Board board, int x, int y) {
			
			possibleMoves.clear();
			
			//Queen Moves are a combination of the Rook and Bishop
			//checking horizontal options
			Bishop tempBish = new Bishop(board.getBoard(x, y).getPieceColour());
			possibleMoves.addAll(tempBish.validMoves(board, x, y));
			
			//Checking horizontal and vertical options
			Rook tempRook = new Rook(board.getBoard(x, y).getPieceColour());
			possibleMoves.addAll(tempRook.validMoves(board, x, y));
			
	        // return the new list 
	        return possibleMoves; 
		}
		
	}
