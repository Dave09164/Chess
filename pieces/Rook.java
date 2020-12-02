package pieces;

import java.util.ArrayList;

import game.Board;
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
	public ArrayList<Cell> validMoves(Board board, int x, int y) {
		
		int xTemp = x, yTemp = y;
		Boolean check = true;
		
		possibleMoves.clear();
		
		while(check) {
			//Checking up of board for possible moves and captures
			if((xTemp > 0)){
				if(board.getBoard(xTemp-1, yTemp).getState() == null) {
					possibleMoves.add(board.getBoard(xTemp-1, yTemp));
				} else if(board.getBoard(xTemp-1, yTemp).getPieceColour() != this.getColour()){
					possibleMoves.add(board.getBoard(xTemp-1, yTemp));
					check = false;
				} else check = false;
			} else check = false;
			xTemp--;
		}
		
		xTemp = x; 
		check = true;
		
		while(check) {
			//Checking right of board for possible moves and captures
			if((yTemp < 7)){
				if(board.getBoard(xTemp, yTemp + 1).getState() == null) {
					possibleMoves.add(board.getBoard(xTemp, yTemp + 1));
				} else if(board.getBoard(xTemp, yTemp + 1).getPieceColour() != this.getColour()){
					possibleMoves.add(board.getBoard(xTemp, yTemp + 1));
					check = false;
				} else check = false;
			} else check = false;
			yTemp++;
		}
		
		yTemp = y; 
		check = true;
		
		while(check) {
			//Checking down of board for possible moves and captures
			if((xTemp < 7)){
				if(board.getBoard(xTemp+1, yTemp).getState() == null) {
					possibleMoves.add(board.getBoard(xTemp+1, yTemp));
				} else if(board.getBoard(xTemp+1, yTemp).getPieceColour() != this.getColour()){
					possibleMoves.add(board.getBoard(xTemp+1, yTemp));
					check = false;
				} else check = false;
			} else check = false;
			xTemp++;
		}
		
		xTemp = x;
		check = true;
				
		while(check) {
			//Checking left of board for possible moves and captures
			if((yTemp > 0)){
				if(board.getBoard(xTemp, yTemp-1).getState() == null) {
					possibleMoves.add(board.getBoard(xTemp, yTemp-1));
				} else if(board.getBoard(xTemp, yTemp-1).getPieceColour() != this.getColour()){
					possibleMoves.add(board.getBoard(xTemp, yTemp-1));
					check = false;
				} else check = false;
			} else check = false;
			yTemp--;
		}		
		return possibleMoves;
	}
}
