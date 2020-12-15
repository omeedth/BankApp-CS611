package Main.Requests;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class for login requests
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Bank;
import Main.Records.UserEntry;
import Main.Users.Client;
import Main.Utility.FileParserUtility;

public class Register extends Request {
    
    /* Data Members */
    private String username;
    private String password;

    /* Constructors */

    public Register(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Register() {
        this("","");
    }

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */

    @Override
    public int performRequest(Bank bank) {
        // TODO - 1. Validates the credentials using Bank's backend
        //        2. Returns status variable whether or not it's okay to change page, etc.
        //        3. Sets the flag of this request to the status (same as the return)
        int status = 0;

        System.out.println("Registering...");
        boolean userRecordExist = bank.userExists(username);
        if (userRecordExist) {
            System.out.println("User Exists!");
        } else {
            System.out.println("User doesn\'t exist!");
            Client client = new Client(bank.generateUserID(), username, password.hashCode());
            FileParserUtility.writeLine(new UserEntry(client), UserEntry.filepath, true);
        }
        setFlag(status);
        return status;
    }

}
