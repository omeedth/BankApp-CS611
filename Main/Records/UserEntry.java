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
import Main.Utility.FileParserUtility;
import Main.Users.Client;
import Main.Users.Manager;

public class UserEntry extends RecordEntry {

    /* Static/Final Members */
    public static final String filepath = "./Data/Users.csv";
    public static final String[] keys = new String[] {"id","accountType","name","username","hashedPassword","accounts"};

    /* Data Members */

    /* Constructors */

    public UserEntry(String recordString) {
        super(recordString);
    }

    public <T extends User & Recordable> UserEntry(T recordableObj) {
        super(recordableObj.toRecordString());
    }

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */    

    @Override
    public boolean validRecordString(String recordString) {
        System.out.println("UserEntry Record String Validator...");
        String[] values = recordString.split(",");
        String[] keys = this.getKeys();
        boolean sameLengthOrGreater = keys.length == values.length + 1 || keys.length == values.length;
        return sameLengthOrGreater;
    }

    public User getUser() {
        HashMap<String,Object> recordData = this.getRecordData();
        if (recordData.get("accountType").equals("Client")) {
            Client client = new Client(Integer.parseInt((String) recordData.get("id")), (String) recordData.get("name"), (String) recordData.get("username"), Integer.parseInt((String) recordData.get("hashedPassword")));

            /* Search for accounts this User has */
            List<String> accounts = FileParserUtility.getLines(AccountEntry.filepath);
            for (String accountId : ((String) recordData.get("accounts")).split("~")) {                
                int index = accounts.indexOf(accountId);
                if (index != -1) {
                    client.addAccount(new AccountEntry(accounts.get(index)).getAccount());
                }
            }

             return client;
        } else if (recordData.get("accountType").equals("Manager")) {
            Manager manager = new Manager((String) recordData.get("name"), (String) recordData.get("username"), (Integer) recordData.get("hashedPassword"));
            return manager;
        } else {
            return null;
        }
    }

    @Override
    public String[] getKeys() {
        return keys;
    }

}
