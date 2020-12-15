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
import Main.Records.*;
import Main.Requests.*;

public class Bank {

    /* Data Members */
	private Manager manager;
    private List<User> users;
    private HashMap<String,User> userMap;
    private History bankRecord;

    /* Constructors */

    public Bank() {
    	manager = new Manager();
        users = new ArrayList<>();
        userMap = new HashMap<>();
        bankRecord = new History();
    }

    /* Accessor Methods */
    
    public Manager getManager() {
    	return manager;
    }

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
    
    public Manager findLoanHandler() {
    	return manager;
    }

	public void sendLoanApplicationInformation(LoanReview review) {
		Manager loanHandler = findLoanHandler();
		loanHandler.addLoanToApprove(review);
	}
	
	public User findUser(String username) {
		return userMap.get(username);
	}
	
	public boolean usernameExists(String username) {
		return findUser(username) != null;
	}
	
	public void addUser(User user) {
		users.add(user);
		userMap.put(user.getUsername(), user);
	}
    
}
