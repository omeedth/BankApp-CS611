package Main.Display.Pages;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining User page (client's accounts)
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Users.*;

public class UserPage extends Page {

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
    
}
