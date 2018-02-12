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
		
		int xTop = x, yLeft = y, xBottom = x, yRight = y;
		Boolean upLeft = true, upRight = true, downLeft = true, downRight = true;
		
		possibleMoves.clear();
		
		//Bishops move diagonally only - any amount of spaces (without obstructions)
		while(upLeft || upRight || downLeft || downRight) {
			//Checking top left of board for possible moves and captures
			if((upLeft) && (xTop > 0) && (yLeft > 0) && (board[xTop - 1][yLeft - 1].getState() == null)) {
				possibleMoves.add(board[xTop - 1][yLeft - 1]);
			} else if((upLeft) && (xTop > 0) && (yLeft > 0) && 
					board[xTop - 1][yLeft - 1].getPieceColour() != this.getColour()){
				possibleMoves.add(board[xTop - 1][yLeft - 1]);
				upLeft = false;
			} else upLeft = false;
		
			//Checking top right of board for possible moves and captures
			if((upRight) && (xTop < 7) && (yRight < 7) && (board[xTop - 1][yRight + 1].getState() == null)) {
				possibleMoves.add(board[xTop - 1][yRight + 1]);
			}else if((upRight) && (xTop < 7) && (yRight < 7) && 
					board[xTop - 1][yRight + 1].getPieceColour() != this.getColour()){
				possibleMoves.add(board[xTop - 1][yRight + 1]);
				upRight = false;
			} else upRight = false;
			
			//Checking bottom left of board for possible moves and captures
			if((downLeft) && (xBottom > 0) && (yLeft > 0) && (board[xBottom + 1][yLeft - 1].getState() == null)) {
				possibleMoves.add(board[xBottom + 1][yLeft - 1]);
			}else if((downLeft) && (xBottom > 0) && (yLeft > 0) &&
					board[xBottom + 1][yLeft - 1].getPieceColour() != this.getColour()){
				possibleMoves.add(board[xBottom + 1][yLeft - 1]);
				downLeft = false;
			}else downLeft = false;
			
			//Checking bottom right of board for possible moves and captures
			if((downRight) && (xBottom > 0) && (yRight < 7) && (board[xBottom + 1][yRight + 1].getState() == null)) {
				possibleMoves.add(board[xBottom + 1][yRight + 1]);
			}else if((downRight) && (xBottom > 0) && (yRight < 7) &&
					(board[xBottom + 1][yRight + 1].getPieceColour() != this.getColour())){
				possibleMoves.add(board[xBottom + 1][yRight + 1]);
				yLeft = 0;
			} else downRight = false;
			xTop--; yLeft--; xBottom++; yRight++;
		}
		
		return possibleMoves;
	}
	
}
