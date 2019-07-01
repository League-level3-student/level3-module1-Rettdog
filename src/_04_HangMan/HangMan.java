package _04_HangMan;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	static Stack<String> words;
	static Stack<String> solved;
	static Utilities util = new Utilities();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	String currentWord;
	ArrayList<Character> text = new ArrayList<Character>();
	static HangMan game;
	int lives;
	int score=0;
	public static void main(String[] args) {
		game = new HangMan();
		getReady();
		game.start();
game.beginGame();
	}

	void start() {
		panel.add(label);
		frame.add(panel);
		frame.addKeyListener(this);
		label.setText("");
		label.setFont(label.getFont().deriveFont(100f));
		frame.setTitle("Hangman");
		frame.setVisible(true);
		frame.pack();
	}

	void beginGame() {
	lives = 5;
	frame.setTitle("Hangman: "+lives+" lives left");
		currentWord = words.pop();
		for (int i = 0; i < currentWord.length(); i++) {
			
			text.add('_');
		}
		label.setText(text.toString());
		frame.pack();
		
	}

	boolean checkLetter(char letter) {
		boolean bool = false;
		for (int i = 0; i < currentWord.length(); i++) {
			System.out.println(currentWord.charAt(i)+" vs "+letter);
			System.out.println(currentWord.charAt(i) == letter);
			if (currentWord.charAt(i) == letter) {
				text.set(i, letter);
				System.out.println(text.get(i));
				bool = true;
			}	
		}
		label.setText(text.toString());
		frame.setTitle("Hangman: "+lives+" lives left");
		frame.pack();
		return bool;
	}
	boolean winChecker(String actualWord, ArrayList<Character> list) {
		if(game.wordToArrayLikeThing(actualWord).equals(list.toString())) {
			return true;
		}
		
		return false;
		
	}
	String wordToArrayLikeThing(String word) {
		String arrayThing = "[";
		for(int i = 0;i<word.length();i++) {
			arrayThing= arrayThing + word.charAt(i);
			if(i!=word.length()-1) {
				arrayThing=arrayThing + ", ";
			}
		}
		arrayThing=arrayThing+"]";
		return arrayThing;
	}

	static void getReady() {
		int wordCount = Integer.parseInt(JOptionPane
				.showInputDialog("Give me a number less than " + util.getTotalWordsInFile("dictionary.txt")));
		String randomWord = util.readRandomLineFromFile("dictionary.txt");

		for (int i = 0; i < wordCount; i++) {
			boolean exists = false;

			words = new Stack<String>();
			while (!exists) {
				if (!words.contains(randomWord)) {
					words.push(randomWord);
					System.out.println(randomWord);
					exists = true;
				}
				randomWord = util.readRandomLineFromFile("dictionary.txt");
			}
		}
	}
	void lose() {
		String solvedWords = "\n";
		for(int i =0;i<solved.size();i++) {
			solvedWords+=solved.pop()+"\n";
		}
		int action =JOptionPane.showOptionDialog(null, "You lost. Your score is "+score+"\nYou solved the following words:"+solvedWords+"\nWould you like to play again?", "HangMan", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
if(action ==0) {
	score=0;
	for(char car : text) {
		text.remove(car);
	}
	game.beginGame();
}
	}
	void win() {
		score++;
		int action =JOptionPane.showOptionDialog(null, "Your score is "+score+". Move on to next level", "HangMan", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
	if(action==0) {
		game.beginGame();
	}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(!game.checkLetter(e.getKeyChar())) {
			lives-=1;
			frame.setTitle("Hangman: "+lives+" lives left");
			
			if(lives<=0) {
				game.lose();
			}
		}else if(winChecker(currentWord,text)) {
			frame.setTitle("Hangman: You Win!!");
			game.win();
			solved.push(currentWord);
		}
		frame.pack();
		System.out.println(e.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
