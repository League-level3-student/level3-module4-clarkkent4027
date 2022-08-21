package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel.
	 * 
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	String total = "";

	public static void main(String[] args) {
		_02_TextUndoRedo a = new _02_TextUndoRedo();
		a.setup();

	}

	void setup() {
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.addKeyListener(this);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		Stack<String> text = new Stack<String>();
		Stack<String> delete = new Stack<String>();

		String t = "" + e.getKeyChar();
		total += t;
		System.out.println(e.getKeyChar());
		text.push(t);
		label.setText(total);

		if (e.getSource().equals(e.VK_BACK_SPACE)) {
			total = total.substring(0, total.length() - 1);
			System.out.println(total);
			label.setText(total.substring(0, total.length() - 1));
			delete.push(text.pop());

		}
		if (e.getSource().equals(e.VK_ENTER)) {
			total += delete.pop();
			label.setText(total);
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
