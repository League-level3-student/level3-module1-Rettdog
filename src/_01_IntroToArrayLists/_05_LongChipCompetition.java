package _01_IntroToArrayLists;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class _05_LongChipCompetition {
	/**
	 * The Beatles are eating lunch and playing a game to see who has the longest
	 * chip. (In England, french fries are called "chips".) * Find the Beatle with
	 * the longest chip. You may not edit the Chip or Beatle classes. Make sure to
	 * initialize The Beatles before you start your search. *
	 **/
	private ArrayList<Beatle> theBeatles = new ArrayList<Beatle>();

	public static void main(String[] args) {
		_05_LongChipCompetition lcc = new _05_LongChipCompetition();
		lcc.initializeBeatles();
		ArrayList<Beatle> beatles = lcc.getTheBand();
		Beatle winner=beatles.get(0);
		int winningLength=0;
		for(int i =0;i<lcc.getTheBand().size()-1;i++) {
			for(Chip chip :beatles.get(i).getChips()) {
				if(chip.getLength()>winningLength) {
					winningLength=(int) chip.getLength();
					winner=beatles.get(i);
				}
			}
		}
		System.out.println(winner.getName()+" won with his chip of a length of "+winningLength);
	}
	
	private void initializeBeatles() {
		Beatle george = new Beatle("George");
		Beatle john = new Beatle("John");
		Beatle paul = new Beatle("Paul");
		Beatle ringo = new Beatle("Ringo");
		theBeatles.add(george);
		theBeatles.add(john);
		theBeatles.add(paul);
		theBeatles.add(ringo);
	}
	
	public ArrayList<Beatle> getTheBand(){
		return theBeatles;
	}
}

class Beatle {
	private String name;
	private ArrayList<Chip> chips = new ArrayList<Chip>();

	public Beatle(String name) {
		this.name = name;
		initializePlateOfChips();
	}

	private void initializePlateOfChips() {
		int numberOfChips = new Random().nextInt(100);
		for (int i = 0; i < numberOfChips; i++) {
			chips.add(new Chip(new Random().nextDouble() * 100));
		}
	}

	public ArrayList<Chip> getChips() {
		return this.chips;
	}

	public String getName() {
		return this.name;
	}
}

class Chip {
	private double length;

	public double getLength() {
		return length;
	}

	Chip(double d) {
		this.length = d;
	}
}
