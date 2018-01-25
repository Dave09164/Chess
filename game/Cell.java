package game;

import pieces.Piece;

/**
 * This class will hold the pieces and create a board.
 * 64 cell objects together make one board (8 x 8).
 * @author Dave
 *
 */
public class Cell {

	Piece piece;
	int xPos, yPos;
	
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

}
