package Main.Display.Pages;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Abstract class defining a page (GUI page for the ATM)
 * 
 */

/* External Imports */
import javax.swing.*;
import java.awt.event.*;

/* Internal Imports */
import Main.FancyATM;
import Main.Requests.*;

public abstract class Page {

    /* Data Members */
    private Request currentRequest;

    /* Constructors */

    public Page() {
        this.currentRequest = null;
    }

    /* Accessor Methods */

    public Request getCurrentRequest() {
        return currentRequest;
    }

    /* Mutator Methods */

    public void setCurrentRequest(Request request) {
        this.currentRequest = request;
    }

    /* Logic Methods */
    
}
