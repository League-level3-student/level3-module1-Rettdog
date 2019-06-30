package _04_HangMan;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan {
	static Stack<String> words;
	static Utilities util = new Utilities();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	String currentWord;
	ArrayList<Character> text = new ArrayList<Character>();
	public static void main(String[] args) {
		HangMan game = new HangMan();
		getReady();
		game.start();

	}

	void start() {
panel.add(label);
frame.add(panel);
label.setText("");
frame.setVisible(true);
frame.pack();
	}
	
	void beginGame() {
		currentWord=words.pop();
		for(int i =0;i<currentWord.length();i++) {
			text.add('_');
		}
	}
	void checkLetter(char letter) {
		for(int i =0;i<currentWord.length();i++) {
			if(currentWord.charAt(i)==letter) {
				//text.charAt(index)
			}
		}
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
					exists = true;
				}
				randomWord = util.readRandomLineFromFile("dictionary.txt");
			}
		}
	}

}
