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

import Main.Records.History;
import Main.Records.RecordEntry;
/* Internal Imports */
import Main.Users.*;

public class Bank {

    /* Data Members */
    private List<User> users;
    private HashMap<String,User> userMap;
    private History bankRecord;

    /* Constructors */

    public Bank() {
        users = new ArrayList<>();
        userMap = new HashMap<>();
        bankRecord = new History();
    }

    /* Accessor Methods */

    public List<User> getUsers() {
        return users;
    }
    
    public History getBankRecord() {
    	return bankRecord;
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
    
    public void addToHistory(RecordEntry entry) {
    	bankRecord.addEntry(entry);
    }
    
}
