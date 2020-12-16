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
import java.text.ParseException;
import java.util.ArrayList;

/* Internal Imports */
import Main.Users.User;
import Main.Utility.FileParserUtility;
import Main.Accounts.Account;
import Main.Accounts.AdministrativeAccount;
import Main.Accounts.CheckingsAccount;
import Main.Accounts.SavingsAccount;

public class AccountEntry extends RecordEntry {

    /* Static/Final Members */
    public static final String filepath = "./Data/Accounts.csv";
    public static final String[] keys = new String[] { "id", "creationDate", "accountType", "userId", "currencyType",
            "balance" };

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

    public Account getAccount() {
        Account account = null;

        HashMap<String, Object> recordData = this.getRecordData();
        if (recordData.get("accountType").equals(CheckingsAccount.class.getSimpleName())) {
            try {
                account = new CheckingsAccount(this);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (recordData.get("accountType").equals(SavingsAccount.class.getSimpleName())) {
            try {
                account = new SavingsAccount(this);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (recordData.get("accountType").equals(AdministrativeAccount.class.getSimpleName())) {
            try {
                account = new AdministrativeAccount(this);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return account;
    }

    public User getUser() {
        HashMap<String,Object> recordData = this.getRecordData();
        List<String> lines = FileParserUtility.getLines(UserEntry.filepath);
        for (String line : lines) {
            UserEntry userEntry = new UserEntry(line);
            if(userEntry.getRecordData().get("id").equals(recordData.get("userId"))) {
                return userEntry.getUser();
            }
        }
        return null;
    }

    @Override
    public String[] getKeys() {
        return keys;
    }

}
