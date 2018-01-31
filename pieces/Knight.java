package pieces;

import java.util.ArrayList;

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
	public ArrayList validMoves(Cell[][] board, int x, int y) {
		
		possibleMoves.clear();
		
		//Knights single move is 2 cells in one vertical or horizontal direction
		//and one in the opposite direction (not back on itself though)
		
		//up left
		if((x > 1) && (y > 0) && (board[x-2][y-1].getState() == null)) {
			possibleMoves.add(board[x-2][y-1]);
		}
		//up right
		if((x > 1) && (y < 7) && (board[x-2][y+1].getState() == null)) {
			possibleMoves.add(board[x-2][y+1]);
		}
		
		//down left
		if((x < 6) && (y > 0) && (board[x+2][y-1].getState() == null)) {
			possibleMoves.add(board[x+2][y-1]);
		}
		//down right
		if((x < 6) && (y < 7) && (board[x+2][y+1].getState() == null)) {
			possibleMoves.add(board[x+2][y+1]);
		}
		/*
		 * TAKE OF FROM HERE!!
		 */
		//left up
		if((x > 1) && (y > 1) && (board[x-2][y-1].getState() == null)) {
			possibleMoves.add(board[x-2][y-1]);
		}
		//left down
		if((x > 1) && (y > 1) && (board[x-2][y-1].getState() == null)) {
			possibleMoves.add(board[x-2][y-1]);
		}
		
		//right up
		if((x > 1) && (y > 1) && (board[x-2][y-1].getState() == null)) {
			possibleMoves.add(board[x-2][y-1]);
		}
		//right down
		if((x > 1) && (y > 1) && (board[x-2][y-1].getState() == null)) {
			possibleMoves.add(board[x-2][y-1]);
		}
		
		return possibleMoves;
	}
	
}
