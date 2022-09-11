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
	Boolean lose = false;
	String games;
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
		games = JOptionPane.showInputDialog("How many times would you like to play? (1-100)");
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
		for (int i = 0; i < werd.length(); i++) {
			if (arg0.getKeyChar() == werd.charAt(i)) {
				w = w.substring(0, i) + s + w.substring(i + 1);
				lose = true;
			} else {
				lose = false;
			}

			System.out.println(w);
			label.setText(Live + w);

		}
		if (lose == false && lives > 0) {
			lives = lives - 1;
			Live = "Lives: " + lives + " ";
			label.setText(Live + w);
		}

		if (lives == 0 && lose == true) {
			JOptionPane.showMessageDialog(null, "Congrats! You win!");
		} else if (lives == 0 && lose == false) {
			JOptionPane.showMessageDialog(null, "Game Over! The word was " + werd + "!");

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
