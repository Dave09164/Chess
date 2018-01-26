package game;

import java.util.Scanner;

public class Game {
	
public static void main(String[] args) {
	
		Player p1, p2;
		Board board;		
		String player1, player2, p1Colour;
		Scanner in = new Scanner(System.in);
		
		board = new Board();
		
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
