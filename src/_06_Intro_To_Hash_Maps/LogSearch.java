package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LogSearch implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JTextField text;
	static LogSearch searcher;
	HashMap<Integer, String> log = new HashMap<Integer, String>();
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */

	public static void main(String[] args) {
		searcher = new LogSearch();
		searcher.start();
	}

	void start() {
		frame = new JFrame();
		panel = new JPanel();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		text = new JTextField();
		button1.setText("Add Entry");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		panel.add(button1);
		button2.setText("Search by ID");
		panel.add(button2);
		button3.setText("View List");
		panel.add(button3);
		button4.setText("Remove Entry");
		panel.add(button4);
		panel.add(text);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}

	public void addEntry() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Please input an ID number"));
		String person = JOptionPane
				.showInputDialog("Please input the name of\nthe person who corresponds to\nthe ID entered previously.");

		text.setText(person + " has been added");
		log.put(id, person);
	}

	public void searchID() {
		int id = Integer.parseInt(
				JOptionPane.showInputDialog("Please input the ID number of the\nperson you are trying to find."));
		if (log.containsKey(id)) {
			String person = log.get(id);
			text.setText(log.get(id));
			// JOptionPane.showMessageDialog(null, log.get(id));
		} else {
			text.setText("The ID " + id + " has not been found.");
			// JOptionPane.showMessageDialog(null, "The ID " + id + " has not been found.",
			// null,JOptionPane.ERROR_MESSAGE);
		}
	}

	public void viewList() {
		String all = "  |  ";
		for (int id : log.keySet()) {
			all += "Name: " + log.get(id) + " ID: " + id + "  |  ";
		}
		text.setText(all);
		//JOptionPane.showMessageDialog(null, all);
	}
	 public void removeEntry() {
		 int id = Integer.parseInt(JOptionPane.showInputDialog("Please input the id to be removed"));
		 if(log.containsKey(id)) {
			 text.setText(log.get(id)+" has been removed.");
			 log.remove(id);
			 
		 }else {
			 text.setText("ID "+id+" not found.");
		 }
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(button1)) {
			searcher.addEntry();
		} else if (e.getSource().equals(button2)) {
			searcher.searchID();
		} else if (e.getSource().equals(button3)) {
			searcher.viewList();
		} else if(e.getSource().equals(button4)) {
			searcher.removeEntry();
		}
		frame.pack();
	}
}
