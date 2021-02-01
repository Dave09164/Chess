package game;

import java.util.ArrayList;

import pieces.Piece;

public class Board {
	
	private Cell[][] board = new Cell[8][8];
	private PieceSet[] allPieces = new PieceSet[2];
	private static ArrayList<Piece> captures = new ArrayList<Piece>();
	
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
		for(int i = 0; i < board[0].length; i++) {
			for(int j = 0; j < board[1].length; j++) {
				board[i][j] = new Cell(i,j);
			}
		}
		
		//top of the board = [0-1][0-7]
		//Bottom of board = [6-7][0-7]
		int countUp = 0;
			for(int j = 0; j <= 7; j++) {
				//Putting the pieces on the board
				board[0][j].setState(allPieces[0].getPiece(countUp));
				board[1][j].setState(allPieces[0].getPiece(countUp+8));
				board[6][j].setState(allPieces[1].getPiece(countUp+8));
				board[7][j].setState(allPieces[1].getPiece(countUp));
				countUp++;
			}
		
	}//end initBoard()
	
	public Cell getBoard(int x, int y){
		return this.board[x][y];
	}
	
	public String[][] getBoardState() {
		String tempBoard[][] = new String[8][8];
		//char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		
		for (int i =0; i<8; i++) {
			for(int j=0; j < 8; j++) {
				if(board[i][j].getState() == null) {
					tempBoard[i][j] = "empty";
					//tempBoard[i][j] = String.valueOf(i) + " : " + String.valueOf(j) + " is empty.";
				} else {
					tempBoard[i][j] =  " " + board[i][j].getState().getColour() + ' ' + board[i][j].getState().getType();
					//tempBoard[i][j] = String.valueOf(i) + " : " + String.valueOf(alphabet[j]) + " " + board[i][j].getState().getColour() + ' ' + board[i][j].getState().getType();
				}
			}
		}// end of i loop
		
		return tempBoard;
	}
	
	public Boolean convertMove(String move, Colour colour) {
		char[] moves = move.replaceAll("\\s+", "").toCharArray();
		int[] converted = new int[4];
		
		for (int i=0; i < moves.length;i++) {
			try {
				converted[i] = Integer.parseInt(String.valueOf(moves[i]))-1;
			} catch(NumberFormatException Excnum) {
				
				char[] alphToNum = "ABCDEFGH".toCharArray();
				String c = String.valueOf(moves[i]).toUpperCase();
				
				for(int ch =0; ch<alphToNum.length;ch++) {
					if(String.valueOf(alphToNum[ch]).equals(c)) {
						converted[i] = ch;
					}
				}
			}
			catch(Exception e) {System.out.print("farts " + e);
			}
		}
		return makeMove(converted[0], converted[1], converted[2], converted[3], colour); 
	}
	
	public boolean makeMove(int fromY, int fromX, int toY, int toX, Colour colour) {
		
		try {
			if(board[fromX][fromY].getState().getColour() == colour) {
				
				ArrayList<Cell> possibleMoves = board[fromX][fromY].getValidMoves(this);
				
				for(Cell c : possibleMoves) {
					
					if(c.getXPos() == toX && c.getYPos() == toY) {
						initiateMove(fromX, fromY, toX, toY);
					return true;
					}
				}
			} else {
				System.out.println("That is not your piece. Try again.");
				return false;
			}
			
			System.out.println("Not a valid move. Try again.");
			return false;
		
		} catch (NullPointerException nExcep) {
			System.out.println("There is no piece on that square.\nTry again: ");
			return false;
		}
	}
	
	private void initiateMove(int fromX, int fromY, int toX, int toY) {
		
		if(board[toX][toY].getState() != null) {
			captures.add(board[toX][toY].getState());
			
			for(Piece p : captures) {
				System.out.println(p.getType() + " - " + p.getColour());
			}
		}
		
		board[toX][toY].setState(board[fromX][fromY].getState());
		board[fromX][fromY] = new Cell(fromX,fromY);
		board[toX][toY].getState().makeMoveCounter();
		
		//After Move has been made - Determine Promotion (Should probably get in a separate function but fuck it.
		if(board[toX][toY].getState().getType() == Type.PAWN) {
			if(board[toX][toY].getState().getColour() == Colour.WHITE && toX == 7 
				|| board[toX][toY].getState().getColour() == Colour.BLACK && toX == 0) {
				
				board[toX][toY].setState(board[toX][toY].getState().promoteTo(captures));
				board[toX][toY].getState().promote();
				board[toX][toY].getState().makeMoveCounter();
			}
		} 		
	}//end initiateMove function
	
	public ArrayList<Cell> getAllColourPieces(Colour c) {
		ArrayList<Cell> tempBoard = new ArrayList<Cell>();
		//char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		
		for (int i =0; i<8; i++) {
			for(int j=0; j < 8; j++) {
				if(board[i][j].getState() != null) {
					if(board[i][j].getState().getColour() != c){
						tempBoard.add(board[i][j]);
					}
					//tempBoard[i][j] = String.valueOf(i) + " : " + String.valueOf(alphabet[j]) + " " + board[i][j].getState().getColour() + ' ' + board[i][j].getState().getType();
				}
			}
		}// end of i loop
		
		return tempBoard;
	}
	
}//End class