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
	private Boolean level;
	private int movesCount = 0;
	private int captureCount = 0;
	//private Boolean captured = false;
	
	protected ArrayList<Cell> possibleMoves = new ArrayList<Cell>();
	
	/**
	 * Constructor for a Piece object
	 */
	public Piece(Colour colour) {
		
		this.colour = colour;
		this.level = false;
			
	}
	
	public void setColour(Colour newColour) {
		this.colour = newColour;
	}
	
	public Colour getColour() {
		return this.colour;
	}
	
	public void promote() {
		this.level = true;
	}
	
	public Boolean hasPromotion() {
		return this.level;
	}
	
	public int getMovesCount() {
		return this.movesCount;
	}
	
	public void makeMoveCounter() {
		this.movesCount++;
	}
	
	public int getCaptureCount() {
		return this.captureCount;
	}
	
	public void addCapture() {
		this.captureCount++;
	}
	
	public Piece promoteTo(ArrayList<Piece> captures) {
		return null;
	}
		
	/*public Boolean isCaptured() {
		return this.captured;
	}
	
	public void setCaptured(Boolean captured) {
		this.captured = captured;
	}*/
	
	/**
	 * 
	 * 
	 * @param x		the x location of this piece
	 * @param y		the y location of this piece
	 * @return		returns a true if the chosen location is valid
	 * 				or false if not
	 */
	public abstract ArrayList<Cell> validMoves(Board board, int x, int y);
	
	/**
	 * To get the type of object, Example: BISHOP, KING, QUEEN
	 * @return		Returns the type of Piece object
	 */
	public abstract Type getType();
}
