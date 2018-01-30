package pieces;

import java.util.ArrayList;

import game.*;

/**
 * The Piece class is an abstract class for all chess piece objects.
 * @author Dave 
 *
 */
public abstract class Piece implements Cloneable{
	
	private Colour colour;
	protected ArrayList<Cell> possibleMoves = new ArrayList<Cell>();
	
	/**
	 * Constructor for a Piece object
	 */
	public Piece(Colour colour) {
		
		this.colour = colour;
			
	}
	
	public void setColour(Colour newColour) {
		this.colour = newColour;
	}
	
	public Colour getColour() {
		return this.colour;
	}
	
	//Also may need hasCaptured()
	public void captured() {
		
	}
	
	/**
	 * 
	 * 
	 * @param x		the x location of this piece
	 * @param y		the y location of this piece
	 * @return		returns a true if the chosen location is valid
	 * 				or false if not
	 */
	public abstract ArrayList<Cell> validMoves(Cell[][] board, int x, int y);
	
	/**
	 * To get the type of object, Example: BISHOP, KING, QUEEN
	 * @return		Returns the type of Piece object
	 */
	public abstract Type getType();
	
}
