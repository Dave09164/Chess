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
	public ArrayList<Cell> validMoves(Cell[][] board, int x, int y) {
		
		possibleMoves.clear();
		
		//Knights single move is 2 cells in one vertical or horizontal direction
		//and one in the opposite direction (not back on itself though)
		//Giving it 8 option when moving.
		int[] xPos = {x-2, x-2, x-1, x+1, x-1, x+1, x+2, x+2};
		int[] yPos = {y-1, y+1, y-2, y-2, y+2, y+2, y-1, y+1};

		for(int i = 0; i <= 8; i++) {
			if(xPos[i] > 0 && xPos[i] < 8 && yPos[i] > 0 && yPos[i] < 8) {
				if(board[xPos[i]][yPos[i]].getState() == null) {
					possibleMoves.add(board[xPos[i]][yPos[i]]);
				} else if(board[xPos[i]][yPos[i]].getPieceColour() != this.getColour())
					possibleMoves.add(board[xPos[i]][yPos[i]]);
			}
		}	
		return possibleMoves;
	}
}
