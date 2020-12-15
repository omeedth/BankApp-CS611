package Main.Records;

/*
 *  Creation Date: 12/12/2020
 *  Purpose: An individual RecordEntry for Users that will allow functionality to convert into a String for ease of use storing in a file for later
 * 
 */

/* External Imports */
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* Internal Imports */
import Main.Users.User;
import Main.Accounts.Account;

public class AccountEntry extends RecordEntry {

    /* Static/Final Members */
    public static final String filepath = "./Data/Accounts.csv";
    public static final String[] keys = new String[] {"id","creationDate","currencyType","balance"};

    /* Data Members */

    /* Constructors */

    public AccountEntry(String recordString) {
        super(recordString);
    }

    public <T extends Account & Recordable> AccountEntry(T recordableObj) {
        super(recordableObj.toRecordString());
    }

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */    

    @Override
    public String[] getKeys() {
        return keys;
    }

}
