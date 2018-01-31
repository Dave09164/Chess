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
		public ArrayList validMoves(Cell[][] board, int x, int y) {
			
			possibleMoves.clear();
			
			//Queen Moves are a combination of the Rook, Bishop, and King
			
			return possibleMoves;
		}
		
	}
