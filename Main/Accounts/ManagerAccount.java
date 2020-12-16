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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import Main.Records.AccountEntry;

public abstract class ManagerAccount extends Account {

	/* Data Members */
	private Manager accountHolder;

	/* Constructors */
	public ManagerAccount() {
		super();
	}

	public ManagerAccount(Manager accountHolder) {
		super();
		this.accountHolder = accountHolder;
	}

	public ManagerAccount(AccountEntry accountEntry, Manager accountHolder) throws ParseException {
		super((int) accountEntry.getRecordData().get("id"), new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.ENGLISH).parse(((String) accountEntry.getRecordData().get("creationDate")))); // new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.ENGLISH).parse(((String) accountEntry.getRecordData().get("creationDate")))
		accountHolder = accountHolder;
	}

    /* Accessor Methods */
	public Manager getAccountHolder() {
		return accountHolder;
	}

    /* Mutator Methods */
	public void setAccountHolder(Manager m) {
		accountHolder = m;
	}

    /* Logic Methods */

}
