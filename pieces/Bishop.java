package pieces;

import java.util.ArrayList;

import game.Cell;
import game.Colour;
import game.Type;

public class Bishop extends Piece {

	Type type;
	
	public Bishop(Colour c) {
		super(c);
		this.type = Type.BISHOP;
	}
	
	public Type getType() {
		return this.type;
	}

	@Override
	public ArrayList<Cell> validMoves(Cell[][] board, int x, int y) {
		
		int xTop = x, yLeft = y, xBottom = x, yRight = y, count = 0;
		Boolean upLeft = true, upRight = true, downLeft = true, downRight = true;
		
		possibleMoves.clear();
		
		//Bishops move diagonally only - any amount of spaces (without obstructions)
		while(count != 4) {
			//Checking top left of board for possible moves and captures
			if((xTop < 7) && (yLeft > 0) && (board[xTop - 1][yLeft - 1].getState() == null) && (upLeft)) {
				possibleMoves.add(board[xTop - 1][yLeft - 1]);
			} else if(board[xTop - 1][yLeft - 1].getPieceColour() != board[x][y].getPieceColour()){
				possibleMoves.add(board[xTop - 1][yLeft - 1]);
				upLeft = false; count++;
			} else {upLeft = false; count++;}
		
			//Checking top right of board for possible moves and captures
			if((xTop < 7) && (yRight < 7) && (board[xTop - 1][yRight + 1].getState() == null) && (upRight)) {
				possibleMoves.add(board[xTop - 1][yRight + 1]);
			}else if(board[xTop - 1][yRight + 1].getPieceColour() != board[x][y].getPieceColour()){
				possibleMoves.add(board[xTop - 1][yRight + 1]);
				upRight = false; count++;
			} else {upRight = false; count++;}
			
			//Checking bottom left of board for possible moves and captures
			if((xBottom > 0) && (yLeft > 0) && (board[xBottom + 1][yLeft - 1].getState() == null) && (downLeft)) {
				possibleMoves.add(board[xBottom + 1][yLeft - 1]);
			}else if(board[xBottom + 1][yLeft - 1].getPieceColour() != board[x][y].getPieceColour()){
				possibleMoves.add(board[xBottom + 1][yLeft - 1]);
				downLeft = false; count++;
			}else {downLeft = false; count++;}
			
			//Checking bottom right of board for possible moves and captures
			if((xBottom > 0) && (yRight < 7) && (board[xBottom + 1][yRight + 1].getState() == null) && (downRight)) {
				possibleMoves.add(board[xBottom + 1][yRight + 1]);
			}else if(board[xBottom + 1][yRight + 1].getPieceColour() != board[x][y].getPieceColour()){
				possibleMoves.add(board[xBottom + 1][yRight + 1]);
				yLeft = 0; count++;
			} else {downRight = false; count++;}
			xTop--; yLeft--; xBottom++; yRight++;
		}
		
		return possibleMoves;
	}
	
}
