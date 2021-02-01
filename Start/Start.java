package Start;

import java.util.Scanner;

import game.*;
//import pieces.*;

public class Start {
	
	public static void main(String[] args) {
	
		Scanner user = new Scanner(System.in);
		Boolean gameEnd = false;
		Player[] players = new Player[2];
		
		System.out.println("What is your name?");
		String name = user.nextLine();
		System.out.println("Ok, " + name + ", you are the white pieces.");
		players[0] = new Player(name, Colour.WHITE);
		
		System.out.println("Sweet. Nai. Who's player 2 en?");
		name = user.nextLine();
		players[1] = new Player(name, Colour.BLACK);
		System.out.println("Obviously, " + name + ", you are the black pieces.");
		
		System.out.println("Getting all the pieces together...");
		Board game1 = new Board();
		System.out.println("Done.");
		
		printBoard(game1);
		
		while(!gameEnd) {
			playerTurn(players[0], game1);
			//for(Player p: players) {
				//playerTurn(p, game1);
			printBoard(game1);
				//check if game has end after each turn 
			//}
		}
		user.close();
	}//end of main
	
	@SuppressWarnings("resource")
	public static void playerTurn(Player p, Board b) {
		Scanner in = new Scanner(System.in);
		Boolean startTurn = false;
		while(!startTurn) {
			System.out.println("Make your move "+ p.getName() +": "
					+ "\n(input cell you want to move followed by new position)");
			String move = in.nextLine();
			startTurn = b.convertMove(move, p.getColour());
		}
	}
	
	public static void printBoard(Board print) {
		String[][] b = print.getBoardState();
		char[] alphabet = "ABCDEFGH".toCharArray();
		
		for (int row = 0; row < 8; row++)
		{      
		      //System.out.print(" ");
		      if(row == 0) {
	    		  for(int i =0;i<8;i++) {
	    			  System.out.format("\t| " + " %15s"+ 
			        		   " ", String.valueOf(alphabet[i]));
	    		  }
	    		  System.out.print("|");
	    	  } 
		      System.out.println("");
		      
		      for(int j=0; j<7;j++) {
		    	  System.out.print("----------------------------");
		      }System.out.println("");
		      
		      System.out.print(row+1);
		      for (int column = 0; column < 8; column++)
		      { 
		          System.out.format("\t| " + " %15s"+ 
		        		   " ", b[row][column]);
		      }       
		      System.out.print("|");
		    }
		    System.out.println("");
		    for(int j=0; j<7;j++) {
		    	  System.out.print("----------------------------");
		      }System.out.println("");
		
	}
}
