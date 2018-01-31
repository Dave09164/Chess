package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class Game extends JFrame implements ActionListener {
	
	private JFrame main;
	private JPanel gui;
	private JButton btnPlay;
	private JButton btnExit;

	public Game() {
		
		ImageIcon chessIcon = new ImageIcon("..\\res\\chessIcon.ico");
		
		main = new JFrame("Chess Pro Exclusive Amaizing 5000");
		main.setIconImage(chessIcon.getImage());
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gui = new JPanel(new BorderLayout(3,3));
		gui.setBorder(new EmptyBorder(5,150,150,150));
		main.setContentPane(gui);
		
		JPanel labels = new JPanel(new GridLayout(0,1));
		JPanel buttons = new JPanel(new GridLayout(0,1));
		buttons.setBorder(new EmptyBorder(100,10,10,10));
		gui.add(labels, BorderLayout.NORTH);
		gui.add(buttons, BorderLayout.CENTER);
				
		JLabel lblTitle = new JLabel("Welcome to Chess Pro 5000");
		
		btnPlay = new JButton("Play");
		btnPlay.setForeground(Color.green);
		btnPlay.addActionListener(this);
		btnExit = new JButton("Exit");
		btnExit.addActionListener(this);
		
		labels.add(lblTitle);
		buttons.add(btnPlay);
		buttons.add(Box.createRigidArea(new Dimension(2,0)));
		buttons.add(btnExit);
		
		main.pack();
		main.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnPlay) {
			//Erase all in frame, increase frame size, Insert new panel
			//to all user input for a game to begin.
			newGame();
			
		} else {
			JOptionPane.showMessageDialog(null, "GoodBye!");
			System.exit(0);
		}
	}
@SuppressWarnings("unused")	
public static void main(String[] args) {
	
		Game g = new Game();
	
		Player p1, p2;
		
		Board board;		
		String player1, player2, p1Colour;
		Scanner in = new Scanner(System.in);
		
		board = new Board();
		
		System.out.println("Welcome to Chess Pro Exclusive Amazing 5000\n"
				+ "Please Enter Player On name: ");
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

	public void newGame() {
		gui.removeAll();
		gui.repaint();
		main.setSize(600, 600);
		
	}
	
}
