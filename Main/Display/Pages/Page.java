package Main.Display.Pages;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Abstract class defining a page (GUI page for the ATM)
 * 
 */

/* External Imports */
// import javax.swing.*;
// import java.awt.event.*;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

import java.util.ArrayList;

/* Internal Imports */
// import Main.FancyATM;
import Main.Requests.*;
import Main.Utility.Listener;
import Main.Utility.Notifier;

public abstract class Page extends JPanel implements ActionListener, Notifier {

    /* Static/Final Members */
    private static final long serialVersionUID = -21000961599094556L;

    /* Data Members */
    private Request currentRequest;
    private List<Listener> listeners;

    /* Constructors */

    public Page() {
        this.currentRequest = null;
        this.listeners = new ArrayList<>();
    }

    /* Accessor Methods */

    public Request getCurrentRequest() {
        return currentRequest;
    }

    @Override
    public List<Listener> getListeners() {
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

    public void setCurrentRequest(Request request) {
        this.currentRequest = request;
        notifyAllListeners(request);
    }

    /* Logic Methods */
    
}
