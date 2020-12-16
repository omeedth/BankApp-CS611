package Main.Display.Pages;

import java.awt.event.ActionEvent;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining User page (client's accounts)
 * 
 */

/* External Imports */
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/* Internal Imports */
import Main.Users.*;
// import Main.Requests.*;


public class UserPage extends Page {

    /* Static/Final Variables */
    private static final long serialVersionUID = 3627423803935650519L;

    /* Data Members */
    private User user;
    private JButton openAcc;
    private JButton closeAcc;
    private JButton enterAcc;

    /* Constructors */

    public UserPage(User user) {
        this.user = user;
        openAcc = new JButton("Open account");
        closeAcc = new JButton("Close accounts");
        enterAcc = new JButton("Enter accounts");
        this.init();
    }

    /* Accessor Methods */

    public User getUser() {
        return user;
    }    

    public JButton openAcc(){
        return openAcc;
    }

    public JButton closeAcc(){
        return closeAcc;
    }

    public JButton enterAcc(){
        return enterAcc;
    }

    /* Mutator Methods */

    /* Logic Methods */

    public void init() {
        /* Initialize the listeners */
        this.openAcc.addActionListener(this);   
        this.closeAcc.addActionListener(this);
        this.enterAcc.addActionListener(this);
        display();    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String s = e.getActionCommand(); 
        System.out.println("Action Command: " + s);
        if(s.equals("Open account")){
            this.setCurrentRequest(new AccountOpening()); 
        } else if(s.equals("Close accounts")){
            this.setCurrentRequest(new AccountClosing());
        } else if(s.equals("Enter accounts")){
            this.setCurrentRequest(new AccountEntering());
        }
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        this.add(this.openAcc);
        this.add(this.closeAcc);
        this.add(this.enterAcc);
    }
    
}
