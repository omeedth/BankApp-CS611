package Main.Display.Pages;

import javax.swing.*;

public class LabeledTextField extends JPanel {
	public JLabel label;
	public JTextField textField;
	public LabeledTextField() {
		this("", 0);
	}
	
	public LabeledTextField(String labelText, int size) {
		super();
		label = new JLabel(labelText);
		textField = new JTextField(size);
		add(label);
		add(textField);
	}
	
	public String getText() {
		return textField.getText();
	}
	
}
