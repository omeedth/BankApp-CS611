package Main.Display.Pages;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

import Main.Bank;
import Main.Records.RecordEntry;
import Main.Requests.PageChange;

public class ManagerPage extends Page {
	
	private JButton backButton;
	private Bank bank;
	private ArrayList<JLabel>transcript;
	
	public ManagerPage() {
		this(null);
	}

	public ManagerPage(Bank bank) {
		super();
		this.bank = bank;
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		transcript = new ArrayList<JLabel>();
		for(RecordEntry re : bank.getUsers().getRecordEntries()) {
			transcript.add(new JLabel(re.toString()));
		}
		display();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equals("Back")) {
			setCurrentRequest(new PageChange(new LoginPage()));
		}
	}

	@Override
	public void display() {
		add(backButton);
		for(JLabel j : transcript) {
			add(j);
		}
	}

}
