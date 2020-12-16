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
import Main.FancyATM;
import Main.Records.UserEntry;
import Main.Users.Client;
import Main.Users.User;
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
    public int performRequest(FancyATM atm) {
        // TODO - 1. Validates the credentials using Bank's backend
        //        2. Returns status variable whether or not it's okay to change page, etc.
        //        3. Sets the flag of this request to the status (same as the return)
        int status = 0;

        System.out.println("Registering...");
        Bank bank = atm.getBank();
        boolean userRecordExist = bank.userExists(username);
        if (userRecordExist) {
            status = 1;
            System.out.println("User Exists!");
        } else {
            System.out.println("User doesn\'t exist!");
            Client client = new Client(username, password.hashCode());
            FileParserUtility.writeLine(new UserEntry(client), UserEntry.filepath, true);
            status = -1;
        }
        setFlag(status);
        return status;
    }

}
