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
		
		int xTop = x, yLeft = y, xBottom = x, yRight = y;
		Boolean up = true, right = true, down = true, left = true;
		
		possibleMoves.clear();
		
		//Rook Moves any amount of spaces but only vertically or horizontally
		while(up || right || down || left) {
			//Checking top of board for possible moves and captures
			if((up) && (xTop > 0) && (board[xTop - 1][y].getState() == null)) {
				possibleMoves.add(board[xTop - 1][y]);
			} else if((up) && (xTop > 0) &&
					(board[xTop - 1][y].getPieceColour() != this.getColour())){
				//enemy piece in the way. Possible Attack move
				possibleMoves.add(board[xTop - 1][y]);
				up = false;
			} else up = false;
		
			//Checking right of board for possible moves and captures
			if((right) && (yRight < 7) && (board[x][yRight + 1].getState() == null)) {
				possibleMoves.add(board[x][yRight + 1]);
			}else if((right) && (yRight < 7) &&
					board[x][yRight + 1].getPieceColour() != this.getColour()){
				//Enemy piece in the way. Possible Attack move
				possibleMoves.add(board[x][yRight + 1]);
				right = false;
			} else right = false;
			
			//Checking bottom of board for possible moves and captures
			if((down) && (xBottom < 7) && (board[xBottom + 1][y].getState() == null)) {
				possibleMoves.add(board[xBottom + 1][y]);
			}else if((down) && (xBottom < 7) &&
					board[xBottom + 1][y].getPieceColour() != this.getColour()){
				possibleMoves.add(board[xBottom + 1][y]);
				down = false;
			}else down = false;
			
			//Checking left of board for possible moves and captures
			if((left) && (yLeft > 0) && (board[x][yLeft - 1].getState() == null)) {
				possibleMoves.add(board[x][yLeft - 1]);
			}else if((left) && (yLeft > 0) && 
					board[x][yLeft - 1].getPieceColour() != this.getColour()){
				possibleMoves.add(board[x][yLeft - 1]);
				left = false;
			} else left = false;
			xTop--; yLeft--; xBottom++; yRight++;
		}
		return possibleMoves;
	}
}
