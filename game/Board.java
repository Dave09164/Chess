package game;

public class Board {
	
	private Cell[][] board = new Cell[8][8];
	private PieceSet[] allPieces = new PieceSet[2];
	
	//The piecesSet to be placed at the top of the board
	//Colour pieceSetOnTop;
	
	public Board() {
		initBoard();
	}
	
	public void initBoard() {

		//Instantiating the allPieces array with 
		//correlating PieceSet Colours
		allPieces[0] = new PieceSet(Colour.WHITE);
		allPieces[1] = new PieceSet(Colour.BLACK);
		
		//Instantiating board with each individual cell object
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				board[i][j] = new Cell(i,j);
			}
		}
		
		//Users input can specify this
		//pieceSetOnTop = Colour.BLACK;
		
		//top of the board = [0-1][0-7]
		//Bottom of board = [6-7][0-7]
		//if(allPieces[0].colour == pieceSetOnTop) {
			//White colour top
			int countUp = 0, countDown = 15, countBack = 7;
			for(int n = 0; n <= 1; n++) {
				for(int j = 0; j <= 7; j++) {
					//Putting the pieces on the board
					board[n][j].setState(allPieces[0].getPiece(countUp));
					board[n+6][countBack].setState(allPieces[1].getPiece(countDown));
					countUp++;
					countDown--;
					countBack--;
				}
				countBack = 7;
			}
		/*} else {
			//Black colour top
			int countUp = 0, countDown = 15, countBack = 7;
			for(int n = 0; n <= 1; n++) {
				for(int j = 0; j <= 7; j++) {
					//Putting the pieces on the board
					board[n][j].setState(allPieces[1].getPiece(countUp));
					board[n+6][countBack].setState(allPieces[0].getPiece(countDown));
					countUp++;
					countDown--;
					countBack--;
				}
				countBack = 7;
			}
		}*/
		
	}//end initBoard()
	
}//End class