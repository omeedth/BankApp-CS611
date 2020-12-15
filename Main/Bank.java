package Main;

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
import Main.Utility.FileParserUtility;
import Main.Records.RecordEntry;
import Main.Records.UserEntry;
import Main.Records.History;

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
     * @return
     */
    public int generateUserID() {
        return (int) (Math.random() * Integer.MAX_VALUE);
    }

    /**
     * 
     * @param username
     * @return - whether or not the username already exists
     */
    public boolean userExists(String username) {
        List<String> lines = FileParserUtility.getLines(UserEntry.filepath);
        for (String line : lines) {
            HashMap<String,Object> userRecordData = new UserEntry(line).getRecordData();
            if (username.equalsIgnoreCase(userRecordData.getOrDefault("username", null).toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param username
     * @param password
     * @return - whether or not the username, password combination exists in the set of users
     */
    public boolean validateUser(String username, String password) {
        List<String> lines = FileParserUtility.getLines(UserEntry.filepath);
        for (String line : lines) {
            HashMap<String,Object> userRecordData = new UserEntry(line).getRecordData();
            String hashedPassword = Integer.toString(password.hashCode());
            if (username.equalsIgnoreCase(userRecordData.getOrDefault("username", "").toString()) && hashedPassword.equalsIgnoreCase(userRecordData.getOrDefault("hashedPassword", "").toString())) {
                return true;
            }
        }
        return false;
    }
    
    public void addToHistory(RecordEntry entry) {
    	bankRecord.addEntry(entry);
    }
    
}
