package Main.Accounts;


/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Abstract class for accounts for managers/administrators
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Users.Manager;

public abstract class ManagerAccount extends Account {
    
    /* Data Members */
	private Manager accountHolder;

    /* Constructors */
	public ManagerAccount() {
		super();
	}

    /* Accessor Methods */
	public Manager getAccountHolder() {
		return accountHolder;
	}

    /* Mutator Methods */

    /* Logic Methods */

}
