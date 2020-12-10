package Main.Display;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining the Display for the ATM
 * 
 */

/* External Imports */
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Internal Imports */
// import Main.FancyATM;
import Main.Display.Pages.LoginPage;
import Main.Display.Pages.Page;
import Main.Requests.*;
import Main.Utility.Listener;

public class Display extends JFrame implements ActionListener, Listener {

    /* Static/Final Variables */
    private static final long serialVersionUID = 6324764035158949832L;
    
    /* Data Members */
    private Request currentRequest;
    private Page currentPage;
    private boolean isRunning;

    /* Constructors */

    public Display(Page page) {
        super();
        this.setCurrentPage(page);
        this.init();
    }

    public Display() {
        this(new LoginPage());        
    }

    /* Accessor Methods */

    public Request getCurrentRequest() {
        return currentRequest;
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    /* Mutator Methods */

    public void setCurrentRequest(Request currentRequest) {
        this.currentRequest = currentRequest;
    }

    public void setCurrentPage(Page currentPage) {
        assert currentPage != null;
        this.currentPage = currentPage;
        this.getContentPane().add(this.currentPage);
        this.currentPage.addListener(this);
    }

    public void startRunning() {
        this.isRunning = true;
    }

    public void stopRunning() {
        this.isRunning = false;
    }

    /* Logic Methods */

    /**
     * Initializes all listeners, and other necessary variables for the display
     */
    public void init() {
        
    }

    /**
     * 
     */
    // public void waitForAction() {

    //     /* Start the display */
    //     startRunning();

    //     /* Wait for actions on the current page */
    //     while (this.isRunning) {

    //         this.setCurrentRequest(this.getCurrentPage().getCurrentRequest());

    //     }

    // }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Action: " + e);
    }

    @Override
    public void update(Object obj) {
        // TODO Auto-generated method stub
        System.out.println("Object: " + obj);
    }

}
