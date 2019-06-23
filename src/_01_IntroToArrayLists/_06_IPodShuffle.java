package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	static ArrayList<Song> songs;	
	static JFrame frame;
	static JPanel panel;
	static JButton playButton;
	Song demosong;
	Song rocksong;
	Song globsong;
	Song lilglob;
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		songs = new ArrayList<Song>();
		frame = new JFrame();
		panel = new JPanel();
		playButton = new JButton("Play");
		
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	
	public static void main(String[] args) {
		_06_IPodShuffle player = new _06_IPodShuffle();
		player.Start();
		
	}
	public void Start() {
		new _06_IPodShuffle();
		playButton.addActionListener(this);
		panel.add(playButton);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		demosong = new Song("demo.mp3");
		rocksong = new Song("rocksong.m4a");
		globsong = new Song("Globglogabgalab.mp3");
		lilglob = new Song("Lil Globglogabgalab.mp3");
		songs.add(demosong);
		songs.add(globsong);
		songs.add(lilglob);
		
		//songs.get(0).play();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Song playsong = getRandomSound(songs);
		for(Song song : songs) {
			song.stop();
		}
		playsong.setDuration(10);
		playsong.play();
		
	}
	public Song getRandomSound(ArrayList<Song> songs) {
		Random randy = new Random();
		System.out.println(songs.size());
		int randysnumber = randy.nextInt(songs.size());
		System.out.println(randysnumber);
		Song returnsong = songs.get(randysnumber);
		return returnsong;
		
	}

	
}