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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* Internal Imports */
import Main.Users.User;
import Main.Bank;
import Main.Records.Recordable;

public abstract class Account implements Recordable {
	
	//TODO: Accounts must be able to be loaded from file
	public static int accountCount = 0;
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
        accountID = accountCount;
        dateCreated = new Date(System.currentTimeMillis());
		accountCount++;
		allAccounts.add(this);
    }
    
    public Account(int id, Date creationDate) {
		bank = null;
		accountID = id;
		dateCreated = creationDate;
		System.out.println("Account Created!");
		allAccounts.add(this); // TODO: Check later
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
        data.add(Integer.toString(accountID));
        data.add(dateCreated.toString());
        data.add(this.getClass().getSimpleName());

        if (this instanceof ClientAccount) {
            ClientAccount clientAccount = (ClientAccount) this;
            data.add(Integer.toString(clientAccount.getAccountHolder().getId()));
            data.add(clientAccount.getCurrencyType());
            data.add(Double.toString(clientAccount.getAccountBalance().getQuantity()));
        } else if (this instanceof ManagerAccount) { 
            ManagerAccount managerAccount = (ManagerAccount) this;
            data.add(Integer.toString(managerAccount.getAccountHolder().getId()));
            data.add("null");
            data.add("0");
        } else {
            data.add("");
            data.add("null");
            data.add("0");
        }

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