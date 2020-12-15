package Main.Users;


/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Abstract classes for users
 * 
 */

/* External Imports */
import java.util.ArrayList;

/* Internal Imports */
import Main.Accounts.Account;

public abstract class User {
	
	private static int userTotal = 0;

    /* Data Members */
    private int id;
    private String name;
    private String username;
    private int hashedPassword;
    private ArrayList<Account>accounts;

    /* Constructors */

    public User() {
    	accounts = new ArrayList<Account>();
    	id = userTotal;
    	userTotal++;
    }

    /* Accessor Methods */

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public int getHashedPassword() {
        return hashedPassword;
    }
    
    public ArrayList<Account> getAccounts(){
    	return accounts;
    }

    /* Mutator Methods */

    /* Logic Methods */
    
    public void addAccount(Account account) {
    	accounts.add(account);
    }
    
}
