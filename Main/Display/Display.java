package Main.Display;

import java.util.ArrayList;
import java.util.Collection;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining the Display for the ATM
 * 
 */

/* External Imports */
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import Main.Bank;
import Main.Accounts.Account;
/* Internal Imports */
// import Main.FancyATM;
import Main.Display.Pages.LoginPage;
import Main.Display.Pages.Page;
import Main.Requests.*;
import Main.Users.User;
import Main.Utility.FileParserUtility;
import Main.Utility.Listener;
import Main.Utility.Notifier;

public class Display extends JFrame implements Listener, Notifier {

    /* Static/Final Variables */
    private static final long serialVersionUID = 6324764035158949832L;

    /* Data Members */
    private Request currentRequest;
    private Page currentPage;
    private boolean isRunning;
    private List<Listener> listeners;

    /* Constructors */

    public Display(Page page) {
        super();
        this.listeners = new ArrayList<>();
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

    @Override
    public Collection<Listener> getListeners() {
        return this.listeners;
    }

    /* Mutator Methods */

    @Override
    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    @Override
    public boolean removeListener(Listener listener) {
        return this.listeners.remove(listener);
    }

    @Override
    public void clearListeners() {
        this.listeners.clear();
    }

    public void setCurrentRequest(Request currentRequest) {
        this.currentRequest = currentRequest;
        notifyAllListeners(currentRequest);
    }

    public void setCurrentPage(Page currentPage) {
        assert currentPage != null;
        this.clear();
        this.currentPage = currentPage;
        this.getContentPane().add(this.currentPage);
        this.currentPage.addListener(this);

        /* Temporary Code - TODO: Clean later / Make separate function */
        this.setVisible(true);
        this.revalidate();
        this.repaint();
        this.setVisible(false);
        this.setVisible(true);

    }

    public void startRunning() {
        this.isRunning = true;
    }

    public void stopRunning() {
        this.isRunning = false;
    }

    /* Logic Methods */

    public void changePage(Page page) {
        this.setCurrentPage(page);
    }

    /**
     * Initializes all listeners, and other necessary variables for the display
     */
    public void init() {

    }

    public void clear() {
        this.getContentPane().removeAll();
    }

    @Override
    public void update(Object obj) {
        System.out.println("Update (Display): " + obj);

        /* Check what type of object is is and update accordingly */
        if (obj instanceof Request) {
            setCurrentRequest((Request) obj);
        }        
    }    

}
