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
	private JButton start;
	private JButton[] cell;
	private JTextField textP1;
	private JTextField textP2;

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
			newGame();
		} else if(e.getSource() == start){
			String player1 = textP1.getText();
			String player2 = textP2.getText();
			startGame(player1, player2);
		}else if(e.getSource() == cell){
			JOptionPane.showMessageDialog(null, e.getSource());
			cellClick(cell[5].getName());
		}else {
			JOptionPane.showMessageDialog(null, "GoodBye!");
			System.exit(0);
		}
	}
	
	public void newGame() {
		gui.removeAll();
		gui.repaint();
		main.setSize(1000, 700);
		gui.setBorder(new EmptyBorder(0,0,0,0));
		
		JLabel title = new JLabel("New Game");
		JPanel inputHolder = new JPanel(new GridLayout(0,1));
		inputHolder.setBorder(new EmptyBorder(150,150,250,150));
		JPanel btnHolder = new JPanel();
		
		JLabel lblP1 = new JLabel("Player 1 Name:");
	    textP1 = new JTextField();
	    JLabel lblP2 = new JLabel("Player 2 Name:");
	    textP2 = new JTextField();
		start = new JButton("Start");
		start.addActionListener(this);
	    
	    gui.add(title);
	    inputHolder.add(lblP1);
	    inputHolder.add(textP1);
	    inputHolder.add(Box.createRigidArea(new Dimension(0,1)));
	    inputHolder.add(lblP2);
	    inputHolder.add(textP2);
	    gui.add(inputHolder);
	    
	    btnHolder.add(start);
	    gui.add(btnHolder,BorderLayout.SOUTH);
	    
	}
	
	public void startGame(String player1, String player2) {
		gui.removeAll();
		gui.repaint();
		gui.setBorder(new EmptyBorder(0,50,0,50));
		
		Board board = new Board();
		Player p1 = new Player(player1, Colour.WHITE);
		Player p2 = new Player(player2, Colour.BLACK);
		
		JPanel player1Info = new JPanel(new GridLayout(3,3));
		player1Info.setBorder(new EmptyBorder(0,0,550,0));
		JLabel player1Num = new JLabel("Player 1");
		JLabel player1Name = new JLabel(player1);
		JLabel player1Col = new JLabel(p1.getColour().toString());
		
		JPanel player2Info = new JPanel(new GridLayout(3,3));
		player2Info.setBorder(new EmptyBorder(0,0,550,0));
		JLabel player2Num = new JLabel("Player 2");
		JLabel player2Name = new JLabel(player2);
		JLabel player2Col = new JLabel(p2.getColour().toString());
		
		JPanel boardHolder = new JPanel(new GridLayout(8,8));
		Boolean whiteCell = true;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				cell[i] = new JButton();
				cell[i].setName(i + "" + j);
				if(whiteCell) {
					cell[i].setBackground(Color.WHITE);
					whiteCell = false;
				} else {
					cell[i].setBackground(Color.BLACK);
					whiteCell = true;
				}
				cell[i].addActionListener(this);
				boardHolder.add(cell[i], new EmptyBorder(0,0,0,0));
			}
		}
		
		player1Info.add(player1Num);
		player1Info.add(player1Name);
		player1Info.add(player1Col);
		
		player2Info.add(player2Num);
		player2Info.add(player2Name);
		player2Info.add(player2Col);
		
		gui.add(player1Info, BorderLayout.WEST);
		gui.add(player2Info, BorderLayout.EAST);
		gui.add(boardHolder, BorderLayout.CENTER);
	
	}
	
	public void cellClick(String name) {
		JOptionPane.showMessageDialog(null, cell[5].getName());
	}

@SuppressWarnings("unused")
public static void main(String[] args) {
		Game g = new Game();
	}
}
