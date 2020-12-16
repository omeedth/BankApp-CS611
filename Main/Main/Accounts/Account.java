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
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/* Internal Imports */
import Main.Users.User;
import Main.Bank;
import Main.Records.Recordable;

public abstract class Account implements Recordable {
	
	//TODO: Accounts must be able to be loaded from file
	private static int accountTotal = 0;
	private static ArrayList<Account>allAccounts = new ArrayList<Account>();

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
		allAccounts.add(this);
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
	
	public Bank getBank() {
		return bank;
	}
	
	public abstract String getAccountType();

    /* Mutator Methods */
	public void setBank(Bank bank) {
		this.bank = bank;
	}

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
    
    @Override
    public String toRecordString() {
        List<String> data = new ArrayList<>();

        /* Add All Data */
        

        return String.join(",", data);
    }
    
    public static Account getAccountByID(int id) {
    	for(Account a : allAccounts) {
    		if(a.getAccountID() == id) {
    			return a;
    		}
    	}
    	return null;
    }
	
}