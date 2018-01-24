package pieces;

import game.*;

/**
 * The Piece class is an abstract class for all chess piece objects.
 * @author Dave 
 *
 */
public abstract class Piece {
	
	int x, y;
	Colour colour;
	
	/**
	 * Constructor for a Piece object
	 * @param x 	x location for the object
	 * @param y		y location for the object
	 */
	public Piece(int x, int y, Colour colour) {
		
		this.x = x;
		this.y = y;
		this.colour = colour;
			
	}
	
	public void setColour(Colour newColour) {
		this.colour = newColour;
	}
	
	
	/**
	 * 
	 * 
	 * @param x		the x location of this piece
	 * @param y		the y location of this piece
	 * @return		returns a true if the chosen location is valid
	 * 				or false if not
	 */
	public abstract boolean isValidMove(int x, int y);
	
	
	/**
	 * 
	 * @return		Returns a 2 dimensional array of possible locations for valid moves 
	 */
	public abstract int[][] drawPath();
	
	/**
	 * To get the type of object, Example: BISHOP, KING, QUEEN
	 * @return		Returns the type of Piece object
	 */
	public abstract Type getType();
	
	public abstract Colour getColour();
	

}
