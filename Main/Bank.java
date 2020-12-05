package Main;

import java.util.ArrayList;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining the Bank
 * 
 */

/* External Imports */
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/* Internal Imports */
import Main.Users.*;

public class Bank {

    /* Data Members */
    private List<User> users;
    private HashMap<String,User> userMap;

    /* Constructors */

    public Bank() {
        users = new ArrayList<>();
        userMap = new HashMap<>();
    }

    /* Accessor Methods */

    public List<User> getUsers() {
        return users;
    }

    /* Mutator Methods */

    /* Logic Methods */

    /**
     * 
     * @param username
     * @param password
     * @return - whether or not the username, password combination exists in the set of users
     */
    public boolean validateUser(String username, String password) {
        return false;
    }
    
}
