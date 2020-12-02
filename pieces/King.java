package pieces;

import java.util.ArrayList;

import game.*;

public class King extends Piece {

	Type type;
	
	public King(Colour c) {
		super(c);
		this.type = Type.KING;
	}
	
	public Type getType() {
		return this.type;
	}

	@Override
	public ArrayList<Cell> validMoves(Board board, int x, int y) {
		
		possibleMoves.clear();
		
		//King moves one space in any direction
		
		//UP
		if(x-1 >= 0) {
			checkCell(board,x-1,y);
		}
		
		//UP - Right
		if(x-1 >= 0 && y+1 <= 7) {
			checkCell(board,x-1,y+1);
		}
		
		//Right
		if(y+1 >= 7) {
			checkCell(board,x,y+1);
		}
		
		//Right - Down
		if(x+1 <= 7 && y+1 <= 7) {
			checkCell(board,x+1,y+1);
		}
		
		//Down
		if(x+1 <= 7) {	
			checkCell(board,x+1,y);
		}
		
		//Down - Left
		if(x+1 <=7 && y-1 >= 0) {
			checkCell(board,x+1,y-1);
		}
		
		//Left
		if(y-1 >= 0) {
			checkCell(board,x,y-1);
		}
		
		//Left - Up
		if(x-1 >= 0 && y-1 >= 0) {
			checkCell(board,x-1,y-1);			
		} 
		return underAttack(possibleMoves, board);		
}
	
	/*public Boolean isChecked(Board checkCell, PieceSet enemyPieces){
		System.out.println("checkCell size = " + String.valueOf(checkCell.size()));
		
		for(int i = 0; i < checkCell.size(); i++) {
			for(int j = 0; j < enemyPieces.getSize(); j++) {
				System.out.println("Checking enemy pieces....");
				//enemyPieces.getPiece(j).validMoves(board, x, y);
			}
			System.out.println("Checking Possible cell: " + checkCell.get(i).getCellPos());
		}
		//Check if in check/checkmate
		
		return false;
		
	}*/
	
	private void checkCell(Board board, int x, int y) {
		if(board.getBoard(x, y).getState() != null) {
			if(board.getBoard(x, y).getPieceColour() != this.getColour()) {
				possibleMoves.add(board.getBoard(x, y));
			}
		} else possibleMoves.add(board.getBoard(x, y));
	}
	
	private ArrayList<Cell> underAttack(ArrayList<Cell> p, Board b){
		
		ArrayList<Cell> enemyP = new ArrayList<Cell>();
		enemyP = b.getAllColourPieces(this.getColour());		
		ArrayList<Cell> enemyPossibleMoves = new ArrayList<Cell>();
		
		for(Cell enemyC : enemyP) {
			if(enemyC.getState().getType() != Type.KING)
				//This needs to be changed to get attack moves
			enemyPossibleMoves.addAll(enemyC.getValidMoves(b));
		}
		
		System.out.println(p.size());
		
		for(Cell kingMove : p) {
			for(Cell enemyMoves : enemyPossibleMoves) {
				if(kingMove.getCellPos().contains(enemyMoves.getCellPos())) {
					possibleMoves.remove(kingMove);
				}
			}
		}
		System.out.println(p.size());
		
		return p;
	}
}
