package game;

import pieces.Piece;

/**
 * This class will hold the pieces and create a board.
 * 64 cell objects together make one board (8 x 8).
 * @author Dave
 *
 */
public class Cell {

	private Piece piece;
	private int xPos, yPos;
	
	public Cell(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public Cell(int x, int y, Piece piece) {
		this(x, y);
		this.piece = piece;
	}
	
	public int getXPos() {
		return this.xPos;
	}
	
	public int getYPos() {
		return this.yPos;
	}
	
	public Piece getPiece() {
		if(this.piece != null) {
			return this.piece;
		}
		return null;
	}
	
	public void addPiece(Piece p) {
		this.piece = p;
	}

}
