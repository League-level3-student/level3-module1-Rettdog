package _03_IntroToStacks;

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
			 * is erased from the JLabel. Save that deleted character onto a Stack of
			 * Characters.
			 * 
			 * Choose a key to be the Undo key. Make it so that when that key is pressed,
			 * the top Character is popped off the Stack and added back to the JLabel.
			 * 
			 */
	JFrame frame = new JFrame();
	 JPanel/*Hel
	
	
	
	dhfyysectcst
	h
	tf
	y
	y
	e
	4X46hn
	
	
	
	
	lo*/ panel = new JPanel();
	JLabel label = new JLabel();
	Stack<Character> text = new Stack<Character>();
	Stack<Character> undos = new Stack<Character>();

	public static void main(String[] args) {

		new _02_TextUndoRedo().start();
	}

	public void start() {
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// label.setText(text);
		char letter = e.getKeyChar();
		System.out.println(letter);
		int code = e.getKeyCode();
		System.out.println(code);
		if (code == 8) {
			if (text.size() != 0) {
				undos.push(text.pop());
			}
		} else if (code == 17) {
			if (undos.size() != 0) {
				text.push(undos.pop());
			}
		} else {
			text.push(letter);
		}
		label.setText("");
		label.setText(getTextFromStack(text));
		frame.pack();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	String getTextFromStack(Stack stack) {
		String text = "";
		for (int i = 0; i < stack.size(); i++) {
			text += "" + stack.get(i);
		}
		return text;
	}

}
