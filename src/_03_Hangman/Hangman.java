package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();

	String werd = "";
	int lives = 10;
	String w = "";
	String Live = "Lives: " + lives + " ";
	Stack<String> words = new Stack<String>();

	public static void main(String[] args) {
		Hangman game = new Hangman();
		game.game();
	}

	void setup() {
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.addKeyListener(this);
		String games = JOptionPane.showInputDialog("How many times would you like to play? (1-100)");
		for (int i = 0; i < games.length(); i++) {
			words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
			System.out.println(words.size());

		}

	}

	void game() {
		setup();
		werd = words.pop();
		for (int i = 0; i < werd.length(); i++) {
			w += "_";
		}
		label.setText(Live + w);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		String s = "" + arg0.getKeyChar();
		if (werd.contains(s)) {
			w = w.substring(0, werd.indexOf(s)) + arg0.getKeyChar() + w.substring(werd.indexOf(s) + 1);
			while(werd.indexOf(s)>-1) {
				w = w.substring(0, werd.indexOf(s, werd.indexOf(s)+1)) + arg0.getKeyChar() + w.substring(werd.indexOf(s,werd.indexOf(s)) + 1);
			}
			System.out.println(w);
			label.setText(Live + w);
		} else {
			lives = lives - 1;
			Live = "Lives: " + lives + " ";
			label.setText(Live + w);
		}
		if (lives == 0) {
			JOptionPane.showMessageDialog(null, "Game Over! The word was " + werd + "!" );
		}
		if (w == werd) {
			game();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
