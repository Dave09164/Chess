package pieces;

import java.util.ArrayList;
import java.util.Scanner;

import game.Board;
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
	public ArrayList<Cell> validMoves(Board board, int x, int y) {
		
		possibleMoves.clear();
		
		if(this.getColour() == Colour.WHITE) {
			if(!this.hasPromotion()) {
				if(x!=7) downMoves(board, x, y);
			} else {
				if(x!=7) downMoves(board, x, y);
				if(x!=0) upMoves(board, x, y);
			}			
		} else {
			//Piece is Black
			if(!this.hasPromotion()) {
				if(x!=0) upMoves(board, x, y);
			} else {
				if(x!=7) downMoves(board, x, y);
				if(x!=0) upMoves(board, x, y);
			}	
			
		}//end if-else
		
		return possibleMoves;
	}
	
	private void downMoves(Board board, int x, int y){
		
		if(board.getBoard(x+1, y).getState() == null) {
			possibleMoves.add(board.getBoard(x+1, y));
		}
		
		if(this.getMovesCount() == 0 && board.getBoard(x+2, y).getState() == null) {
				possibleMoves.add(board.getBoard(x+2, y));
		}
	
		//Possible attack moves
		if((y>0) && (board.getBoard(x+1,y-1).getState() != null) &&
				(board.getBoard(x+1,y-1).getPieceColour() != this.getColour())) possibleMoves.add(board.getBoard(x+1,y-1));
		if((y<7) && (board.getBoard(x+1,y+1).getState() != null) &&
				(board.getBoard(x+1,y+1).getPieceColour() != this.getColour())) possibleMoves.add(board.getBoard(x+1,y+1));
	}
	
	private void upMoves(Board board, int x, int y){
		
		if(board.getBoard(x-1,y).getState() == null) possibleMoves.add(board.getBoard(x-1,y));
		
		if(this.getMovesCount() == 0 && board.getBoard(x-2, y).getState() == null) {
				possibleMoves.add(board.getBoard(x-2, y));
		}
		
		//Possible attack moves
		if((y>0) && (board.getBoard(x-1,y-1).getState() != null) &&
				board.getBoard(x-1,y-1).getPieceColour() != this.getColour()) possibleMoves.add(board.getBoard(x-1,y-1));
		
		if((y<7) && (board.getBoard(x-1,y+1).getState() != null) && 
				board.getBoard(x-1,y+1).getPieceColour() != this.getColour()) possibleMoves.add(board.getBoard(x-1,y+1));
	}
	
	public Boolean promoted() {
		return false;
	}
	
	@Override
	public Piece promoteTo(ArrayList<Piece> captures) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Captured Pieces: \n");
		for(Piece p:captures) {
			if(p.getColour() == this.getColour()) {
				System.out.println(p.getType());
			}
		}
		
		System.out.println("Please select a piece: ");
		String choice = in.nextLine();
		
		
		switch(choice.charAt(0)) {
			case 'Q':
				return new Queen(this.getColour());
			case 'R':
				return new Rook(this.getColour());
			case 'K':
				return new Knight(this.getColour());
			case 'B':
				return new Rook(this.getColour());
			default:
				
				System.out.println("Woops.");
		}
		
		return null;
	}

}
