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

public class Login extends Request {
    
    /* Data Members */
    private String username;
    private String password;

    /* Constructors */

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Login() {
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

        System.out.println("Logging in...");
        boolean userRecordExist = bank.validateUser(username, password);
        if (userRecordExist) {
            System.out.println("Username Password Combo Exists!");
        } else {
            System.out.println("Username Password Combo doesn\'t exist!");
            status = -1;
        }
        setFlag(status);
        return status;
    }

}
