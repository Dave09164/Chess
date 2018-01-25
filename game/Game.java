package game;

import java.util.ArrayList;
import java.util.Scanner;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class Game {
	
	static Player p1;
	static Player p2;
	ArrayList<Piece> piecesAr = new ArrayList<Piece>();
	
public static void main(String[] args) {
	
		Board b = new Board();
		b.initBoard();
	
		Scanner in = new Scanner(System.in);
		String player1, player2, p1Colour;
		
		
		System.out.println("Welcome to Chess Pro Exclusive Amazing 5000\n"
				+ "\tPlease Enter Player On name: ");
		player1 = in.nextLine();
		
		System.out.println("What colour would you like to be "+player1+"?\n"
				+ "(Write Black or White)");
		p1Colour = in.next();
		
		p1Colour = p1Colour.substring(0, 1).toUpperCase() + p1Colour.substring(1).toLowerCase();
		
		System.out.println("Please enter Player 2 name: ");
		player2 = in.nextLine();
		
		if(p1Colour == "Black") {
			p1 = new Player(player1);
			p2 = new Player(player2);
		} else {
			p1 = new Player(player1);
			p2 = new Player(player2);
		}
		
		in.close();
	}
	
}
