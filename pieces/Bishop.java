package pieces;

import java.util.ArrayList;

import game.Board;
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
	public ArrayList<Cell> validMoves(Board board, int x, int y) {
		
		int xTemp = x, yTemp = y;
		Boolean check = true;
		
		possibleMoves.clear();
		
		while(check) {
			//Checking top left of board for possible moves and captures
			if((xTemp > 0) && (yTemp > 0)){
				if(board.getBoard(xTemp-1, yTemp-1).getState() == null) {
					possibleMoves.add(board.getBoard(xTemp-1, yTemp-1));
				} else if(board.getBoard(xTemp-1, yTemp-1).getPieceColour() != this.getColour()){
					possibleMoves.add(board.getBoard(xTemp-1, yTemp-1));
					check = false;
				} else check = false;
			} else check = false;
			xTemp--; yTemp--;
		}
		
		xTemp = x; yTemp = y; check = true;
		
		while(check) {
			//Checking top right of board for possible moves and captures
			if((xTemp > 0) && (yTemp < 7)){
				if(board.getBoard(xTemp-1, yTemp+1).getState() == null) {
					possibleMoves.add(board.getBoard(xTemp-1, yTemp+1));
				} else if(board.getBoard(xTemp-1, yTemp+1).getPieceColour() != this.getColour()){
					possibleMoves.add(board.getBoard(xTemp-1, yTemp+1));
					check = false;
				} else check = false;
			} else check = false;
			xTemp--; yTemp++;
		}
		
		xTemp = x; yTemp = y; check = true;
		
		while(check) {
			//Checking bottom left of board for possible moves and captures
			if((xTemp < 7) && (yTemp > 0)){
				if(board.getBoard(xTemp+1, yTemp-1).getState() == null) {
					possibleMoves.add(board.getBoard(xTemp+1, yTemp-1));
				} else if(board.getBoard(xTemp+1, yTemp-1).getPieceColour() != this.getColour()){
					possibleMoves.add(board.getBoard(xTemp+1, yTemp-1));
					check = false;
				} else check = false;
			} else check = false;
			xTemp++; yTemp--;
		}
		
		xTemp = x; yTemp = y; check = true;
				
		while(check) {
			//Checking bottom right of board for possible moves and captures
			if((xTemp < 7) && (yTemp < 7)){
				if(board.getBoard(xTemp+1, yTemp+1).getState() == null) {
					possibleMoves.add(board.getBoard(xTemp+1, yTemp+1));
				} else if(board.getBoard(xTemp+1, yTemp+1).getPieceColour() != this.getColour()){
					possibleMoves.add(board.getBoard(xTemp+1, yTemp+1));
					check = false;
				} else check = false;
			} else check = false;
			xTemp++; yTemp++;
		}		
		return possibleMoves;
	}
}
