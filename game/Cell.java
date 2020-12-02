package game;

import java.util.ArrayList;

import pieces.Piece;

/**
 * This class will hold the pieces and create a board.
 * 64 cell objects together make one board (8 x 8).
 * @author Dave
 *
 */
public class Cell {

	private Piece state;
	private int xPos, yPos;
	
	public Cell(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public Cell(int x, int y, Piece piece) {
		this(x, y);
		this.state = piece;
	}
	
	public int getXPos() {
		return this.xPos;
	}
	
	public int getYPos() {
		return this.yPos;
	}
	
	public String getCellPos() {
		return this.xPos + " : " + this.yPos;
	}
	
	public ArrayList<Cell> getValidMoves(Board b){ 
		if(this.state != null) {
			return this.state.validMoves(b, this.xPos, this.yPos);
		}
		return null;
	}
	
	public Piece getState() {
		if(this.state != null) {
			return this.state;
		}
		return null;
	}
	
	public Colour getPieceColour() {
		if(this.state != null) {
			return state.getColour();
		}
		return null;
	}
	
	public void setState(Piece p) {
		this.state = p;
	}

}
