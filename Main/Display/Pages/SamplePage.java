package Main.Display.Pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Main.Bank;
import Main.FancyATM;
import Main.Requests.Request;

public class SamplePage extends Page {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	class SampleRequest extends Request {

		@Override
		public int performRequest(Bank bank) {
			System.out.println("Request performed");
			this.setFlag(1);
			return this.getFlag();
		}
		
	}
	
	class SampleAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Request r = new SampleRequest();
			setCurrentRequest(r);
		}
		
	}
	
	public SamplePage() {
		
	}
	
	public void loadPage() {
		JButton sampleButton = new JButton("Sample");
		sampleButton.addActionListener(new SampleAction());
		this.add(sampleButton);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	

}
