package pieces;

import java.util.ArrayList;

import game.Cell;
import game.Type;
import game.Colour;

public class Pawn extends Piece {

	private Type type;
	
	//Constructor
	public Pawn(Colour c) {
		super(c);
		this.type = Type.PAWN;
	}
	
	public Type getType() {
		return this.type;
	}

	@Override
	public ArrayList<Cell> validMoves(Cell[][] board, int x, int y) {
		
		possibleMoves.clear();
		
		if(this.getColour() == Colour.WHITE) {
			//Moving down the board because white pieces will always start at the top of the board
			if(board[x+1][y].getState() == null) {
				possibleMoves.add(board[x+1][y]);
				if(x == 6) {
					possibleMoves.add(board[x+2][y]);
				}
			}
			
			//Possible attack moves
			if((y>0) && (board[x+1][y-1].getState() != null) &&
					(board[x+1][y-1].getPieceColour() != this.getColour())) possibleMoves.add(board[x+1][y-1]);
			if((y<7) && (board[x+1][y+1].getState() != null) &&
					(board[x+1][y+1].getPieceColour() != this.getColour())) possibleMoves.add(board[x+1][y+1]);
		} else {
			//Moving up the board because black pieces will always start at the bottom of the board
			if(board[x-1][y].getState() == null) {
				possibleMoves.add(board[x-1][y]);
				if(x == 6) {
					possibleMoves.add(board[x-2][y]);
				}
			}
			
			//Possible attack moves
			if((y>0) && (board[x-1][y-1].getState() != null) &&
					board[x-1][y-1].getPieceColour() != this.getColour()) possibleMoves.add(board[x-1][y-1]);
			if((y<7) && (board[x-1][y+1].getState() != null) && 
					board[x-1][y+1].getPieceColour() != this.getColour()) possibleMoves.add(board[x-1][y+1]);

		}//end if-else
		
		return possibleMoves;
	}
	
	public Boolean promoted() {
		return false;
	}
	
	public Piece promotedTo() {
		//TODO sort this oot
		return new Queen(Colour.BLACK);
	}

}
