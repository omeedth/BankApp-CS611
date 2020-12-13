package Main.Display.Pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Main.Bank;
import Main.Requests.Request;

public class SamplePage extends Page {
	
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
		window.add(sampleButton);
	}
	

}
