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

public abstract class Page extends JPanel implements ActionListener {

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

    public List<Listener> getListeners() {
        return this.listeners;
    }

    public void addListener(Listener listener) {
        this.listeners.add(listener);
        System.out.println("Added Listener Object: " + listener);
    }

    public boolean removeListener(Listener listener) {
        return this.listeners.remove(listener);
    }

    public void clearListeners() {
        this.listeners.clear();
    }

    /* Mutator Methods */

    public void setCurrentRequest(Request request) {
        this.currentRequest = request;
        for (Listener listener : this.listeners) {
            listener.update(request);
        }
    }

    /* Logic Methods */
    
}
