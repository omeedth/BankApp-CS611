package Main.Display.Pages;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

import Main.Requests.LoanReview;
import Main.Users.Manager;

public class LoanReviewPage extends Page {

	ArrayList<JPanel> reviewPanels;
	Manager manager;
	
	public LoanReviewPage() {
		reviewPanels = new ArrayList<JPanel>();
		for(LoanReview r : manager.getUncheckedLoans()) {
			reviewPanels.add(createReviewPanel(r));
		}
		display();
	}
	
	public JPanel createReviewPanel(LoanReview review) {
		JPanel p = new JPanel();
		p.add(new JLabel(review.getClient().getUsername()));
		p.add(new JLabel(review.getCollateral()));
		p.add(new JLabel(String.valueOf(review.getAmountRequested().getQuantity())));
		return p;
	}
	
	public Manager getManager() {
		return manager;
	}
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		for(JPanel p : reviewPanels) {
			BoxLayout layout = new BoxLayout(this, 1);
			setLayout(layout);
			add(p);
		}
	}

}
