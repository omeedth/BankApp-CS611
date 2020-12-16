package Main.Accounts;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class for administrators
 * 
 */

/* External Imports */
import java.text.ParseException;

/* Internal Imports */
import Main.Records.AccountEntry;
import Main.Users.Manager;

public class AdministrativeAccount extends ManagerAccount {
    
    /* Data Members */

    /* Constructors */

    public AdministrativeAccount() {
		super();
    }
    
    public AdministrativeAccount(Manager accountHolder) {
        super(accountHolder);
    }

	public AdministrativeAccount(AccountEntry accountEntry) throws ParseException {
		super(accountEntry);
	}

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */

    
}
