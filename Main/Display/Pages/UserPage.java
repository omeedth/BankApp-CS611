package Main.Display.Pages;

import java.awt.event.ActionEvent;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining User page (client's accounts)
 * 
 */

/* External Imports */
// import java.awt.event.ActionEvent;

/* Internal Imports */
import Main.Users.*;

public class UserPage extends Page {

    /* Static/Final Variables */
    private static final long serialVersionUID = 3627423803935650519L;

    /* Data Members */
    private User user;

    /* Constructors */

    public UserPage(User user) {
        this.user = user;
    }

    /* Accessor Methods */

    public User getUser() {
        return user;
    }    

    /* Mutator Methods */

    /* Logic Methods */

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
    
}
