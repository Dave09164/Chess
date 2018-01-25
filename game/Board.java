package game;

public class Board<Piece> {
	
	Cell[][] board = new Cell[8][8];
	PieceSet[] allPieces = new PieceSet[2];
	
	public Board() {
		initBoard();
	}
	
	public void initBoard() {

		allPieces[0] = new PieceSet(Colour.WHITE);
		allPieces[1] = new PieceSet(Colour.BLACK);
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				board[i][j] = new Cell(i,j);
			}
		}

		//Put the pieces on the board now
		//(on each individual cell)
		
	}
	
}