package Main.Accounts;


/* 
 *  Author: 
import java.util.Date;
 *  Creation Date: 12/4/2020
 *  Purpose: Abstract class for account types
 *  Pattern: Builder Pattern
 * 
 */

/* External Imports */
import java.util.HashMap;
import java.util.Date;

/* Internal Imports */
import Main.Users.User;
import Main.Bank;

public abstract class Account {
	
	//TODO: Accounts must be able to be loaded from file
	private static int accountTotal = 0;

    /* Data Members */
    public Bank bank;    
	// protected HashMap<String,Boolean> permissions;
	// private String username, password;
	private Date dateCreated;
	private int accountID;


    /* Constructors */
	public Account() {
		bank = null;
		// permissions = new HashMap<String,Boolean>();
		// username = "";
		// password = "";
		accountID = accountTotal;
		accountTotal++;
	}

    /* Accessor Methods */
	public abstract User getAccountHolder();

	// public String getUsername() {
	// 	return username;
	// }
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public int getAccountID() {
		return accountID;
	}

    /* Mutator Methods */

    /* Logic Methods */
	public boolean hasSameHolder(Account account2) {
		return getAccountHolder() == account2.getAccountHolder();
	}
	
	// protected boolean hasPermission(String p) {
	// 	return permissions.containsKey(p) && permissions.get(p);
	// }
	
	// public boolean checkPassword(String passwordInput) {
	// 	return password.equals(passwordInput);
	// }
	
}