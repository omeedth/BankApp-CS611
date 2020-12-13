package Main.Display;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining the Display for the ATM
 * 
 */

/* External Imports */
import javax.swing.*;

/* Internal Imports */
import Main.FancyATM;
import Main.Display.Pages.LoginPage;
import Main.Display.Pages.Page;
import Main.Display.Pages.SamplePage;
import Main.Requests.*;

public class Display {
    
    /* Data Members */
    private Request currentRequest;
    private Page currentPage;
    private boolean isRunning;
    private JFrame mainWindow;

    /* Constructors */

    public Display(Page page) {
        this.currentPage = page;
        mainWindow = new JFrame();
        mainWindow.setVisible(true);
        page.setWindow(mainWindow);
        page.loadPage();
    }

    public Display() {
    	this(new SamplePage());
    }

    /* Accessor Methods */

    public Request getCurrentRequest() {
        return currentPage.getCurrentRequest();
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    /* Mutator Methods */

    public void setCurrentRequest(Request currentRequest) {
        this.currentRequest = currentRequest;
    }

    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
    }

    public void startRunning() {
        this.isRunning = true;
    }

    public void stopRunning() {
        this.isRunning = false;
    }

    /* Logic Methods */

    /*
     * Displays the login page for users
     * Returns: The next page to go to
     */
    public Page login() {
        return new LoginPage();
    }

    /**
     * 
     */
    public void waitForAction() {

        /* Start the display */
        startRunning();

        /* Wait for actions on the current page */
        while(this.isRunning) {


        }

    }

}
